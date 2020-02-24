package com.uncg.emuLadder.sanitizer;

import com.uncg.emuLadder.model.request.SignUpRequestData;
import com.uncg.emuLadder.util.XSSUtil;
import org.springframework.stereotype.Component;

/**
 * Sanitizer class for Sign Up Request Data
 */
@Component
public class SignUpSanitizer implements ISanitizer<SignUpRequestData> {

    @Override
    public SignUpRequestData sanitize(final SignUpRequestData requestData) {
        return XSSUtil.stripXSS(requestData, SignUpRequestData.class);
    }
}

