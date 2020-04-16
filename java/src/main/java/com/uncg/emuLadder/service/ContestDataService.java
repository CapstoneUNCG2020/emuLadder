package com.uncg.emuLadder.service;

import com.uncg.emuLadder.enums.ResponseStatusType;
import com.uncg.emuLadder.model.response.Contest;
import com.uncg.emuLadder.model.response.ContestData;
import com.uncg.emuLadder.model.response.Player;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.service.bl.ContestDetailService;
import com.uncg.emuLadder.service.bl.PlayerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ContestDataService implements IService<Integer, ResponseData<ContestData>> {

    private final ContestDetailService contestDetailService;
    private final PlayerDetailService playerDetailService;

    @Override
    public ResponseData<ContestData> service(Integer requestData) {
        ResponseData<ContestData> responseData = new ResponseData<>();

        Contest contest = contestDetailService.getContest(requestData);

        ContestData contestData = new ContestData();
        contestData.setContestType(contest.getContestType());
        contestData.setEntreeFee(contest.getEntreeFee());
        contestData.setName(contest.getName());
        contestData.setPrizeAmount(contest.getPrizeAmount());
        contestData.setStartTime(contest.getStart());
        contestData.setRemainingSpaces(contest.getCurrentEntries());
        contestData.setTotalSpaces(contest.getTotalEntries());

        Player[] players = playerDetailService.getPlayers(requestData);
        contestData.setPlayers(Arrays.asList(players));

        responseData.setStatus(ResponseStatusType.SUCCESS.name());
        responseData.setResponse(contestData);

        return responseData;
    }

    @Autowired
    public ContestDataService(final ContestDetailService contestDetailService,
                              final PlayerDetailService playerDetailService) {
        this.contestDetailService = contestDetailService;
        this.playerDetailService = playerDetailService;
    }
}
