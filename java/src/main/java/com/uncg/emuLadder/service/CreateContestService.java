package com.uncg.emuLadder.service;

import com.uncg.emuLadder.enums.ContestStates;
import com.uncg.emuLadder.enums.ResponseStatusType;
import com.uncg.emuLadder.model.database.*;
import com.uncg.emuLadder.model.request.CreateContestRequestData;
import com.uncg.emuLadder.model.response.ContestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.repository.*;
import com.uncg.emuLadder.service.bl.ContestEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import java.util.*;

@Component
public class CreateContestService implements IService<CreateContestRequestData, ResponseData<ContestData>> {

    /**
     * Size of a public contest.
     */
    private static final int PUBLIC_SIZE = 10;

    /**
     * Size of a private contest.
     */
    private static final int PRIVATE_SIZE = 5;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ContestsRepository contestsRepository;
    private final EventsRepository eventsRepository;
    private final ContestEventsRepository contestEventsRepository;
    private final ContestPlayersRepository contestPlayersRepository;
    private final PlayersRepository playersRepository;

    private final ContestDataService contestDataService;
    private final ContestEventService contestEventService;

    /**
     * Error map.
     */
    private Map<String, String> errors = new HashMap<>();

    @Override
    public ResponseData<ContestData> service(CreateContestRequestData requestData) {
        ResponseData<ContestData> responseData = new ResponseData<>();

        // Create the contest object for the database
        Contests dbContest = createContestObj(requestData);

        if (dbContest == null) {
            responseData.setStatus(ResponseStatusType.ERROR.name());
            responseData.setErrors(errors);
            return responseData;
        }

        // Save the contest to the database
        Contests contest = contestsRepository.saveAndFlush(dbContest);
        final int CONTEST_ID = contest.getContestId();
        logger.info("Saved contest: {}", CONTEST_ID);

        // Select the events for the contest
        List<Events> events = contestEventService.getNextEvents(contest.getStartTime(), contest.getRegion());
        List<ContestEvents> contestEventsList = new ArrayList<>();

        for (Events event : events) {
            ContestEvents contestEvent = new ContestEvents();
            contestEvent.setContestId(CONTEST_ID);
            contestEvent.setEventId(event.getEventId());

            contestEventsList.add(contestEvent);
        }
        contestEventsRepository.saveAll(contestEventsList);

        logger.info("Successfully saved events for new contest: {}", CONTEST_ID);

        List<Players> players = getPlayers(events);
        List<ContestPlayers> contestPlayersList = new ArrayList<>();

        for (Players player : players) {
            ContestPlayers contestPlayers = new ContestPlayers();
            contestPlayers.setContestId(CONTEST_ID);
            contestPlayers.setPlayerId(player.getPlayerId());

            contestPlayersList.add(contestPlayers);
        }

        contestPlayersRepository.saveAll(contestPlayersList);

        logger.info("Successfully saved all players for new contest: {}", CONTEST_ID);

        contestEventsRepository.flush();
        contestPlayersRepository.flush();

        return contestDataService.service(contest.getContestId());
    }

    /**
     * Returns a list of all players in each event.
     *
     * @param events - List of all events in the contest.
     * @return - List of all players in the contest.
     */
    private List<Players> getPlayers(List<Events> events) {
        Set<String> teamCodes = new HashSet<>();

        for (Events event : events) {
            teamCodes.add(event.getTeamCode());
            teamCodes.add(event.getTeamCode2());
        }

        Set<Players> playersSet = new HashSet<>();

        for (String teamCode : teamCodes) {
            playersSet.addAll(playersRepository.findAllByTeamCode(teamCode));
        }

        return new ArrayList<>(playersSet);
    }

    private Contests createContestObj(CreateContestRequestData requestData) {
        Contests dbContest = new Contests();

        dbContest.setName(requestData.getName());
        dbContest.setCurrentState(ContestStates.NOT_STARTED.getValue());
        dbContest.setStartTime(requestData.getStart());
        dbContest.setCreatedBy(requestData.getCreatedBy());
        dbContest.setEntreeFee(requestData.getEntreeFee());
        dbContest.setContestType(requestData.getContestType());

        int contestSize = getSize(dbContest.getContestType());

        if (contestSize == -1) {
            logger.error("Invalid contest type: " + dbContest.getContestType());
            errors.put("ERROR", "Invalid contest type");
            return null;
        }

        dbContest.setContestSize(contestSize);
        dbContest.setPrizeAmount(contestSize * dbContest.getEntreeFee());
        dbContest.setRegion(requestData.getRegion());

        return dbContest;
    }

    /**
     * Helper method to determine size of the contest based on the type.
     *
     * @param contestType - { 1. HEAD-TO-HEAD, 2. PUBLIC, 3. PRIVATE }
     * @return - Size of the contest
     */
    private int getSize(int contestType) {
        switch (contestType) {
            case 0: // Head-to-Head
                return 2;
            case 1: // Public
                return PUBLIC_SIZE;
            case 2: // Private
                return PRIVATE_SIZE;
            default: // Error
                return -1;
        }
    }

    @Autowired
    public CreateContestService(
        final ContestsRepository contestsRepository,
        final EventsRepository eventsRepository,
        final ContestEventsRepository contestEventsRepository,
        final ContestPlayersRepository contestPlayersRepository,
        final PlayersRepository playersRepository,
        final ContestDataService contestDataService,
        final ContestEventService contestEventService
    ) {
        this.contestsRepository = contestsRepository;
        this.eventsRepository = eventsRepository;
        this.contestEventsRepository = contestEventsRepository;
        this.contestPlayersRepository = contestPlayersRepository;
        this.playersRepository = playersRepository;
        this.contestDataService = contestDataService;
        this.contestEventService = contestEventService;
    }
}
