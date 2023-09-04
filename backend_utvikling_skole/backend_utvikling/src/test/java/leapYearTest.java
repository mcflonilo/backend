import com.example.backend_utvikling.isLeapYear;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class leapYearTest {

    @Test
    public void shouldDoSomething(){
        assertEquals(isLeapYear.isLeapYear(2000), true);
        assertEquals(isLeapYear.isLeapYear(2002), false);
        assertEquals(isLeapYear.isLeapYear(2003), false);
        assertEquals(isLeapYear.isLeapYear(2004), true);
        assertEquals(isLeapYear.isLeapYear(2005), false);
        assertEquals(isLeapYear.isLeapYear(2006), false);
        assertEquals(isLeapYear.isLeapYear(2007), false);
        assertEquals(isLeapYear.isLeapYear(2008), true);
        assertEquals(isLeapYear.isLeapYear(2009), false);
        assertEquals(isLeapYear.isLeapYear(2010), false);
        assertEquals(isLeapYear.isLeapYear(2011), false);
        assertEquals(isLeapYear.isLeapYear(2012), true);
    }

}