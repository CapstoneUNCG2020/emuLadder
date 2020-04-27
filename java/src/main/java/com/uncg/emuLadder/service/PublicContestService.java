package com.uncg.emuLadder.service;

import com.uncg.emuLadder.enums.ContestTypes;
import com.uncg.emuLadder.model.database.Contests;
import com.uncg.emuLadder.model.response.Contest;
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
            if(contests.getContestType() == ContestTypes.PUBLIC.getValue() || contests.getContestType() == ContestTypes.HEAD_TO_HEAD.getValue()) {
                logger.info("Found Public Contest {} contest type equals {}", contests.getName(), contests.getContestType());
                Contest contest = new Contest();
                contest.setContestId(contests.getContestId());
                contest.setName(contests.getName());
                contest.setStart(contests.getStartTime());
                contest.setContestType(contests.getContestType());
                contest.setEntryFee(contests.getEntreeFee());
                contest.setPrizeAmount(contests.getPrizeAmount());
                contest.setEntryFee(contests.getEntreeFee());
                contest.setCurrentEntries(1);
                contest.setTotalEntries(contests.getContestSize());
                contest.setRegion(contests.getRegion());

                tempContestList.add(contest);
            }
        }

        publicContests.setContests(tempContestList);

        responseData.setResponse(publicContests);

        return responseData;
    }
}
