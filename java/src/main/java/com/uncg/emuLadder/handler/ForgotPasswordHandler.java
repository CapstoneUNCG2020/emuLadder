package com.uncg.emuLadder.handler;

import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.sanitizer.StringSanitizer;
import com.uncg.emuLadder.service.ForgotPasswordService;
import org.springframework.stereotype.Component;

/**
 * Handler class for forgot password operations.
 */
@Component
public class ForgotPasswordHandler extends AbstractHandler<String, ResponseData<Boolean>> {

    public ForgotPasswordHandler(ForgotPasswordService service, StringSanitizer sanitizer) {
        super(service, sanitizer);
    }
}
