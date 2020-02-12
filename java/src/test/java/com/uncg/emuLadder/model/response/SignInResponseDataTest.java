package com.uncg.emuLadder.model.response;

import com.uncg.emuLadder.model.database.AccountInformation;
import com.uncg.emuLadder.util.EqualsTestUtil;
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
        EqualsTestUtil.testEquals(SignInResponseData.class);
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