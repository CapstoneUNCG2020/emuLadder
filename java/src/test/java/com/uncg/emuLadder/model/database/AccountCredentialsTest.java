package com.uncg.emuLadder.model.database;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountCredentialsTest {

    private static String EMAIL;
    private static String PASSWORD;

    private AccountCredentials credentials;

    @BeforeClass
    public static void setUpBeforeClass() {
        EMAIL = "test@gmail.com";
        PASSWORD = "password";
    }

    @Before
    public void setUp() {
        credentials = new AccountCredentials();
    }

    @Test
    public void setEmail() {
        credentials.setEmail(EMAIL);

        assertEquals(EMAIL, credentials.getEmail());
    }

    @Test
    public void setPassword() {
        credentials.setPassword(PASSWORD);

        assertEquals(PASSWORD, credentials.getPassword());
    }

    @Test
    public void testEquals() {
        AccountCredentials credentials2 = new AccountCredentials();

        assertEquals(credentials, credentials2);

        credentials.setEmail(EMAIL);
        credentials2.setEmail(EMAIL);

        assertEquals(credentials, credentials2);

        credentials.setPassword(PASSWORD);
        credentials2.setPassword(PASSWORD);

        assertEquals(credentials, credentials2);
    }

    @Test
    public void testHashCode() {
        int initialHash = 961;
        int finalHash = 728783545;

        assertEquals(initialHash, credentials.hashCode());

        credentials.setEmail(EMAIL);
        credentials.setPassword(PASSWORD);

        assertEquals(finalHash, credentials.hashCode());
    }

    @Test
    public void testToString() {
        String str = credentials.toString();

        assertTrue(str.contains("email"));
        assertTrue(str.contains("password"));
    }
}