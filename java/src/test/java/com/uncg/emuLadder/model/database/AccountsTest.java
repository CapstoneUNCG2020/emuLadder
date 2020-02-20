package com.uncg.emuLadder.model.database;

import com.uncg.emuLadder.util.EqualsTestUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountsTest {

    private static String EMAIL;
    private static String FIRST_NAME;
    private static String LAST_NAME;
    private static String USER_ID;

    private Accounts accounts;

    @BeforeClass
    public static void setUpBeforeClass() {
        EMAIL = "test@gmail.com";
        FIRST_NAME = "firstName";
        LAST_NAME = "lastName";
        USER_ID = "userName";
    }

    @Before
    public void setUp() {
        accounts = new Accounts();
    }

    @Test
    public void setEmail() {
        accounts.setEmail(EMAIL);

        assertEquals(EMAIL, accounts.getEmail());
    }

    @Test
    public void setUsername() {
        accounts.setUserId(USER_ID);

        assertEquals(USER_ID, accounts.getUserId());
    }

    @Test
    public void setFirstName() {
        accounts.setFirstName(FIRST_NAME);

        assertEquals(FIRST_NAME, accounts.getFirstName());
    }

    @Test
    public void setLastName() {
        accounts.setLastName(LAST_NAME);

        assertEquals(LAST_NAME, accounts.getLastName());
    }

    @Test
    public void testEquals() {
        EqualsTestUtil.testEquals(Accounts.class);
    }

    @Test
    public void testHashCode() {
        int initialHash = 923521;
        int finalHash = -1216270246;

        assertEquals(initialHash, accounts.hashCode());

        accounts.setEmail(EMAIL);
        accounts.setUserId(USER_ID);
        accounts.setFirstName(FIRST_NAME);
        accounts.setLastName(LAST_NAME);

        assertEquals(finalHash, accounts.hashCode());
    }

    @Test
    public void testToString() {
        String str = accounts.toString();

        assertTrue(str.contains("email"));
        assertTrue(str.contains("userId"));
        assertTrue(str.contains("firstName"));
        assertTrue(str.contains("lastName"));
    }
}