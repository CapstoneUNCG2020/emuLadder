package com.uncg.emuLadder.handler;

import com.uncg.emuLadder.model.request.SignInRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.sanitizer.SignInSanitizer;
import com.uncg.emuLadder.service.SignInService;
import org.springframework.stereotype.Component;

/**
 * Handler class to handle sign in operations.
 */
@Component
public class SignInHandler extends AbstractHandler<SignInRequestData, ResponseData<Boolean>> {

    public SignInHandler(final SignInService service, final SignInSanitizer sanitizer) {
        super(service, sanitizer);
    }
}
