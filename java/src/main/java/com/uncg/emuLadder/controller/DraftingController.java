package com.uncg.emuLadder.controller;

import com.uncg.emuLadder.handler.DraftingDataHandler;
import com.uncg.emuLadder.model.response.DraftingData;
import com.uncg.emuLadder.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/drafting")
public class DraftingController {

    private final DraftingDataHandler draftingDataHandler;

    /**
     * Gets the data to display when drafting.
     *
     * @param contestId { contestId }
     * @return - DraftingData { contest, players[] }
     */
    @GetMapping("{contestId}")
    public ResponseData<DraftingData> getContestData(@PathVariable Integer contestId) {
        return draftingDataHandler.handle(contestId);
    }

    @Autowired
    public DraftingController(
            final DraftingDataHandler draftingDataHandler
    ) {
        this.draftingDataHandler = draftingDataHandler;
    }
}
