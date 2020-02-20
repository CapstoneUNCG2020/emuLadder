package com.uncg.emuLadder.service;

import com.uncg.emuLadder.model.database.AccountCredentials;
import com.uncg.emuLadder.model.database.Accounts;
import com.uncg.emuLadder.model.request.SignUpRequestData;
import com.uncg.emuLadder.model.response.SignUpResponseData;
import com.uncg.emuLadder.repository.AccountCredentialsRepository;
import com.uncg.emuLadder.repository.AccountInformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service class for Sign Up operations.
 */
@Component
public class SignUpService implements IService<SignUpRequestData, SignUpResponseData> {

    private final Logger logger = LoggerFactory.getLogger((getClass()));
    private final AccountInformationRepository informationRepository;
    private final AccountCredentialsRepository credentialsRepository;

    @Override
    public SignUpResponseData service(SignUpRequestData requestData) {
        SignUpResponseData responseData = new SignUpResponseData();

        if (informationRepository.findById(requestData.getEmail()).isPresent()) {
            responseData.setSuccess(false);
        } else {
            final Accounts accounts = new Accounts();
            accounts.setEmail(requestData.getEmail());
            accounts.setFirstName(requestData.getFirstName());
            accounts.setLastName(requestData.getLastName());
            accounts.setUserId(requestData.getUsername());

            informationRepository.saveAndFlush(accounts);

            final AccountCredentials accountCredentials = new AccountCredentials();
            accountCredentials.setUserId(requestData.getEmail());
            accountCredentials.setPassword(requestData.getPassword());

            credentialsRepository.saveAndFlush(accountCredentials);

            responseData.setSuccess(true);
        }

        return responseData;
    }

    @Autowired
    public SignUpService(AccountInformationRepository informationRepository,
                         AccountCredentialsRepository credentialsRepository) {
        this.informationRepository = informationRepository;
        this.credentialsRepository = credentialsRepository;
    }
}