package com.uncg.emuLadder.model.database;

import com.uncg.emuLadder.util.EqualsTestUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContestParticipantsTest {

    private static int CONTEST_PARTICIPANTS_ID;
    private static String USER_ID;
    private static int CONTEST_ID;

    private ContestParticipants contestParticipants;

    @BeforeClass
    public static void setUpBeforeClass() {
        CONTEST_PARTICIPANTS_ID = 1;
        USER_ID = "userId";
        CONTEST_ID = 1;
    }

    @Before
    public void setUp() {
        contestParticipants = new ContestParticipants();
    }

    @Test
    public void setContestParticipantsId() {
        contestParticipants.setContestParticipantsId(CONTEST_PARTICIPANTS_ID);

        assertEquals(CONTEST_PARTICIPANTS_ID, contestParticipants.getContestParticipantsId());
    }

    @Test
    public void setUserId() {
        contestParticipants.setUserId(USER_ID);

        assertEquals(USER_ID, contestParticipants.getUserId());
    }

    @Test
    public void setContestId() {
        contestParticipants.setContestId(CONTEST_ID);

        assertEquals(CONTEST_ID, contestParticipants.getContestId());
    }

    @Test
    public void testEquals() {
        EqualsTestUtil.testEquals(ContestParticipants.class);
    }

    @Test
    public void testHashCode() {
        final int initialHash = 29791;
        final int finalHash = -147123557;

        assertEquals(initialHash, contestParticipants.hashCode());

        contestParticipants.setContestParticipantsId(CONTEST_PARTICIPANTS_ID);
        contestParticipants.setContestId(CONTEST_ID);
        contestParticipants.setUserId(USER_ID);

        assertEquals(finalHash, contestParticipants.hashCode());
    }

    @Test
    public void testToString() {
        final String str = contestParticipants.toString();

        assertTrue(str.contains("contestParticipantsId"));
        assertTrue(str.contains("contestId"));
        assertTrue(str.contains("userId"));
    }
}