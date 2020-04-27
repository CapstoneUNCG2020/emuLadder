package com.uncg.emuLadder.service;

import com.uncg.emuLadder.model.request.ResetPasswordRequestData;
import com.uncg.emuLadder.model.request.SignInRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.repository.AccountCredentialsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service class for resetting user password.
 */
@Component
public class ResetPasswordService implements IService<ResetPasswordRequestData, ResponseData<Boolean>> {

    private final Logger logger = LoggerFactory.getLogger((getClass()));

    private final AccountCredentialsRepository accountCredentialsRepository;
    private final SignInService signInService;

    @Autowired
    public ResetPasswordService(
            final AccountCredentialsRepository accountCredentialsRepository,
            final SignInService signInservice
    ) {
        this.accountCredentialsRepository = accountCredentialsRepository;
        this.signInService = signInservice;
    }

    @Override
    public ResponseData<Boolean> service(ResetPasswordRequestData requestData) {
        String email = requestData.getEmail();

        ResponseData<Boolean> correctPwd = verifyPassword(email, requestData.getOldPassword());

        if (correctPwd.getResponse())
            accountCredentialsRepository.resetPassword(requestData.getNewPassword(), email);
        else {
            logger.error("Incorrect password for email {}", email);
        }

        return correctPwd;
    }

    /**
     * Verify email and password combination is correct before resetting.
     *
     * @param email - Email address of user.
     * @param password - Old password of user.
     * @return - TRUE if valid ; FALSE if not
     */
    private ResponseData<Boolean> verifyPassword(String email, String password) {
        SignInRequestData signInRequestData = new SignInRequestData();

        signInRequestData.setUserId(email);
        signInRequestData.setPassword(password);

        return signInService.service(signInRequestData);
    }
}
