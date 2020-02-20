package com.uncg.emuLadder.model.database;

import com.uncg.emuLadder.util.EqualsTestUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContestEventsTest {

    private static int CONTEST_EVENTS_ID;
    private static int CONTEST_ID;
    private static int EVENT_ID;

    private ContestEvents contestEvents;

    @BeforeClass
    public static void setUpBeforeClass() {
        CONTEST_EVENTS_ID = 1;
        CONTEST_ID = 1;
        EVENT_ID = 1;
    }

    @Before
    public void setUp() {
        contestEvents = new ContestEvents();
    }

    @Test
    public void setContestEventsId() {
        contestEvents.setContestEventsId(CONTEST_EVENTS_ID);

        assertEquals(CONTEST_EVENTS_ID, contestEvents.getContestEventsId());
    }

    @Test
    public void setContestId() {
        contestEvents.setContestId(CONTEST_ID);

        assertEquals(CONTEST_ID, contestEvents.getContestId());
    }

    @Test
    public void setEventId() {
        contestEvents.setEventId(EVENT_ID);

        assertEquals(EVENT_ID, contestEvents.getEventId());
    }

    @Test
    public void testEquals() {
        EqualsTestUtil.testEquals(ContestEvents.class);
    }

    @Test
    public void testHashCode() {
        final int initialHash = 29791;
        final int finalHash = 30784;

        assertEquals(initialHash, contestEvents.hashCode());

        contestEvents.setContestEventsId(CONTEST_EVENTS_ID);
        contestEvents.setContestId(CONTEST_ID);
        contestEvents.setEventId(EVENT_ID);

        assertEquals(finalHash, contestEvents.hashCode());
    }

    @Test
    public void testToString() {
        final String str = contestEvents.toString();

        assertTrue(str.contains("contestEventsId"));
        assertTrue(str.contains("contestId"));
        assertTrue(str.contains("eventId"));
    }
}