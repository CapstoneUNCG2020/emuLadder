package com.uncg.emuLadder.service;

import com.uncg.emuLadder.model.database.AccountCredentials;
import com.uncg.emuLadder.model.database.Accounts;
import com.uncg.emuLadder.model.request.SignUpRequestData;
import com.uncg.emuLadder.model.response.BooleanResponseData;
import com.uncg.emuLadder.repository.AccountCredentialsRepository;
import com.uncg.emuLadder.repository.AccountsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service class for Sign Up operations.
 */
@Component
public class SignUpService implements IService<SignUpRequestData, BooleanResponseData> {

    private final AccountsRepository accountsRepository;
    private final AccountCredentialsRepository credentialsRepository;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public BooleanResponseData service(SignUpRequestData requestData) {
        BooleanResponseData responseData = new BooleanResponseData();

        if (accountsRepository.findById(requestData.getUserId()).isPresent()) {
            responseData.setSuccess(false);
        } else {
            final Accounts account = new Accounts();
            account.setEmail(requestData.getEmail());
            account.setFirstName(requestData.getFirstName());
            account.setLastName(requestData.getLastName());
            account.setUserId(requestData.getUserId());

            accountsRepository.save(account);

            final AccountCredentials accountCredentials = new AccountCredentials();
            accountCredentials.setUserId(requestData.getUserId());
            accountCredentials.setPassword(requestData.getPassword());

            credentialsRepository.save(accountCredentials);

            responseData.setSuccess(true);
            logger.info("Account successfully created for {}", requestData.getEmail());
        }

        return responseData;
    }

    @Autowired
    public SignUpService(AccountsRepository accountsRepository,
                         AccountCredentialsRepository credentialsRepository) {
        this.accountsRepository = accountsRepository;
        this.credentialsRepository = credentialsRepository;
    }
}
