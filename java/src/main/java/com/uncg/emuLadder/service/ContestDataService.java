package com.uncg.emuLadder.service;

import com.uncg.emuLadder.enums.ResponseStatusType;
import com.uncg.emuLadder.model.database.Events;
import com.uncg.emuLadder.model.response.Contest;
import com.uncg.emuLadder.model.response.ContestData;
import com.uncg.emuLadder.model.response.Player;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.service.bl.ContestDetailService;
import com.uncg.emuLadder.service.bl.ContestEventService;
import com.uncg.emuLadder.service.bl.PlayerDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ContestDataService implements IService<Integer, ResponseData<ContestData>> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ContestDetailService contestDetailService;
    private final PlayerDetailService playerDetailService;
    private final ContestEventService contestEventService;

    @Override
    public ResponseData<ContestData> service(Integer requestData) {
        ResponseData<ContestData> responseData = new ResponseData<>();

        logger.info("Getting contest data for contest {}", requestData);
        Contest contest = contestDetailService.getContest(requestData);

        ContestData contestData = new ContestData();
        contestData.setContestType(contest.getContestType());
        contestData.setEntreeFee(contest.getEntreeFee());
        contestData.setName(contest.getName());
        contestData.setPrizeAmount(contest.getPrizeAmount());
        contestData.setStartTime(contest.getStart());
        contestData.setRemainingSpaces(contest.getCurrentEntries());
        contestData.setTotalSpaces(contest.getTotalEntries());
        contestData.setContestId(requestData);

        Player[] players = playerDetailService.getPlayers(requestData);
        contestData.setPlayers(Arrays.asList(players));

        List<Events> events = contestEventService.getNextEvents(contest.getStart(), "LCS");
        contestData.setEvents(events);

        responseData.setStatus(ResponseStatusType.SUCCESS.name());
        responseData.setResponse(contestData);

        return responseData;
    }

    @Autowired
    public ContestDataService(final ContestDetailService contestDetailService,
                              final PlayerDetailService playerDetailService,
                              final ContestEventService contestEventService) {
        this.contestDetailService = contestDetailService;
        this.playerDetailService = playerDetailService;
        this.contestEventService = contestEventService;
    }
}
