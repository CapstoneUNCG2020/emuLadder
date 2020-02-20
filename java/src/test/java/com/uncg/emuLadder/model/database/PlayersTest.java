package com.uncg.emuLadder.model.database;

import com.uncg.emuLadder.util.EqualsTestUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sun.dc.pr.PRError;

import static org.junit.Assert.*;

public class PlayersTest {

    private static int PLAYER_ID;
    private static String FIRST_NAME;
    private static String LAST_NAME;
    private static String DISPLAY_NAME;
    private static String IMAGE;
    private static int SALARY;

    private Players players;

    @BeforeClass
    public static void setUpBeforeClass() {
        PLAYER_ID = 1;
        FIRST_NAME = "firstName";
        LAST_NAME = "lastName";
        DISPLAY_NAME = "displayName";
        IMAGE = "image";
        SALARY = 1;
    }

    @Before
    public void setUp() {
        players = new Players();
    }

    @Test
    public void setPlayerId() {
        players.setPlayerId(PLAYER_ID);

        assertEquals(PLAYER_ID, players.getPlayerId());
    }

    @Test
    public void setFirstName() {
        players.setFirstName(FIRST_NAME);

        assertEquals(FIRST_NAME, players.getFirstName());
    }

    @Test
    public void setLastName() {
        players.setLastName(LAST_NAME);

        assertEquals(LAST_NAME, players.getLastName());
    }

    @Test
    public void setDisplayName() {
        players.setDisplayName(DISPLAY_NAME);

        assertEquals(DISPLAY_NAME, players.getDisplayName());
    }

    @Test
    public void setImage() {
        players.setImage(IMAGE);

        assertEquals(IMAGE, players.getImage());
    }

    @Test
    public void setSalary() {
        players.setSalary(SALARY);

        assertEquals(SALARY, players.getSalary());
    }

    @Test
    public void testEquals() {
        EqualsTestUtil.testEquals(Players.class);
    }

    @Test
    public void testHashCode() {
        final int initialHash = 887503681;
        final int finalHash = 751161101;

        assertEquals(initialHash, players.hashCode());

        players.setPlayerId(PLAYER_ID);
        players.setFirstName(FIRST_NAME);
        players.setLastName(LAST_NAME);
        players.setDisplayName(DISPLAY_NAME);
        players.setImage(IMAGE);
        players.setSalary(SALARY);

        assertEquals(finalHash, players.hashCode());
    }

    @Test
    public void testToString() {
        final String str = players.toString();

        assertTrue(str.contains("playerId"));
        assertTrue(str.contains("firstName"));
        assertTrue(str.contains("lastName"));
        assertTrue(str.contains("displayName"));
        assertTrue(str.contains("image"));
        assertTrue(str.contains("salary"));
    }
}