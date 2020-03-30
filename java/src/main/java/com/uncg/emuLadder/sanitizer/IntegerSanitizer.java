package com.uncg.emuLadder.sanitizer;

import org.springframework.stereotype.Component;

/**
 * Sanitizer for simple integer input.
 */
@Component
public class IntegerSanitizer implements ISanitizer<Integer> {
    @Override
    public Integer sanitize(Integer requestData) {
        return requestData;
    }
}
