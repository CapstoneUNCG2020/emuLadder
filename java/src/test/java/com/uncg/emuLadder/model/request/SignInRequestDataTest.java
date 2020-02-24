package com.uncg.emuLadder.model.request;

import com.uncg.emuLadder.util.EqualsTestUtil;
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
        requestData.setUserId(EMAIL);

        assertEquals(EMAIL, requestData.getUserId());
    }

    @Test
    public void setPassword() {
        requestData.setPassword(PASSWORD);

        assertEquals(PASSWORD, requestData.getPassword());
    }

    @Test
    public void testEquals() {
        EqualsTestUtil.testEquals(SignInRequestData.class);
    }

    @Test
    public void testHashCode() {
        int initialHash = 961;
        int finalHash = 728783545;

        assertEquals(initialHash, requestData.hashCode());

        requestData.setUserId(EMAIL);
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