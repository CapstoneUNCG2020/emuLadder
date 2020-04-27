package com.uncg.emuLadder.service;

import com.uncg.emuLadder.enums.ResponseStatusType;
import com.uncg.emuLadder.model.database.ContestParticipants;
import com.uncg.emuLadder.model.request.DraftingRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.repository.ContestParticipantsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service class for getting the data needed to start drafting players.
 */
@Component
public class DraftingService implements IService<DraftingRequestData, ResponseData<Boolean>> {

    private final Logger logger = LoggerFactory.getLogger((getClass()));

    private final ContestParticipantsRepository contestParticipantsRepository;

    @Autowired
    public DraftingService(
            final ContestParticipantsRepository contestParticipantsRepository
    ) {
        this.contestParticipantsRepository = contestParticipantsRepository;
    }

    @Override
    public ResponseData<Boolean> service(DraftingRequestData requestData) {
        ResponseData<Boolean> responseData = new ResponseData<>();

        // Delete existing drafting information
        contestParticipantsRepository.deleteAllByContestIdAndEmail(requestData.getContestId(), requestData.getEmail());

        ContestParticipants contestParticipants = new ContestParticipants();
        contestParticipants.setContestId(requestData.getContestId());
        contestParticipants.setEmail(requestData.getEmail());
        contestParticipants.setBottom(requestData.getBottom());
        contestParticipants.setJungle(requestData.getJungle());
        contestParticipants.setMid(requestData.getMid());
        contestParticipants.setSupport(requestData.getSupport());
        contestParticipants.setTop(requestData.getTop());

        contestParticipantsRepository.saveAndFlush(contestParticipants);

        logger.info("Successfully drafted players for {} in contest {}", requestData.getEmail(),
                requestData.getContestId());

        responseData.setStatus(ResponseStatusType.SUCCESS.name());
        responseData.setResponse(true);

        return responseData;
    }


}
