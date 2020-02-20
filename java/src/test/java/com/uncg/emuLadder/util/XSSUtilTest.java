package com.uncg.emuLadder.util;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class XSSUtilTest {

    private static String XSS;
    private static String OBJ;

    private String response;

    @BeforeClass
    public static void setUpBeforeClass() {
        XSS = "<script>sample script</script>";
        OBJ = "obj";
    }

    /**
     * Used to convert a String to the JSON representation.
     * @param s - String
     * @return - String
     */
    private String toString(String s) {
        return "\"" + s + "\"";
    }

    @Test
    public void testStripXSSNullObject() {
        response = XSSUtil.stripXSS(null);

        assertTrue(response.isEmpty());
    }

    @Test
    public void testStripXSSEmptyString() {
        response = XSSUtil.stripXSS("");

        assertEquals(toString(""), response);
    }

    @Test
    public void testStringXSS() {
        response = XSSUtil.stripXSS("string");

        assertEquals(toString("string"), response);
    }

    @Test
    public void testStripXSSContainsXSS() {
        response = XSSUtil.stripXSS(OBJ + XSS);

        assertEquals(toString(OBJ), response);
    }

    @Test
    public void testStripXSSNoXSS() {
        response = XSSUtil.stripXSS(OBJ);

        assertEquals(toString(OBJ), response);
    }

    @Test
    public void testStripXSSToObject() {
        response = XSSUtil.stripXSS(OBJ, String.class);

        assertEquals(OBJ, response);
    }
}