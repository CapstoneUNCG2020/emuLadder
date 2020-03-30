package com.uncg.emuLadder.handler;

import com.uncg.emuLadder.model.request.SignUpRequestData;
import com.uncg.emuLadder.model.response.BooleanResponseData;
import com.uncg.emuLadder.sanitizer.SignUpSanitizer;
import com.uncg.emuLadder.service.SignUpService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SignUpHandlerTest {

    private static String EMAIL;
    private static String FIRST_NAME;
    private static String LAST_NAME;
    private static String USER_NAME;
    private static String PASSWORD;

    private SignUpHandler handler;
    private SignUpService service;

    private SignUpRequestData requestData;
    private BooleanResponseData responseData;

    @BeforeClass
    public static void setUpBeforeClass() {
        EMAIL = "test@gmail.com";
        FIRST_NAME = "firstName";
        LAST_NAME = "lastName";
        USER_NAME = "userName";
        PASSWORD = "password";
    }

    @Before
    public void setUp() {
        service = mock(SignUpService.class);
        SignUpSanitizer sanitizer = new SignUpSanitizer();

        handler = new SignUpHandler(service, sanitizer);

        requestData = new SignUpRequestData();
        requestData.setEmail(EMAIL);
        requestData.setFirstName(FIRST_NAME);
        requestData.setLastName(LAST_NAME);
        requestData.setUserId(USER_NAME);
        requestData.setPassword(PASSWORD);

        responseData = new BooleanResponseData();
        responseData.setSuccess(true);
    }

    @Test
    public void testHandle() {
        when(service.service(any())).thenReturn(responseData);

        BooleanResponseData response = handler.handle(requestData);

        assertTrue(response.isSuccess());
    }
}