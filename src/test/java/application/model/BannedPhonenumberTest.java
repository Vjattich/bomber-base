package application.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BannedPhonenumberTest {
    @Test
    public void testCanEqual() {
        assertFalse((new BannedPhonenumber()).canEqual("other"));
    }

    @Test
    public void testCanEqual2() {
        BannedPhonenumber bannedPhonenumber = new BannedPhonenumber();

        BannedPhonenumber bannedPhonenumber1 = new BannedPhonenumber();
        bannedPhonenumber1.setNumber("4105551212");
        assertTrue(bannedPhonenumber.canEqual(bannedPhonenumber1));
    }

    @Test
    public void testEquals() {
        assertFalse((new BannedPhonenumber()).equals("o"));
    }

    @Test
    public void testEquals2() {
        BannedPhonenumber bannedPhonenumber = new BannedPhonenumber();

        BannedPhonenumber bannedPhonenumber1 = new BannedPhonenumber();
        bannedPhonenumber1.setNumber("4105551212");
        assertFalse(bannedPhonenumber.equals(bannedPhonenumber1));
    }

    @Test
    public void testEquals3() {
        BannedPhonenumber bannedPhonenumber = new BannedPhonenumber("4105551212");

        BannedPhonenumber bannedPhonenumber1 = new BannedPhonenumber();
        bannedPhonenumber1.setNumber("4105551212");
        assertTrue(bannedPhonenumber.equals(bannedPhonenumber1));
    }

    @Test
    public void testEquals4() {
        BannedPhonenumber bannedPhonenumber = new BannedPhonenumber();

        BannedPhonenumber bannedPhonenumber1 = new BannedPhonenumber();
        bannedPhonenumber1.setNumber(null);
        assertTrue(bannedPhonenumber.equals(bannedPhonenumber1));
    }

    @Test
    public void testEquals5() {
        BannedPhonenumber bannedPhonenumber = new BannedPhonenumber("+44 1865 4960636");

        BannedPhonenumber bannedPhonenumber1 = new BannedPhonenumber();
        bannedPhonenumber1.setNumber("4105551212");
        assertFalse(bannedPhonenumber.equals(bannedPhonenumber1));
    }

    @Test
    public void testHashCode() {
        assertEquals(102, (new BannedPhonenumber()).hashCode());
        assertEquals(-883317089, (new BannedPhonenumber("4105551212")).hashCode());
    }

    @Test
    public void testsetNumber() {
        BannedPhonenumber bannedPhonenumber = new BannedPhonenumber();
        bannedPhonenumber.setNumber("4105551212");
        assertEquals("4105551212", bannedPhonenumber.getNumber());
    }

    @Test
    public void testToString() {
        assertEquals("BannedPhonenumber(number=null)", (new BannedPhonenumber()).toString());
    }
}

