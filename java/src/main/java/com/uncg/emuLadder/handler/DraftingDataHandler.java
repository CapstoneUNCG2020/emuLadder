package com.uncg.emuLadder.handler;

import com.uncg.emuLadder.model.response.DraftingData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.sanitizer.IntegerSanitizer;
import com.uncg.emuLadder.service.DraftingDataService;
import org.springframework.stereotype.Component;

/**
 * Handler class for receiving data needed to begin drafting.
 */
@Component
public class DraftingDataHandler extends AbstractHandler<Integer, ResponseData<DraftingData>> {

    public DraftingDataHandler(DraftingDataService service, IntegerSanitizer sanitizer) {
        super(service, sanitizer);
    }
}
