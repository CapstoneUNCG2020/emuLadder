package com.uncg.emuLadder.service;

import com.uncg.emuLadder.model.database.AccountCredentials;
import com.uncg.emuLadder.model.request.SignInRequestData;
import com.uncg.emuLadder.model.response.BooleanResponseData;
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
public class SignInService implements IService<SignInRequestData, BooleanResponseData> {

    private final Logger logger = LoggerFactory.getLogger((getClass()));
    private final AccountCredentialsRepository repository;

    @Override
    public BooleanResponseData service(SignInRequestData requestData) {
        BooleanResponseData responseData = new BooleanResponseData();

        try {
            AccountCredentials credentials = repository.findById(requestData.getUserId()).get();

            responseData.setSuccess(requestData.getPassword().equals(credentials.getPassword()));
        } catch (NoSuchElementException ex) {
            logger.error("Could not find user ID.");
            responseData.setSuccess(false);
        }

        if (responseData.isSuccess()) logger.info("Sign in successful for {}", requestData.getUserId());
        else logger.info("Could not sign in for {}", requestData.getUserId());

        return responseData;
    }

    @Autowired
    public SignInService(AccountCredentialsRepository repository) {
        this.repository = repository;
    }
}
