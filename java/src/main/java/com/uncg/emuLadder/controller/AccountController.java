package com.uncg.emuLadder.controller;

import com.uncg.emuLadder.handler.ForgotPasswordHandler;
import com.uncg.emuLadder.handler.ResetPasswordHandler;
import com.uncg.emuLadder.handler.SignInHandler;
import com.uncg.emuLadder.handler.SignUpHandler;
import com.uncg.emuLadder.model.request.ResetPasswordRequestData;
import com.uncg.emuLadder.model.request.SignInRequestData;
import com.uncg.emuLadder.model.request.SignUpRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountController {

    private final SignInHandler signInHandler;
    private final SignUpHandler signUpHandler;
    private final ResetPasswordHandler resetPasswordHandler;
    private final ForgotPasswordHandler forgotPasswordHandler;

    /**
     * Validates the user's sign in credentials (user ID and password)
     * against the database.
     *
     * @param requestData - { user ID, password }
     * @return - Boolean of true (sign in success) or false (sign in fail)
     */
    @PostMapping("/signin")
    public ResponseData<Boolean> signIn(@RequestBody SignInRequestData requestData) {
        return signInHandler.handle(requestData);
    }

    /**
     * Create a new user account stored in the database.
     *
     * @param requestData { user ID, first name, last name, email, phone number }
     * @return Boolean of true (account created) or error (account could not be created)
     */
    @PostMapping("/signup")
    public ResponseData<Boolean> signUp(@RequestBody SignUpRequestData requestData) {
        return signUpHandler.handle(requestData);
    }

    @PostMapping("/forgotPassword")
    public ResponseData<Boolean> forgotPassword(@RequestBody String email) {
        return forgotPasswordHandler.handle(email);
    }

    @PostMapping("/resetPassword")
    public ResponseData<Boolean> resetPassword(@RequestBody ResetPasswordRequestData requestData) {
        return resetPasswordHandler.handle(requestData);
    }

    @Autowired
    public AccountController(
            final SignInHandler signInHandler,
            final SignUpHandler signUpHandler,
            final ResetPasswordHandler resetPasswordHandler,
            final ForgotPasswordHandler forgotPasswordHandler
    ) {
        this.signInHandler = signInHandler;
        this.signUpHandler = signUpHandler;
        this.resetPasswordHandler = resetPasswordHandler;
        this.forgotPasswordHandler = forgotPasswordHandler;
    }
}
