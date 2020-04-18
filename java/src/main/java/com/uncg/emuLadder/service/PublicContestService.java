package com.uncg.emuLadder.service;

import com.uncg.emuLadder.enums.ContestTypes;
import com.uncg.emuLadder.model.database.Contests;
import com.uncg.emuLadder.model.response.Contest;
import com.uncg.emuLadder.model.response.ContestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.repository.ContestsRepository;
import com.uncg.emuLadder.model.response.PublicContests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PublicContestService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ContestsRepository contestsRepository;

    @Autowired
    public PublicContestService(final ContestsRepository contestsRepository) {
        this.contestsRepository = contestsRepository;
    }

    public ResponseData<PublicContests> getContestData() {
        ResponseData<PublicContests> responseData = new ResponseData<>();
        PublicContests publicContests = new PublicContests();
        List<Contest> tempContestList = new ArrayList<>();

        ArrayList<Contests> contestsArrayList = new ArrayList<>(contestsRepository.findAll());

        for(Contests contests: contestsArrayList) {
            if(contests.getContestType() == ContestTypes.PUBLIC.getValue()) {
                logger.info("Found Public Contest {} contest type equals {}", contests.getName(), contests.getContestType());
                Contest contest = new Contest();
                contest.setContestId(contests.getContestId());
                contest.setName(contests.getName());
                contest.setStart(contests.getStartTime());
                contest.setContestType(contests.getContestType());
                contest.setEntreeFee(contests.getEntreeFee());
                contest.setPrizeAmount(contests.getPrizeAmount());
                contest.setEntreeFee(10.00);
                contest.setCurrentEntries(2);
                contest.setTotalEntries(10);

                tempContestList.add(contest);
            }
        }

        publicContests.setContests(tempContestList);

        responseData.setResponse(publicContests);

        return responseData;
    }
}
