package com.uncg.emuLadder.sanitizer;

import com.uncg.emuLadder.model.request.ResetPasswordRequestData;
import com.uncg.emuLadder.util.XSSUtil;
import org.springframework.stereotype.Component;

/**
 * Sanitizer for resetting password request data.
 */
@Component
public class ResetPasswordSanitizer implements ISanitizer<ResetPasswordRequestData> {
    @Override
    public ResetPasswordRequestData sanitize(ResetPasswordRequestData requestData) {
        return XSSUtil.stripXSS(requestData, ResetPasswordRequestData.class);
    }
}
