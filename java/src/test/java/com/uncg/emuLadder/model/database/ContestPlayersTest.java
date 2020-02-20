package com.uncg.emuLadder.model.database;

import com.uncg.emuLadder.util.EqualsTestUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContestPlayersTest {

    private static int CONTEST_PLAYERS_ID;
    private static int CONTEST_ID;
    private static int PLAYER_ID;

    private ContestPlayers contestPlayers;

    @BeforeClass
    public static void setUpBeforeClass() {
        CONTEST_PLAYERS_ID = 1;
        CONTEST_ID = 1;
        PLAYER_ID = 1;
    }

    @Before
    public void setUp() {
        contestPlayers = new ContestPlayers();
    }

    @Test
    public void setContestPlayersId() {
        contestPlayers.setContestPlayersId(CONTEST_PLAYERS_ID);

        assertEquals(CONTEST_PLAYERS_ID, contestPlayers.getContestPlayersId());
    }

    @Test
    public void setContestId() {
        contestPlayers.setContestId(CONTEST_ID);

        assertEquals(CONTEST_ID, contestPlayers.getContestId());
    }

    @Test
    public void setPlayerId() {
        contestPlayers.setPlayerId(PLAYER_ID);

        assertEquals(PLAYER_ID, contestPlayers.getPlayerId());
    }

    @Test
    public void testEquals() {
        EqualsTestUtil.testEquals(ContestPlayers.class);
    }

    @Test
    public void testHashCode() {
        final int initialHash = 29791;
        final int finalHash = 30784;

        assertEquals(initialHash, contestPlayers.hashCode());

        contestPlayers.setContestPlayersId(CONTEST_PLAYERS_ID);
        contestPlayers.setContestId(CONTEST_ID);
        contestPlayers.setPlayerId(PLAYER_ID);

        assertEquals(finalHash, contestPlayers.hashCode());
    }

    @Test
    public void testToString() {
        final String str = contestPlayers.toString();

        assertTrue(str.contains("contestPlayersId"));
        assertTrue(str.contains("contestId"));
        assertTrue(str.contains("playerId"));
    }
}