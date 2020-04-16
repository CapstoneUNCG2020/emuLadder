package com.uncg.emuLadder.service;

import com.uncg.emuLadder.model.request.DraftingRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
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

    @Autowired
    public DraftingService(

    ) {
    }

    @Override
    public ResponseData<Boolean> service(DraftingRequestData contestId) {
        ResponseData<Boolean> responseData = new ResponseData<>();

        return responseData;
    }


}
