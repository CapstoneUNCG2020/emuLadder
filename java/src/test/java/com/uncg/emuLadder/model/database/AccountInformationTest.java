package com.uncg.emuLadder.model.database;

import com.uncg.emuLadder.util.EqualsTestUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountInformationTest {

    private static String EMAIL;
    private static String FIRST_NAME;
    private static String LAST_NAME;
    private static String USER_NAME;

    private AccountInformation information;

    @BeforeClass
    public static void setUpBeforeClass() {
        EMAIL = "test@gmail.com";
        FIRST_NAME = "firstName";
        LAST_NAME = "lastName";
        USER_NAME = "userName";
    }

    @Before
    public void setUp() {
        information = new AccountInformation();
    }

    @Test
    public void setEmail() {
        information.setEmail(EMAIL);

        assertEquals(EMAIL, information.getEmail());
    }

    @Test
    public void setUsername() {
        information.setUsername(USER_NAME);

        assertEquals(USER_NAME, information.getUsername());
    }

    @Test
    public void setFirstName() {
        information.setFirstName(FIRST_NAME);

        assertEquals(FIRST_NAME, information.getFirstName());
    }

    @Test
    public void setLastName() {
        information.setLastName(LAST_NAME);

        assertEquals(LAST_NAME, information.getLastName());
    }

    @Test
    public void testEquals() {
        EqualsTestUtil.testEquals(AccountInformation.class);
    }

    @Test
    public void testHashCode() {
        int initialHash = 923521;
        int finalHash = -1216270246;

        assertEquals(initialHash, information.hashCode());

        information.setEmail(EMAIL);
        information.setUsername(USER_NAME);
        information.setFirstName(FIRST_NAME);
        information.setLastName(LAST_NAME);

        assertEquals(finalHash, information.hashCode());
    }

    @Test
    public void testToString() {
        String str = information.toString();

        assertTrue(str.contains("email"));
        assertTrue(str.contains("username"));
        assertTrue(str.contains("firstName"));
        assertTrue(str.contains("lastName"));
    }
}