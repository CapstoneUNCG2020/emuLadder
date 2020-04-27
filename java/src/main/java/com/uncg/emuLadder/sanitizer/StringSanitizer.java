package com.uncg.emuLadder.sanitizer;

import org.springframework.stereotype.Component;

/**
 * Sanitizer for simple integer input.
 */
@Component
public class StringSanitizer implements ISanitizer<String> {
    @Override
    public String sanitize(String requestData) {
        return requestData;
    }
}
