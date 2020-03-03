package com.uncg.emuLadder.service;

import com.uncg.emuLadder.model.database.AccountCredentials;
import com.uncg.emuLadder.model.request.SignInRequestData;
import com.uncg.emuLadder.model.response.BooleanResponseData;
import com.uncg.emuLadder.repository.AccountCredentialsRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SignInServiceTest {

    private static String PASSWORD;

    private SignInService service;
    private AccountCredentialsRepository repository;

    private SignInRequestData requestData;
    private AccountCredentials accountCredentials;

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private Optional<AccountCredentials> optional;

    private BooleanResponseData response;

    @BeforeClass
    public static void setUpBeforeClass() {
        PASSWORD = "password";
    }

    @Before
    public void setUp() {
        repository = mock(AccountCredentialsRepository.class);

        service = new SignInService(repository);

        requestData = new SignInRequestData();
        String email = "email";
        requestData.setUserId(email);
        requestData.setPassword(PASSWORD);

        accountCredentials = new AccountCredentials();
    }

    @Test
    public void testServiceAccountNotFound() {
        when(repository.findById(any())).thenThrow(NoSuchElementException.class);

        response = service.service(requestData);

        assertFalse(response.isSuccess());
    }

    @Test
    public void testServiceInvalidPassword() {
        accountCredentials.setPassword("not password");
        optional = Optional.of(accountCredentials);

        when(repository.findById(any())).thenReturn(optional);

        response = service.service(requestData);

        assertFalse(response.isSuccess());
    }

    @Test
    public void testServiceSuccess() {
        accountCredentials.setPassword(PASSWORD);
        optional = Optional.of(accountCredentials);

        when(repository.findById(any())).thenReturn(optional);

        response = service.service(requestData);

        assertTrue(response.isSuccess());
    }
}