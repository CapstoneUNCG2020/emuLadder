package com.uncg.emuLadder.model.response;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SignInResponseDataTest {

    private SignInResponseData responseData;

    @Before
    public void setUp() {
        responseData = new SignInResponseData();
    }

    @Test
    public void setSuccess() {
        responseData.setSuccess(true);

        assertTrue(responseData.isSuccess());
    }

    @Test
    public void testEquals() {
        SignInResponseData responseData2 = new SignInResponseData();

        assertEquals(responseData, responseData2);

        responseData.setSuccess(true);
        responseData2.setSuccess(true);

        assertEquals(responseData, responseData2);
    }

    @Test
    public void testHashCode() {
        int initialHash = 1268;
        int finalHash = 1262;

        assertEquals(initialHash, responseData.hashCode());

        responseData.setSuccess(true);

        assertEquals(finalHash, responseData.hashCode());
    }

    @Test
    public void testToString() {
        String str = responseData.toString();

        assertTrue(str.contains("success"));
    }
}