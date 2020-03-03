package com.uncg.emuLadder.controller;

import com.uncg.emuLadder.handler.SignInHandler;
import com.uncg.emuLadder.model.request.SignInRequestData;
import com.uncg.emuLadder.model.response.BooleanResponseData;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SignInControllerTest {

    private SignInController controller;
    private SignInHandler handler;
    private SignInRequestData requestData;
    private BooleanResponseData responseData;

    @Before
    public void setUp() {
        handler = mock(SignInHandler.class);

        controller = new SignInController(handler);

        requestData = new SignInRequestData();

        responseData = new BooleanResponseData();
        responseData.setSuccess(true);
    }

    @Test
    public void testSignIn() {
        when(handler.handle(any())).thenReturn(responseData);

        assertTrue(controller.signIn(requestData).isSuccess());
    }
}