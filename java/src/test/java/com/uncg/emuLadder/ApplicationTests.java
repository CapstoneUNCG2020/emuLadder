package com.uncg.emuLadder;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ApplicationTests {
    @Test
    public void testConstructor() {
        final Application application = new Application();
        assertNotNull(application);
    }
    @Test
    public void testMain() {
        Application.main(new String[]{});
    }
}
