package com.uncg.emuLadder.model.request;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpRequestDataTest {

    private static String EMAIL;
    private static String USER_NAME;
    private static String FIRST_NAME;
    private static String LAST_NAME;
    private static String PASSWORD;

    private SignUpRequestData requestData;

    @BeforeClass
    public static void setUpBeforeClass() {
        EMAIL = "test@gmail.com";
        USER_NAME = "userName";
        FIRST_NAME = "firstName";
        LAST_NAME = "lastName";
        PASSWORD = "password";
    }

    @Before
    public void setUp() {
        requestData = new SignUpRequestData();
    }

    @Test
    public void setFirstName() {
        requestData.setFirstName(FIRST_NAME);

        assertEquals(FIRST_NAME, requestData.getFirstName());
    }

    @Test
    public void setLastName() {
        requestData.setLastName(LAST_NAME);

        assertEquals(LAST_NAME, requestData.getLastName());
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
    public void setUsername() {
        requestData.setUsername(USER_NAME);

        assertEquals(USER_NAME, requestData.getUsername());
    }

    @Test
    public void testEquals() {
        SignUpRequestData requestData2 = new SignUpRequestData();

        assertEquals(requestData, requestData2);

        requestData.setFirstName(FIRST_NAME);
        requestData2.setFirstName(FIRST_NAME);

        assertEquals(requestData, requestData2);

        requestData.setLastName(LAST_NAME);
        requestData2.setLastName(LAST_NAME);

        assertEquals(requestData, requestData2);

        requestData.setUsername(USER_NAME);
        requestData2.setUsername(USER_NAME);

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
        int initialHash = 28629151;
        int finalHash = -425023593;

        assertEquals(initialHash, requestData.hashCode());

        requestData.setFirstName(FIRST_NAME);
        requestData.setLastName(LAST_NAME);
        requestData.setUsername(USER_NAME);
        requestData.setEmail(EMAIL);
        requestData.setPassword(PASSWORD);

        assertEquals(finalHash, requestData.hashCode());
    }

    @Test
    public void testToString() {
        String str = requestData.toString();

        assertTrue(str.contains("firstName"));
        assertTrue(str.contains("lastName"));
        assertTrue(str.contains("username"));
        assertTrue(str.contains("email"));
        assertTrue(str.contains("password"));
    }
}