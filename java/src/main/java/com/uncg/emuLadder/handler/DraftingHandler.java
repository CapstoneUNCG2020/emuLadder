package com.uncg.emuLadder.handler;

import com.uncg.emuLadder.model.request.DraftingRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.sanitizer.DraftingSanitizer;
import com.uncg.emuLadder.service.DraftingService;
import org.springframework.stereotype.Component;

/**
 * Handler class for drafting players.
 */
@Component
public class DraftingHandler extends AbstractHandler<DraftingRequestData, ResponseData<Boolean>> {

    public DraftingHandler(DraftingService service, DraftingSanitizer sanitizer) {
        super(service, sanitizer);
    }
}
