package com.uncg.emuLadder.service.bl;

import com.uncg.emuLadder.enums.ContestTypes;
import com.uncg.emuLadder.model.database.Contests;
import com.uncg.emuLadder.model.response.Contest;
import com.uncg.emuLadder.repository.ContestParticipantsRepository;
import com.uncg.emuLadder.repository.ContestsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContestDetailService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ContestsRepository contestsRepository;
    private final ContestParticipantsRepository contestParticipantsRepository;

    @Autowired
    public ContestDetailService(
            final ContestsRepository contestsRepository,
            final ContestParticipantsRepository contestParticipantsRepository
    ) {
        this.contestsRepository = contestsRepository;
        this.contestParticipantsRepository = contestParticipantsRepository;
    }

    /**
     * Get the details of the contest from the given contestId
     * @return The Contest object
     */
    public Contest getContest(int contestId) {
        // Response Object
        Contest contest = new Contest();

        /* Attempt to resolve the contests data */
        Optional<Contests> optional = contestsRepository.findById(contestId);

        // Check to see if optional exists
        if (!optional.isPresent()) {
            logger.error("Cannot find event ID: {}", contestId);
            return null;
        }

        // Get the contests data from database
        Contests dbContest = optional.get();

        /* Set the contest type */
        switch (dbContest.getContestType()) {
            case 0:
                contest.setContestType(ContestTypes.HEAD_TO_HEAD.name());
                break;
            case 1:
                contest.setContestType(ContestTypes.PUBLIC.name());
                break;
            case 2:
                contest.setContestType(ContestTypes.PRIVATE.name());
                break;
            default:
                logger.error("Unsupported contest type: {}", dbContest.getContestType());
                return null;
        }

        // Get the number of people signed up for the contest
        contest.setCurrentEntries(contestParticipantsRepository.countByContestId(contestId));

        contest.setTotalEntries(dbContest.getContestSize());
        contest.setEntreeFee(dbContest.getEntreeFee());
        contest.setName(dbContest.getName());
        contest.setPrizeAmount(dbContest.getPrizeAmount());
        contest.setStart(dbContest.getStartTime());

        return contest;
    }
}
