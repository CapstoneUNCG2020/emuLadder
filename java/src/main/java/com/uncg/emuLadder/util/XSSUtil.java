package com.uncg.emuLadder.util;

import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public final class XSSUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(XSSUtil.class);

    private XSSUtil() {
    }

    public static String stripXSS(Object object) {
        if (object == null) {
            LOGGER.info("Object is null, returning Empty String.");
            return "";
        } else {
            String value = (new GsonBuilder()).disableHtmlEscaping().create().toJson(object);
            return stripXSS(value);
        }
    }

    public static <T> T stripXSS(Object object, Type typeOfReturn) {
        return (new GsonBuilder()).disableHtmlEscaping().create().fromJson(stripXSS(object), typeOfReturn);
    }

    private static String stripXSS(String ipValue) {
        if (StringUtils.isEmpty(ipValue)) {
            LOGGER.info("Input String is blank, returning Empty String.");
            return "";
        } else {
            String value = ipValue.replaceAll("", "");
            Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", 2);
            value = scriptPattern.matcher(value).replaceAll("");
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\'(.*?)\\'", 42);
            value = scriptPattern.matcher(value).replaceAll("");
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", 42);
            value = scriptPattern.matcher(value).replaceAll("");
            scriptPattern = Pattern.compile("<script>", 2);
            value = scriptPattern.matcher(value).replaceAll("");
            scriptPattern = Pattern.compile("</script>", 2);
            value = scriptPattern.matcher(value).replaceAll("");
            scriptPattern = Pattern.compile("<script(.*?)>", 42);
            value = scriptPattern.matcher(value).replaceAll("");
            scriptPattern = Pattern.compile("eval\\((.*?)\\)", 42);
            value = scriptPattern.matcher(value).replaceAll("");
            scriptPattern = Pattern.compile("expression\\((.*?)\\)", 42);
            value = scriptPattern.matcher(value).replaceAll("");
            scriptPattern = Pattern.compile("javascript:", 2);
            value = scriptPattern.matcher(value).replaceAll("");
            scriptPattern = Pattern.compile("vbscript:", 2);
            value = scriptPattern.matcher(value).replaceAll("");
            scriptPattern = Pattern.compile("onload(.*?)=", 42);
            value = scriptPattern.matcher(value).replaceAll("");
            return value;
        }
    }
}
