package com.uncg.emuLadder.handler;

import com.uncg.emuLadder.model.request.SignInRequestData;
import com.uncg.emuLadder.model.response.SignInResponseData;
import com.uncg.emuLadder.sanitizer.SignInSanitizer;
import com.uncg.emuLadder.service.SignInService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SignInHandlerTest {

    private static String EMAIL;
    private static String PASSWORD;

    private SignInHandler handler;
    private SignInService service;

    private SignInRequestData requestData;
    private SignInResponseData responseData;

    @BeforeClass
    public static void setUpBeforeClass() {
        EMAIL = "test@gmail.com";
        PASSWORD = "password";
    }

    @Before
    public void setUp() {
        service = mock(SignInService.class);
        SignInSanitizer sanitizer = new SignInSanitizer();

        handler = new SignInHandler(service, sanitizer);

        requestData = new SignInRequestData();
        requestData.setUserId(EMAIL);
        requestData.setPassword(PASSWORD);

        responseData = new SignInResponseData();
        responseData.setSuccess(true);
    }

    @Test
    public void testHandle() {
        when(service.service(any())).thenReturn(responseData);

        SignInResponseData response = handler.handle(requestData);

        assertTrue(response.isSuccess());
    }
}