import org.junit.Test;
import static org.junit.Assert.*;

public class Task2Test {
    @Test
    public void testTaskExamples() {
        assertEquals("8008888378", Task2.digitifyNumber("800888TEST"));
    }

    @Test
    public void testTaskExamples1() {
        assertEquals("48728378", Task2.digitifyNumber("ITSATEST"));
    }

    @Test
    public void testTaskExamples2() {
        assertEquals("16627", Task2.digitifyNumber("1NMBR"));
    }

    @Test
    public void testPersistence() {
        assertEquals("16627", Task2.digitifyNumber("1NMBR"));
        assertEquals("16627", Task2.digitifyNumber("1NMBR"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFormat() {
        Task2.digitifyNumber("123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFormat2() {
        Task2.digitifyNumber("123fas");
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        Task2.digitifyNumber(null);
    }
}
