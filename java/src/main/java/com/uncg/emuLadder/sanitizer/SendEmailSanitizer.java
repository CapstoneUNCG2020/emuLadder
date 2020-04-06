package com.uncg.emuLadder.sanitizer;

import com.uncg.emuLadder.model.request.SendEmailRequestData;
import org.springframework.stereotype.Component;

@Component
public class SendEmailSanitizer implements ISanitizer<SendEmailRequestData> {
    @Override
    public SendEmailRequestData sanitize(SendEmailRequestData requestData) {
        return requestData;
    }
}
