package com.uncg.emuLadder.handler;

import com.uncg.emuLadder.model.response.ContestData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.sanitizer.IntegerSanitizer;
import com.uncg.emuLadder.service.ContestDataService;
import org.springframework.stereotype.Component;

/**
 * Handler class for receiving all information about a contest.
 */
@Component
public class ContestDataHandler extends AbstractHandler<Integer, ResponseData<ContestData>> {

    public ContestDataHandler(ContestDataService service, IntegerSanitizer sanitizer) {
        super(service, sanitizer);
    }
}
