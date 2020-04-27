package com.uncg.emuLadder.handler;

import com.uncg.emuLadder.model.request.ResetPasswordRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.sanitizer.ResetPasswordSanitizer;
import com.uncg.emuLadder.service.ResetPasswordService;
import org.springframework.stereotype.Component;

/**
 * Handler class for resetting a password.
 */
@Component
public class ResetPasswordHandler extends AbstractHandler<ResetPasswordRequestData, ResponseData<Boolean>> {

    public ResetPasswordHandler(ResetPasswordService service, ResetPasswordSanitizer sanitizer) {
        super(service, sanitizer);
    }
}
