package com.uncg.emuLadder.handler;

import com.uncg.emuLadder.service.SignUpService;
import com.uncg.emuLadder.model.request.SignUpRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.sanitizer.SignUpSanitizer;
import org.springframework.stereotype.Component;

/**
 * Handler class to handle sign up operations.
 */
@Component
public class SignUpHandler extends AbstractHandler<SignUpRequestData, ResponseData<Boolean>> {

    public SignUpHandler(final SignUpService service, final SignUpSanitizer sanitizer) {
        super(service, sanitizer);
    }
}
