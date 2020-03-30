package com.uncg.emuLadder.controller;

import com.uncg.emuLadder.handler.SignInHandler;
import com.uncg.emuLadder.model.request.SignInRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class to handle sign in operations.
 */
@RestController
public class SignInController {
    private final SignInHandler handler;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/signIn")
    public ResponseData<Boolean> signIn(@RequestBody SignInRequestData requestData) {
        logger.info("Attempting sign in for {}", requestData.getUserId());

        return handler.handle(requestData);
    }

    @Autowired
    public SignInController(SignInHandler handler) {
        this.handler = handler;
    }
}
