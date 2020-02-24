package com.uncg.emuLadder.model.database;

import com.uncg.emuLadder.util.EqualsTestUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeagueStatsTest {

    private static int EVENT_POINTS_ID;
    private static int DEATHS;
    private static int ASSISTS;
    private static int KILLS;
    private static int CREEP_SCORE;

    private LeagueStats leagueStats;

    @BeforeClass
    public static void setUpBeforeClass() {
        EVENT_POINTS_ID = 1;
        DEATHS = 1;
        ASSISTS = 1;
        KILLS = 1;
        CREEP_SCORE = 1;
    }

    @Before
    public void setUp() {
        leagueStats = new LeagueStats();
    }

    @Test
    public void setEventPointsId() {
        leagueStats.setEventPointsId(EVENT_POINTS_ID);

        assertEquals(EVENT_POINTS_ID, leagueStats.getEventPointsId());
    }

    @Test
    public void setDeaths() {
        leagueStats.setDeaths(DEATHS);

        assertEquals(DEATHS, leagueStats.getDeaths());
    }

    @Test
    public void setAssists() {
        leagueStats.setAssists(ASSISTS);

        assertEquals(ASSISTS, leagueStats.getAssists());
    }

    @Test
    public void setKills() {
        leagueStats.setKills(KILLS);

        assertEquals(KILLS, leagueStats.getKills());
    }

    @Test
    public void setCreepScore() {
        leagueStats.setCreepScore(CREEP_SCORE);

        assertEquals(CREEP_SCORE, leagueStats.getCreepScore());
    }

    @Test
    public void testEquals() {
        EqualsTestUtil.testEquals(LeagueStats.class);
    }

    @Test
    public void testHashCode() {
        final int initialHash = 28629151;
        final int finalHash = 29583456;

        assertEquals(initialHash, leagueStats.hashCode());

        leagueStats.setEventPointsId(EVENT_POINTS_ID);
        leagueStats.setDeaths(DEATHS);
        leagueStats.setAssists(ASSISTS);
        leagueStats.setKills(KILLS);
        leagueStats.setCreepScore(CREEP_SCORE);

        assertEquals(finalHash, leagueStats.hashCode());
    }

    @Test
    public void testToString() {
        final String str = leagueStats.toString();

        assertTrue(str.contains("eventPointsId"));
        assertTrue(str.contains("deaths"));
        assertTrue(str.contains("assists"));
        assertTrue(str.contains("kills"));
        assertTrue(str.contains("creepScore"));
    }
}