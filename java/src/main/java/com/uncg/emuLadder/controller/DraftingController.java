package com.uncg.emuLadder.controller;

import com.uncg.emuLadder.handler.DraftingHandler;
import com.uncg.emuLadder.model.request.DraftingRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/drafting")
public class DraftingController {

    private final DraftingHandler draftingHandler;

    /**
     * Gets the data to display when drafting.
     *
     * @param requestData { email, contestId, bottom, jungle, mid, support, top }
     * @return - DraftingData { contest, players[] }
     */
    @PostMapping("/draft")
    public ResponseData<Boolean> draftPlayers(@RequestBody DraftingRequestData requestData) {
        return draftingHandler.handle(requestData);
    }

    @Autowired
    public DraftingController(
            final DraftingHandler draftingHandler
    ) {
        this.draftingHandler = draftingHandler;
    }
}
