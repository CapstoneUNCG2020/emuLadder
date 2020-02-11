package com.uncg.emuLadder.service;

import com.uncg.emuLadder.model.database.AccountCredentials;
import com.uncg.emuLadder.model.request.SignInRequestData;
import com.uncg.emuLadder.model.response.SignInResponseData;
import com.uncg.emuLadder.repository.AccountCredentialsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

/**
 * Service class for Sign In operations.
 */
@Component
public class SignInService implements IService<SignInRequestData, SignInResponseData> {

    private final Logger logger = LoggerFactory.getLogger((getClass()));
    private final AccountCredentialsRepository repository;

    @Override
    public SignInResponseData service(SignInRequestData requestData) {
        SignInResponseData responseData = new SignInResponseData();

        try {
            AccountCredentials credentials = repository.findById(requestData.getEmail()).get();

            responseData.setSuccess(requestData.getPassword().equals(credentials.getPassword()));
        } catch (NoSuchElementException ex) {
            logger.error("Could not find email.");
            responseData.setSuccess(false);
        }

        if (responseData.isSuccess()) logger.info("Sign in successful for {}", requestData.getEmail());
        else logger.info("Could not sign in for {}", requestData.getEmail());

        return responseData;
    }

    @Autowired
    public SignInService(AccountCredentialsRepository repository) {
        this.repository = repository;
    }
}
