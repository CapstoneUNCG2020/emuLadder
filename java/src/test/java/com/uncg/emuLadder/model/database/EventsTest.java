package com.uncg.emuLadder.model.database;

import com.uncg.emuLadder.util.EqualsTestUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class EventsTest {

    private static int EVENT_ID;
    private static String NAME;
    private static Date START_TIME;
    private static int CURRENT_STATE;
    private static String LINK;

    private Events events;

    @BeforeClass
    public static void setUpBeforeClass() {
        EVENT_ID = 1;
        NAME = "name";
        START_TIME = Date.valueOf(LocalDate.now());
        CURRENT_STATE = 1;
        LINK = "link";
    }

    @Before
    public void setUp() {
        events = new Events();
    }

    @Test
    public void setEventId() {
        events.setEventId(EVENT_ID);

        assertEquals(EVENT_ID, events.getEventId());
    }

    @Test
    public void setName() {
        events.setName(NAME);

        assertEquals(NAME, events.getName());
    }

    @Test
    public void setStartTime() {
        events.setStartTime(START_TIME);

        assertEquals(START_TIME, events.getStartTime());
    }

    @Test
    public void setCurrentState() {
        events.setCurrentState(CURRENT_STATE);

        assertEquals(CURRENT_STATE, events.getCurrentState());
    }

    @Test
    public void setLink() {
        events.setLink(LINK);

        assertEquals(LINK, events.getLink());
    }

    @Test
    public void testEquals() {
        EqualsTestUtil.testEquals(Events.class);
    }

    @Test
    public void testHashCode() {
        final int initialHash = 28629151;
        final int finalHash = 1775494078;

        assertEquals(initialHash, events.hashCode());

        events.setEventId(EVENT_ID);
        events.setName(NAME);
        events.setStartTime(START_TIME);
        events.setLink(LINK);
        events.setCurrentState(CURRENT_STATE);

        assertEquals(finalHash, events.hashCode());
    }

    @Test
    public void testToString() {
        final String str = events.toString();

        assertTrue(str.contains("eventId"));
        assertTrue(str.contains("name"));
        assertTrue(str.contains("startTime"));
        assertTrue(str.contains("link"));
        assertTrue(str.contains("currentState"));
    }
}