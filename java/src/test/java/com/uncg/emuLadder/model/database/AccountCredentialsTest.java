package com.uncg.emuLadder.model.database;

import com.uncg.emuLadder.util.EqualsTestUtil;
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
        credentials.setUserId(EMAIL);

        assertEquals(EMAIL, credentials.getUserId());
    }

    @Test
    public void setPassword() {
        credentials.setPassword(PASSWORD);

        assertEquals(PASSWORD, credentials.getPassword());
    }

    @Test
    public void testEquals() {
        EqualsTestUtil.testEquals(AccountCredentials.class);
    }

    @Test
    public void testHashCode() {
        int initialHash = 961;
        int finalHash = 728783545;

        assertEquals(initialHash, credentials.hashCode());

        credentials.setUserId(EMAIL);
        credentials.setPassword(PASSWORD);

        assertEquals(finalHash, credentials.hashCode());
    }

    @Test
    public void testToString() {
        String str = credentials.toString();

        assertTrue(str.contains("userId"));
        assertTrue(str.contains("password"));
    }
}