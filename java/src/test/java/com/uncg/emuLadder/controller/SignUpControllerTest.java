package com.uncg.emuLadder.controller;

import com.uncg.emuLadder.handler.SignUpHandler;
import com.uncg.emuLadder.model.request.SignUpRequestData;
import com.uncg.emuLadder.model.response.BooleanResponseData;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SignUpControllerTest {

    private SignUpController controller;
    private SignUpHandler handler;
    private SignUpRequestData requestData;
    private BooleanResponseData responseData;

    @Before
    public void setUp() {
        handler = mock(SignUpHandler.class);

        controller = new SignUpController(handler);

        requestData = new SignUpRequestData();

        responseData = new BooleanResponseData();
        responseData.setSuccess(true);
    }

    @Test
    public void testSignUp() {
        when(handler.handle(any())).thenReturn(responseData);

        assertTrue(controller.signUp(requestData).isSuccess());
    }
}