package application.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PayUserTest {
    @Test
    public void testCanEqual() {
        assertFalse((new PayUser()).canEqual("other"));
    }

    @Test
    public void testCanEqual2() {
        PayUser payUser = new PayUser();

        PayUser payUser1 = new PayUser();
        payUser1.setUserId("42");
        assertTrue(payUser.canEqual(payUser1));
    }

    @Test
    public void testEquals() {
        assertFalse((new PayUser()).equals("o"));
    }

    @Test
    public void testEquals2() {
        PayUser payUser = new PayUser();

        PayUser payUser1 = new PayUser();
        payUser1.setUserId("42");
        assertFalse(payUser.equals(payUser1));
    }

    @Test
    public void testEquals3() {
        PayUser payUser = new PayUser("42");

        PayUser payUser1 = new PayUser();
        payUser1.setUserId("42");
        assertTrue(payUser.equals(payUser1));
    }

    @Test
    public void testEquals4() {
        PayUser payUser = new PayUser();

        PayUser payUser1 = new PayUser();
        payUser1.setUserId(null);
        assertTrue(payUser.equals(payUser1));
    }

    @Test
    public void testEquals5() {
        PayUser payUser = new PayUser("User Id");

        PayUser payUser1 = new PayUser();
        payUser1.setUserId("42");
        assertFalse(payUser.equals(payUser1));
    }

    @Test
    public void testHashCode() {
        assertEquals(102, (new PayUser()).hashCode());
        assertEquals(1721, (new PayUser("42")).hashCode());
    }

    @Test
    public void testSetUserId() {
        PayUser payUser = new PayUser();
        payUser.setUserId("42");
        assertEquals("42", payUser.getUserId());
    }

    @Test
    public void testToString() {
        assertEquals("PayUser(userId=null)", (new PayUser()).toString());
    }
}

