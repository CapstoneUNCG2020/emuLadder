package com.uncg.emuLadder.handler;

import com.uncg.emuLadder.model.response.RegisteredContestsData;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.sanitizer.StringSanitizer;
import com.uncg.emuLadder.service.RegisteredContestsService;
import org.springframework.stereotype.Component;

/**
 * Handler class for receiving all information about a contest.
 */
@Component
public class RegisteredContestsHandler extends AbstractHandler<String, ResponseData<RegisteredContestsData>> {

    public RegisteredContestsHandler(RegisteredContestsService service, StringSanitizer sanitizer) {
        super(service, sanitizer);
    }
}
