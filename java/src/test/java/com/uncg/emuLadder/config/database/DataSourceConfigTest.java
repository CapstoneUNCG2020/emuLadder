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

        ReflectionTestUtils.setField(config, "driver", "driver");
        ReflectionTestUtils.setField(config, "url", "url");
        ReflectionTestUtils.setField(config, "databaseName", "databaseName");
        ReflectionTestUtils.setField(config, "port", 1);
        ReflectionTestUtils.setField(config, "driverClassName", "driverClassName");
        ReflectionTestUtils.setField(config, "username", "username");
        ReflectionTestUtils.setField(config, "password", "password");
    }

    @Test
    public void getDataSource() {
        assertNotNull(config.getDataSource());
    }
}