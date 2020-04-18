package com.uncg.emuLadder.controller;

import com.uncg.emuLadder.handler.DraftingHandler;
import com.uncg.emuLadder.model.response.ContestData;
import com.uncg.emuLadder.model.response.PublicContests;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.service.PublicContestService;
import com.uncg.emuLadder.service.bl.UpdatePointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/games/leagueoflegends")
public class PublicContestController {

    private final PublicContestService publicContestService;

    @GetMapping("/public")
    public ResponseData<PublicContests> fetchPublicContests() {
        return publicContestService.getContestData();
    }

    @Autowired
    public PublicContestController(final PublicContestService publicContestService) {
        this.publicContestService = publicContestService;
    }
}
