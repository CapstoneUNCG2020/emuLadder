package com.uncg.emuLadder.service;

import com.uncg.emuLadder.enums.ResponseStatusType;
import com.uncg.emuLadder.model.response.Contest;
import com.uncg.emuLadder.model.response.DraftingData;
import com.uncg.emuLadder.model.response.Player;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.service.bl.ContestDetailService;
import com.uncg.emuLadder.service.bl.PlayerDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class for getting the data needed to start drafting players.
 */
@Component
public class DraftingDataService implements IService<Integer, ResponseData<DraftingData>> {

    private final Logger logger = LoggerFactory.getLogger((getClass()));
    private final ContestDetailService contestDetailService;
    private final PlayerDetailService playerDetailService;

    @Autowired
    public DraftingDataService(
            final ContestDetailService contestDetailService,
            final PlayerDetailService playerDetailService
    ) {
        this.contestDetailService = contestDetailService;
        this.playerDetailService = playerDetailService;
    }

    @Override
    public ResponseData<DraftingData> service(Integer contestId) {
        ResponseData<DraftingData> responseData = new ResponseData<>();
        DraftingData draftingData = new DraftingData();

        Contest contest = contestDetailService.getContest(contestId);
        draftingData.setContest(contest);

        Player[] players = playerDetailService.getPlayers(contestId);
        draftingData.setAvailablePlayers(players);

        responseData.setResponse(draftingData);
        Map<String, String> errors = new HashMap<>();

        // Initially set response to success
        responseData.setStatus(ResponseStatusType.SUCCESS.name());

        /* Check for errors in getting contest information */
        if (contest == null) {
            responseData.setStatus(ResponseStatusType.ERROR.name());
            errors.put("CONTEST ERROR", "No contest data to display.");
        }

        /* Check for errors in getting player information */
        if (players == null || players.length == 0) {
            responseData.setStatus(ResponseStatusType.ERROR.name());
            errors.put("PLAYER ERROR", "No players available to draft.");
        }

        responseData.setErrors(errors);

        return responseData;
    }


}
