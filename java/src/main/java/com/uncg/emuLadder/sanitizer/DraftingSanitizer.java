package com.uncg.emuLadder.sanitizer;

import com.uncg.emuLadder.model.request.DraftingRequestData;
import com.uncg.emuLadder.util.XSSUtil;
import org.springframework.stereotype.Component;

/**
 * Sanitizer for drafting request data.
 */
@Component
public class DraftingSanitizer implements ISanitizer<DraftingRequestData> {
    @Override
    public DraftingRequestData sanitize(DraftingRequestData requestData) {
        return XSSUtil.stripXSS(requestData, DraftingRequestData.class);
    }
}
