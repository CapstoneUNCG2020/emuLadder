package com.uncg.emuLadder.handler;

import com.uncg.emuLadder.model.request.SendEmailRequestData;
import com.uncg.emuLadder.model.response.ContestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.sanitizer.IntegerSanitizer;
import com.uncg.emuLadder.sanitizer.SendEmailSanitizer;
import com.uncg.emuLadder.service.ContestDataService;
import com.uncg.emuLadder.service.SendEmailService;
import org.springframework.stereotype.Component;

/**
 * Handler class for receiving all information about a contest.
 */
@Component
public class SendEmailHandler extends AbstractHandler<SendEmailRequestData, ResponseData<Boolean>> {

    public SendEmailHandler(SendEmailService service, SendEmailSanitizer sanitizer) {
        super(service, sanitizer);
    }
}
