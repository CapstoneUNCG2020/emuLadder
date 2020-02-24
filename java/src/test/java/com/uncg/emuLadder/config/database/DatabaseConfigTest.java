package com.uncg.emuLadder.config.database;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseConfigTest {

    private DatabaseConfig config;

    @Before
    public void setUp() {
        config = new DatabaseConfig();
    }

    @Test
    public void getDatabase() {
        assertNotNull(config.getDataSource());
    }
}