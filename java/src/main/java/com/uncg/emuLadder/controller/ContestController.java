package com.uncg.emuLadder.controller;

import com.uncg.emuLadder.handler.ContestDataHandler;
import com.uncg.emuLadder.model.response.ContestData;
import com.uncg.emuLadder.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/contest")
public class ContestController {

    private final ContestDataHandler contestDataHandler;

    /**
     * Gets the data for a contest using only the contest ID.
     *
     * @param contestId { contestId }
     * @return - Contest Data { name, type, entries, entry fee, prize amount, start time, players }
     */
    @GetMapping("/{contestId}")
    public ResponseData<ContestData> getContestData(@PathVariable Integer contestId) {
        return contestDataHandler.handle(contestId);
    }

    @Autowired
    public ContestController(final ContestDataHandler contestDataHandler) {
        this.contestDataHandler = contestDataHandler;
    }
}
