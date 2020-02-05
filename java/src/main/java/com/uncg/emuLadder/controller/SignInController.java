package com.uncg.emuLadder.controller;

import com.uncg.emuLadder.handler.SignInHandler;
import com.uncg.emuLadder.model.request.SignInRequestData;
import com.uncg.emuLadder.model.response.SignInResponseData;
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

    @PostMapping("/signIn")
    public SignInResponseData signIn(@RequestBody SignInRequestData requestData) {
        return handler.handle(requestData);
    }

    @Autowired
    public SignInController(SignInHandler handler) {
        this.handler = handler;
    }
}
