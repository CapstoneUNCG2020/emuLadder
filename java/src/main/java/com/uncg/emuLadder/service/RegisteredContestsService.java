package com.uncg.emuLadder.service;

import com.uncg.emuLadder.enums.ResponseStatusType;
import com.uncg.emuLadder.model.database.AccountCredentials;
import com.uncg.emuLadder.model.database.ContestParticipants;
import com.uncg.emuLadder.model.request.SignInRequestData;
import com.uncg.emuLadder.model.response.*;
import com.uncg.emuLadder.repository.AccountCredentialsRepository;
import com.uncg.emuLadder.repository.ContestParticipantsRepository;
import com.uncg.emuLadder.service.bl.ContestDetailService;
import com.uncg.emuLadder.service.bl.PlayerDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Service class for Sign In operations.
 */
@Component
public class RegisteredContestsService implements IService<String, ResponseData<RegisteredContestsData>> {

    private final Logger logger = LoggerFactory.getLogger((getClass()));

    private final ContestParticipantsRepository contestParticipantsRepository;

    private final ContestDetailService contestDetailService;
    private final PlayerDetailService playerDetailService;

    @Autowired
    public RegisteredContestsService(
            final ContestParticipantsRepository contestParticipantsRepository,
            final ContestDetailService contestDetailService,
            final PlayerDetailService playerDetailService
    ) {
        this.contestParticipantsRepository = contestParticipantsRepository;
        this.contestDetailService = contestDetailService;
        this.playerDetailService = playerDetailService;
    }

    @Override
    public ResponseData<RegisteredContestsData> service(String email) {
        ResponseData<RegisteredContestsData> responseData = new ResponseData<>();

        final RegisteredContestsData registeredContestsData = new RegisteredContestsData();
        final List<RegisteredContest> registeredContestList = new ArrayList<>();

        List<ContestParticipants> contestParticipantsList = contestParticipantsRepository.findAllByEmail(email);

        for (ContestParticipants contestParticipants : contestParticipantsList) {
            RegisteredContest registeredContest = getRegisteredContest(contestParticipants);

            registeredContestList.add(registeredContest);
        }

        registeredContestsData.setRegisteredContests(registeredContestList);
        responseData.setResponse(registeredContestsData);
        responseData.setStatus(ResponseStatusType.SUCCESS.name());

        return responseData;
    }

    /**
     * Method to get the RegisteredContest object from the ContestParticipants object.
     *
     * @param contestParticipants - Contains contest ID and player information.
     * @return - RegisteredContest object
     */
    private RegisteredContest getRegisteredContest(ContestParticipants contestParticipants) {
        RegisteredContest registeredContest = new RegisteredContest();

        int contestId = contestParticipants.getContestId();
        String email = contestParticipants.getEmail();

        Contest contest = contestDetailService.getContest(contestId);
        List<Player> players = Arrays.asList(playerDetailService.getPlayers(contestId));
        int rank = getRank(contestId, email);

        if (rank == -1) {
            logger.error("Error determining rank. Could not find player {} in contest {}.", email, contestId);
        }

        registeredContest.setContest(contest);
        registeredContest.setPlayers(players);
        registeredContest.setRank(rank);

        return registeredContest;
    }

    /**
     * @return - The rank of the player in the contest.
     */
    private int getRank(int contestId, String email) {
        List<ContestParticipants> contestParticipantsList =
                contestParticipantsRepository.findAllByContestIdOrderByPointsAsc(contestId);

        for (int count = 0; count < contestParticipantsList.size(); count++) {
            ContestParticipants contestParticipants = contestParticipantsList.get(count);

            if (contestParticipants.getEmail().equals(email)) {
                return count + 1;
            }
        }

        return -1;
    }
}
