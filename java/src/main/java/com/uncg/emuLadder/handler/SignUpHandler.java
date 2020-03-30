package com.uncg.emuLadder.handler;

import com.uncg.emuLadder.model.request.SignUpRequestData;
import com.uncg.emuLadder.model.response.BooleanResponseData;
import com.uncg.emuLadder.sanitizer.SignUpSanitizer;
import com.uncg.emuLadder.service.SignUpService;
import org.springframework.stereotype.Component;

/**
 * Handler class to handle sign up operations.
 */
@Component
public class SignUpHandler extends AbstractHandler<SignUpRequestData, BooleanResponseData> {

    public SignUpHandler(final SignUpService service, final SignUpSanitizer sanitizer) {
        super(service, sanitizer);
    }
}
