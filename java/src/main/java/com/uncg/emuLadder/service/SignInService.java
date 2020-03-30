package com.uncg.emuLadder.service;

import com.uncg.emuLadder.enums.ResponseStatusType;
import com.uncg.emuLadder.model.database.AccountCredentials;
import com.uncg.emuLadder.model.request.SignInRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.repository.AccountCredentialsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Service class for Sign In operations.
 */
@Component
public class SignInService implements IService<SignInRequestData, ResponseData<Boolean>> {

    private final Logger logger = LoggerFactory.getLogger((getClass()));
    private final AccountCredentialsRepository repository;

    @Autowired
    public SignInService(AccountCredentialsRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseData<Boolean> service(SignInRequestData requestData) {
        ResponseData<Boolean> responseData = new ResponseData<>();

        Optional<AccountCredentials> op = repository.findById(requestData.getUserId());

        if (!op.isPresent()) {
            String errorMessage = "Could not find user ID";

            Map<String, String> errors = new HashMap<>();
            errors.put("ERROR", errorMessage + " (" + requestData.getUserId() + ").");
            responseData.setErrors(errors);

            logger.error(errorMessage + ": {}", requestData.getUserId());
            responseData.setResponse(false);
            responseData.setStatus(ResponseStatusType.ERROR.name());
            return responseData;
        }

        AccountCredentials credentials = op.get();
        responseData.setResponse(requestData.getPassword().equals(credentials.getPassword()));
        responseData.setStatus(ResponseStatusType.SUCCESS.name());

        return responseData;
    }
}
