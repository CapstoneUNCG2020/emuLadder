package com.uncg.emuLadder.service;

import com.uncg.emuLadder.enums.ResponseStatusType;
import com.uncg.emuLadder.model.request.SendEmailRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.repository.AccountCredentialsRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service class for forgot password operations.
 */
@Component
public class ForgotPasswordService implements IService<String, ResponseData<Boolean>> {

    private final String SUBJECT = "EmuLadder - FORGOT PASSWORD";
    private final String CONTENT1 = "You have selected to reset your password. Your new password is <b>";
    private final String CONTENT2 = "</b>. Please login to www.emuLadder.com/resetPassword to reset your password.";

    private final Logger logger = LoggerFactory.getLogger((getClass()));

    private final AccountCredentialsRepository accountCredentialsRepository;

    private final SendEmailService sendEmailService;

    @Autowired
    public ForgotPasswordService(
            final AccountCredentialsRepository accountCredentialsRepository,
            final SendEmailService sendEmailService
    ) {
        this.accountCredentialsRepository = accountCredentialsRepository;
        this.sendEmailService = sendEmailService;
    }

    @Override
    public ResponseData<Boolean> service(String email) {
        ResponseData<Boolean> responseData = new ResponseData<>();

        String newPwd = generateNewPassword();

        accountCredentialsRepository.resetPassword(newPwd, email);

        SendEmailRequestData emailMessage = new SendEmailRequestData();

        emailMessage.setRecipient(email);
        emailMessage.setSubject(SUBJECT);
        emailMessage.setContent(CONTENT1 + newPwd + CONTENT2);

        sendEmailService.service(emailMessage);

        responseData.setStatus(ResponseStatusType.SUCCESS.name());
        responseData.setResponse(true);

        return responseData;
    }

    /**
     * @return - A random new password.
     */
    private String generateNewPassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
