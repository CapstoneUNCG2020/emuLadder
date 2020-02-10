package com.uncg.emuLadder.controller;

import com.uncg.emuLadder.handler.SignUpHandler;
import com.uncg.emuLadder.model.request.SignUpRequestData;
import com.uncg.emuLadder.model.response.SignUpResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class to handle sign up operations.
 */
@RestController
public class SignUpController {
    private final SignUpHandler handler;

    @PostMapping("/signUp")
    public SignUpResponseData signIn(@RequestBody SignUpRequestData requestData) {
        return handler.handle(requestData);
    }

    @Autowired
    public SignUpController(SignUpHandler handler) {
        this.handler = handler;
    }
}
