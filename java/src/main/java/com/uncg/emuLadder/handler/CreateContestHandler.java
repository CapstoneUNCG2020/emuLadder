package com.uncg.emuLadder.handler;

import com.uncg.emuLadder.model.request.CreateContestRequestData;
import com.uncg.emuLadder.model.response.ContestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.sanitizer.CreateContestSanitizer;
import com.uncg.emuLadder.service.CreateContestService;
import org.springframework.stereotype.Component;

/**
 * Handler class for receiving all information about a contest.
 */
@Component
public class CreateContestHandler extends AbstractHandler<CreateContestRequestData, ResponseData<ContestData>> {

    public CreateContestHandler(CreateContestService service, CreateContestSanitizer sanitizer) {
        super(service, sanitizer);
    }
}
