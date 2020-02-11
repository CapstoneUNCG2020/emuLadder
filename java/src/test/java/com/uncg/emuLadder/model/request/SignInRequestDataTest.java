package com.uncg.emuLadder.model.request;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SignInRequestDataTest {

    private static String EMAIL;
    private static String PASSWORD;

    private SignInRequestData requestData;

    @BeforeClass
    public static void setUpBeforeClass() {
        EMAIL = "test@gmail.com";
        PASSWORD = "password";
    }

    @Before
    public void setUp() {
        requestData = new SignInRequestData();
    }

    @Test
    public void setEmail() {
        requestData.setEmail(EMAIL);

        assertEquals(EMAIL, requestData.getEmail());
    }

    @Test
    public void setPassword() {
        requestData.setPassword(PASSWORD);

        assertEquals(PASSWORD, requestData.getPassword());
    }

    @Test
    public void testEquals() {
        SignInRequestData requestData2 = new SignInRequestData();

        assertEquals(requestData, requestData2);

        requestData.setEmail(EMAIL);
        requestData2.setEmail(EMAIL);
        assertEquals(requestData, requestData2);

        requestData.setPassword(PASSWORD);
        requestData2.setPassword(PASSWORD);
        assertEquals(requestData, requestData2);
    }

    @Test
    public void testHashCode() {
        int initialHash = 961;
        int finalHash = 728783545;

        assertEquals(initialHash, requestData.hashCode());

        requestData.setEmail(EMAIL);
        requestData.setPassword(PASSWORD);

        assertEquals(finalHash, requestData.hashCode());
    }

    @Test
    public void testToString() {
        String str = requestData.toString();

        assertTrue(str.contains("email"));
        assertTrue(str.contains("password"));
    }
}