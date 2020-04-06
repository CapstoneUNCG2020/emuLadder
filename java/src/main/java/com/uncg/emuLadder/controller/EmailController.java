package com.uncg.emuLadder.controller;

import com.uncg.emuLadder.handler.SendEmailHandler;
import com.uncg.emuLadder.handler.SignInHandler;
import com.uncg.emuLadder.handler.SignUpHandler;
import com.uncg.emuLadder.model.request.SendEmailRequestData;
import com.uncg.emuLadder.model.request.SignInRequestData;
import com.uncg.emuLadder.model.request.SignUpRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/email")
public class EmailController {

    private final SendEmailHandler sendEmailHandler;

    @PostMapping("/send")
    public ResponseData<Boolean> sendEmail(@RequestBody SendEmailRequestData requestData) {
        return sendEmailHandler.handle(requestData);
    }

    @Autowired
    public EmailController(SendEmailHandler sendEmailHandler) {
        this.sendEmailHandler = sendEmailHandler;
    }
}
