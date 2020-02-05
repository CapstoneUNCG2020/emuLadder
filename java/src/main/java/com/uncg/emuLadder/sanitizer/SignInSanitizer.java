package com.uncg.emuLadder.sanitizer;

import com.uncg.emuLadder.model.request.SignInRequestData;
import com.uncg.emuLadder.util.XSSUtil;
import org.springframework.stereotype.Component;

/**
 * Sanitizer class for Sign In Request Data
 */
@Component
public class SignInSanitizer implements ISanitizer<SignInRequestData> {

    @Override
    public SignInRequestData sanitize(final SignInRequestData requestData) {
        return XSSUtil.stripXSS(requestData, SignInRequestData.class);
    }
}

