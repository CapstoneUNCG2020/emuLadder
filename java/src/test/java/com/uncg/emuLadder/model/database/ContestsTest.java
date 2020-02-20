package com.uncg.emuLadder.model.database;

import com.uncg.emuLadder.util.EqualsTestUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class ContestsTest {

    private static int CONTEST_ID;
    private static String CREATED_BY;
    private static Date START_TIME;
    private static String NAME;
    private static int CURRENT_STATE;

    private Contests contests;

    @BeforeClass
    public static void setUpBeforeClass() {
        CONTEST_ID = 1;
        CREATED_BY = "createdBy";
        START_TIME = Date.valueOf(LocalDate.now());
        NAME = "name";
        CURRENT_STATE = 1;
    }

    @Before
    public void setUp() {
        contests = new Contests();
    }

    @Test
    public void setContestId() {
        contests.setContestId(CONTEST_ID);

        assertEquals(CONTEST_ID, contests.getContestId());
    }

    @Test
    public void setCreatedBy() {
        contests.setCreatedBy(CREATED_BY);

        assertEquals(CREATED_BY, contests.getCreatedBy());
    }

    @Test
    public void setStartTime() {
        contests.setStartTime(START_TIME);

        assertEquals(START_TIME, contests.getStartTime());
    }

    @Test
    public void setName() {
        contests.setName(NAME);

        assertEquals(NAME, contests.getName());
    }

    @Test
    public void setCurrentState() {
        contests.setCurrentState(CURRENT_STATE);

        assertEquals(CURRENT_STATE, contests.getCurrentState());
    }

    @Test
    public void testEquals() {
        EqualsTestUtil.testEquals(Contests.class);
    }

    @Test
    public void testHashCode() {
        final int initialHash = 28629151;
        final int finalHash = 2131310375;

        assertEquals(initialHash, contests.hashCode());

        contests.setContestId(CONTEST_ID);
        contests.setCreatedBy(CREATED_BY);
        contests.setStartTime(START_TIME);
        contests.setName(NAME);
        contests.setCurrentState(CURRENT_STATE);

        assertEquals(finalHash, contests.hashCode());
    }

    @Test
    public void testToString() {
        final String str = contests.toString();

        assertTrue(str.contains("contestId"));
        assertTrue(str.contains("createdBy"));
        assertTrue(str.contains("startTime"));
        assertTrue(str.contains("name"));
        assertTrue(str.contains("currentState"));
    }
}