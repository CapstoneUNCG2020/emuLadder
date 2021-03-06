package com.uncg.emuLadder.service;

import com.uncg.emuLadder.enums.ResponseStatusType;
import com.uncg.emuLadder.model.database.AccountCredentials;
import com.uncg.emuLadder.model.database.Accounts;
import com.uncg.emuLadder.model.request.SendEmailRequestData;
import com.uncg.emuLadder.model.request.SignUpRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.repository.AccountCredentialsRepository;
import com.uncg.emuLadder.repository.AccountsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class for Sign Up operations.
 */
@Component
public class SignUpService implements IService<SignUpRequestData, ResponseData<Boolean>> {

    private final AccountsRepository accountsRepository;
    private final AccountCredentialsRepository credentialsRepository;
    private final SendEmailService sendEmailService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ResponseData<Boolean> service(SignUpRequestData requestData) {
        ResponseData<Boolean> responseData = new ResponseData<>();

        if (accountsRepository.findById(requestData.getEmail()).isPresent()) {
            String errorMessage = "Email (" + requestData.getEmail() + ") already present.";

            responseData.setStatus(ResponseStatusType.ERROR.name());

            Map<String, String> errors = new HashMap<>();
            errors.put("ERROR", errorMessage);
            responseData.setErrors(errors);

            logger.error(errorMessage);

            return responseData;
        } else {
            final Accounts account = new Accounts();
            account.setEmail(requestData.getEmail());
            account.setFirstName(requestData.getFirstName());
            account.setLastName(requestData.getLastName());
            account.setEmail(requestData.getEmail());
            account.setPhoneNumber(requestData.getPhoneNumber());

            accountsRepository.save(account);

            final AccountCredentials accountCredentials = new AccountCredentials();
            accountCredentials.setEmail(requestData.getEmail());
            accountCredentials.setPassword(requestData.getPassword());

            credentialsRepository.save(accountCredentials);

            responseData.setResponse(true);
            responseData.setStatus(ResponseStatusType.SUCCESS.name());
            logger.info("Account successfully created for {}", requestData.getEmail());

            SendEmailRequestData email = new SendEmailRequestData();
            email.setContent("Welcome " + requestData.getFirstName() +  "! \n\n" +
                    "Thanks for registering for your new account. We hope you enjoy our amazing service. \n\n" +
                    "Sincerely,\nEmuLadder Developers");
            email.setRecipient(requestData.getEmail());
            email.setSubject("WELCOME!");

            sendEmailService.service(email);
        }

        return responseData;
    }

    @Autowired
    public SignUpService(AccountsRepository accountsRepository,
                         AccountCredentialsRepository credentialsRepository,
                         SendEmailService sendEmailService) {
        this.accountsRepository = accountsRepository;
        this.credentialsRepository = credentialsRepository;
        this.sendEmailService = sendEmailService;
    }
}
