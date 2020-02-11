package com.uncg.emuLadder.config.database;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.*;

public class DataSourceConfigTest {

    private DataSourceConfig config;

    @Before
    public void setUp() {
        config = new DataSourceConfig();
    }

    @Test
    public void getDataSource() {
        assertNotNull(config.getDataSource());
    }
}