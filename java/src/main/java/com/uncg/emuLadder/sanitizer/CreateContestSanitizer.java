package com.uncg.emuLadder.sanitizer;

import com.uncg.emuLadder.model.request.CreateContestRequestData;
import com.uncg.emuLadder.util.XSSUtil;
import org.springframework.stereotype.Component;

/**
 * Sanitizer for CreateContestRequestData.
 */
@Component
public class CreateContestSanitizer implements ISanitizer<CreateContestRequestData> {
    @Override
    public CreateContestRequestData sanitize(CreateContestRequestData requestData) {
        return XSSUtil.stripXSS(requestData, CreateContestRequestData.class);
    }
}
