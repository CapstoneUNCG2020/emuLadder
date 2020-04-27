package com.uncg.emuLadder.sanitizer;

import com.uncg.emuLadder.util.XSSUtil;
import org.springframework.stereotype.Component;

/**
 * Sanitizer for simple String input.
 */
@Component
public class StringSanitizer implements ISanitizer<String> {
    @Override
    public String sanitize(String requestData) {
        return XSSUtil.stripXSS(requestData, String.class);
    }
}
