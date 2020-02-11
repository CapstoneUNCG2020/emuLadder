package com.uncg.emuLadder.sanitizer;

import com.uncg.emuLadder.model.request.SignUpRequestData;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SignUpSanitizerTest {

    private static String EMAIL;
    private static String FIRST_NAME;
    private static String LAST_NAME;
    private static String USER_NAME;
    private static String PASSWORD;
    private static String XSS;

    private SignUpSanitizer sanitizer;
    private SignUpRequestData requestData;
    private SignUpRequestData response;

    @BeforeClass
    public static void setUpBeforeClass() {
        EMAIL = "test@lfg.com";
        FIRST_NAME = "firstName";
        LAST_NAME = "lastName";
        USER_NAME = "userName";
        PASSWORD = "password";
        XSS = "<script>sample script</script>";
    }

    @Before
    public void setUp() {
        sanitizer = new SignUpSanitizer();

        requestData = new SignUpRequestData();
    }

    @Test
    public void testSanitizeEmailXss() {
        requestData.setEmail(EMAIL + XSS);
        requestData.setFirstName(FIRST_NAME);
        requestData.setLastName(LAST_NAME);
        requestData.setUsername(USER_NAME);
        requestData.setPassword(PASSWORD);

        response = sanitizer.sanitize(requestData);

        assertEquals(EMAIL, response.getEmail());
        assertEquals(FIRST_NAME, response.getFirstName());
        assertEquals(LAST_NAME, response.getLastName());
        assertEquals(USER_NAME, response.getUsername());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    public void testSanitizeFirstNameXss() {
        requestData.setEmail(EMAIL);
        requestData.setFirstName(FIRST_NAME + XSS);
        requestData.setLastName(LAST_NAME);
        requestData.setUsername(USER_NAME);
        requestData.setPassword(PASSWORD);

        response = sanitizer.sanitize(requestData);

        assertEquals(EMAIL, response.getEmail());
        assertEquals(FIRST_NAME, response.getFirstName());
        assertEquals(LAST_NAME, response.getLastName());
        assertEquals(USER_NAME, response.getUsername());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    public void testSanitizeLastNameXss() {
        requestData.setEmail(EMAIL);
        requestData.setFirstName(FIRST_NAME);
        requestData.setLastName(LAST_NAME + XSS);
        requestData.setUsername(USER_NAME);
        requestData.setPassword(PASSWORD);

        response = sanitizer.sanitize(requestData);

        assertEquals(EMAIL, response.getEmail());
        assertEquals(FIRST_NAME, response.getFirstName());
        assertEquals(LAST_NAME, response.getLastName());
        assertEquals(USER_NAME, response.getUsername());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    public void testSanitizeUserNameXss() {
        requestData.setEmail(EMAIL);
        requestData.setFirstName(FIRST_NAME);
        requestData.setLastName(LAST_NAME);
        requestData.setUsername(USER_NAME + XSS);
        requestData.setPassword(PASSWORD);

        response = sanitizer.sanitize(requestData);

        assertEquals(EMAIL, response.getEmail());
        assertEquals(FIRST_NAME, response.getFirstName());
        assertEquals(LAST_NAME, response.getLastName());
        assertEquals(USER_NAME, response.getUsername());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    public void testSanitizePasswordXss() {
        requestData.setEmail(EMAIL);
        requestData.setFirstName(FIRST_NAME);
        requestData.setLastName(LAST_NAME);
        requestData.setUsername(USER_NAME);
        requestData.setPassword(PASSWORD + XSS);

        response = sanitizer.sanitize(requestData);

        assertEquals(EMAIL, response.getEmail());
        assertEquals(FIRST_NAME, response.getFirstName());
        assertEquals(LAST_NAME, response.getLastName());
        assertEquals(USER_NAME, response.getUsername());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    public void testSanitizeNoXss() {
        requestData.setEmail(EMAIL);
        requestData.setFirstName(FIRST_NAME);
        requestData.setLastName(LAST_NAME);
        requestData.setUsername(USER_NAME);
        requestData.setPassword(PASSWORD);

        response = sanitizer.sanitize(requestData);

        assertEquals(EMAIL, response.getEmail());
        assertEquals(FIRST_NAME, response.getFirstName());
        assertEquals(LAST_NAME, response.getLastName());
        assertEquals(USER_NAME, response.getUsername());
        assertEquals(PASSWORD, response.getPassword());
    }

}