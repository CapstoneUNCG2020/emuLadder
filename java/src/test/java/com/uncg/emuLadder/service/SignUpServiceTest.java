package com.uncg.emuLadder.service;

import com.uncg.emuLadder.model.database.AccountCredentials;
import com.uncg.emuLadder.model.database.Accounts;
import com.uncg.emuLadder.model.request.SignUpRequestData;
import com.uncg.emuLadder.model.response.SignUpResponseData;
import com.uncg.emuLadder.repository.AccountCredentialsRepository;
import com.uncg.emuLadder.repository.AccountInformationRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SignUpServiceTest {

    private SignUpService service;
    private AccountInformationRepository informationRepository;
    private AccountCredentialsRepository credentialsRepository;

    private SignUpRequestData requestData;

    private AccountCredentials accountCredentials;

    private SignUpResponseData responseData;
    private SignUpResponseData response;

    @Before
    public void setUp() {
        informationRepository = mock(AccountInformationRepository.class);
        credentialsRepository = mock(AccountCredentialsRepository.class);

        service = new SignUpService(informationRepository, credentialsRepository);

        requestData = new SignUpRequestData();
        String email = "test@gmail.com";
        requestData.setEmail(email);
        String firstName = "firstName";
        requestData.setFirstName(firstName);
        String lastName = "lastName";
        requestData.setLastName(lastName);
        String username = "userName";
        requestData.setUsername(username);
        String password = "pwd";
        requestData.setPassword(password);

        accountCredentials = new AccountCredentials();

        responseData = new SignUpResponseData();
    }

    @Test
    public void testServiceUserAlreadyExists() {
        Accounts accounts = new Accounts();

        when(informationRepository.findById(any())).thenReturn(Optional.of(accounts));

        response = service.service(requestData);

        assertFalse(response.isSuccess());
    }

    @Test
    public void testServiceSuccess() {
        when(informationRepository.findById(any())).thenReturn(Optional.empty());

        /* Don't actually save test to database */
        when(credentialsRepository.saveAndFlush(any())).thenReturn(null);
        when(informationRepository.saveAndFlush(any())).thenReturn(null);

        response = service.service(requestData);

        assertTrue(response.isSuccess());
    }
}