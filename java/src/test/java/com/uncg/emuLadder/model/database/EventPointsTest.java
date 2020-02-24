package com.uncg.emuLadder.model.database;

import com.uncg.emuLadder.util.EqualsTestUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class EventPointsTest {

    private static int EVENT_POINTS_ID;
    private static int EVENT_ID;
    private static int PLAYER_ID;
    private static int POINTS;

    private EventPoints eventPoints;

    @BeforeClass
    public static void setUpBeforeClass() {
        EVENT_POINTS_ID = 1;
        EVENT_ID = 1;
        PLAYER_ID = 1;
        POINTS = 1;
    }

    @Before
    public void setUp() {
        eventPoints = new EventPoints();
    }

    @Test
    public void setEventPointsId() {
        eventPoints.setEventPointsId(EVENT_POINTS_ID);

        assertEquals(EVENT_POINTS_ID, eventPoints.getEventPointsId());
    }

    @Test
    public void setEventId() {
        eventPoints.setEventId(EVENT_ID);

        assertEquals(EVENT_ID, eventPoints.getEventId());
    }

    @Test
    public void setPlayerId() {
        eventPoints.setPlayerId(PLAYER_ID);

        assertEquals(PLAYER_ID, eventPoints.getPlayerId());
    }

    @Test
    public void setPoints() {
        eventPoints.setPoints(POINTS);

        assertEquals(POINTS, eventPoints.getPoints());
    }

    @Test
    public void testEquals() {
        EqualsTestUtil.testEquals(EventPoints.class);
    }

    @Test
    public void testHashCode() {
        final int initialHash = 923521;
        final int finalHash = 954305;

        assertEquals(initialHash, eventPoints.hashCode());

        eventPoints.setEventPointsId(EVENT_POINTS_ID);
        eventPoints.setEventId(EVENT_ID);
        eventPoints.setPlayerId(PLAYER_ID);
        eventPoints.setPoints(POINTS);

        assertEquals(finalHash, eventPoints.hashCode());
    }

    @Test
    public void testToString() {
        final String str = eventPoints.toString();

        assertTrue(str.contains("eventPointsId"));
        assertTrue(str.contains("eventId"));
        assertTrue(str.contains("playerId"));
        assertTrue(str.contains("points"));
    }
}