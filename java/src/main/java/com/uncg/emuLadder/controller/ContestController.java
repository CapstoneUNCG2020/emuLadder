package com.uncg.emuLadder.controller;

import com.uncg.emuLadder.handler.ContestDataHandler;
import com.uncg.emuLadder.handler.CreateContestHandler;
import com.uncg.emuLadder.model.request.CreateContestRequestData;
import com.uncg.emuLadder.model.response.ContestData;
import com.uncg.emuLadder.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/contest")
public class ContestController {

    private final ContestDataHandler contestDataHandler;
    private final CreateContestHandler createContestHandler;

    /**
     * Gets the data for a contest using only the contest ID.
     *
     * @param contestId { contestId }
     * @return - Contest Data { name, type, entries, entry fee, prize amount, start time, players }
     */
    @GetMapping("{contestId}")
    public ResponseData<ContestData> getContestData(@PathVariable Integer contestId) {
        return contestDataHandler.handle(contestId);
    }

    @PostMapping("/create")
    public ResponseData<ContestData> createContest(@RequestBody CreateContestRequestData requestData) {
        return createContestHandler.handle(requestData);
    }

    @Autowired
    public ContestController(
            final ContestDataHandler contestDataHandler,
            final CreateContestHandler createContestHandler
    ) {
        this.contestDataHandler = contestDataHandler;
        this.createContestHandler = createContestHandler;
    }
}
