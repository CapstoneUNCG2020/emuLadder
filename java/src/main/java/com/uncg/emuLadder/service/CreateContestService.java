package com.uncg.emuLadder.service;

import com.uncg.emuLadder.enums.ContestStates;
import com.uncg.emuLadder.enums.ResponseStatusType;
import com.uncg.emuLadder.model.database.*;
import com.uncg.emuLadder.model.request.CreateContestRequestData;
import com.uncg.emuLadder.model.response.ContestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
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
        logger.info("Saved contest: {}", contest);

        // Select the events for the contest
        List<Events> events = getNextEvents(contest);

        for (Events event : events) {
            ContestEvents contestEvent = new ContestEvents();
            contestEvent.setContestId(contest.getContestId());
            contestEvent.setEventId(event.getEventId());

            contestEventsRepository.save(contestEvent);
        }

        // Send changes to database
        contestEventsRepository.flush();
        logger.info("Successfully saved events for new contest: {}", events);

        List<Players> players = getPlayers(events);

        for (Players player : players) {
            ContestPlayers contestPlayers = new ContestPlayers();
            contestPlayers.setContestId(contest.getContestId());
            contestPlayers.setPlayerId(player.getPlayerId());

            contestPlayersRepository.save(contestPlayers);
        }

        contestPlayersRepository.flush();
        logger.info("Successfully saved all players for new contest: {}", players);

        return responseData;
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

        List<Players> playersList = playersRepository.findAll();

        Set<Players> playersSet = new HashSet<>();

        for (Players player : playersList) {
            if (teamCodes.contains(player.getTeamCode())) {
                playersSet.add(player);
            }
        }

        return new ArrayList<>(playersSet);
    }

    /**
     * Returns the events that start on the same day as
     * the contest, capped at 5, in the same region.
     *
     * @param contest - The contest being created.
     * @return - The list of events that are in the contest.
     */
    private List<Events> getNextEvents(Contests contest) {
        Date start = contest.getStartTime();
        Date end = Date.valueOf(start.toLocalDate().plusDays(1));
        String region = contest.getRegion();

        List<Events> events = eventsRepository.findAllByStartTimeAfterAndStartTimeBeforeAndName(start, end, region);

        // Return only 5 events max
        return events.size() <= 5 ? events :  events.subList(0, 5);
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
        final PlayersRepository playersRepository
    ) {
        this.contestsRepository = contestsRepository;
        this.eventsRepository = eventsRepository;
        this.contestEventsRepository = contestEventsRepository;
        this.contestPlayersRepository = contestPlayersRepository;
        this.playersRepository = playersRepository;
    }
}
