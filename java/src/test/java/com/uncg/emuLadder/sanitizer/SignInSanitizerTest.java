package com.uncg.emuLadder.sanitizer;

import com.uncg.emuLadder.model.request.SignInRequestData;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SignInSanitizerTest {

    private static String EMAIL;
    private static String PASSWORD;
    private static String XSS;

    private SignInSanitizer sanitizer;
    private SignInRequestData requestData;
    private SignInRequestData response;

    @BeforeClass
    public static void setUpBeforeClass() {
        EMAIL = "test@gmail.com";
        PASSWORD = "password";
        XSS = "<script>sample xss</script>";
    }

    @Before
    public void setUp() {
        sanitizer = new SignInSanitizer();

        requestData = new SignInRequestData();
    }

    @Test
    public void testSanitizeEmailXss() {
        requestData.setEmail(EMAIL + XSS);
        requestData.setPassword(PASSWORD);

        response = sanitizer.sanitize(requestData);

        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    public void testSanitizePasswordXss() {
        requestData.setEmail(EMAIL);
        requestData.setPassword(PASSWORD + XSS);

        response = sanitizer.sanitize(requestData);

        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }
    @Test
    public void testSanitizeNoXss() {
        requestData.setEmail(EMAIL);
        requestData.setPassword(PASSWORD);

        response = sanitizer.sanitize(requestData);

        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }
}