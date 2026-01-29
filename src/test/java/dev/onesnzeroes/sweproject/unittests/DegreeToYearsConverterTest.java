package dev.onesnzeroes.sweproject.unittests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DegreeToYearsConverterTest {

    @Test
    public void degreeToYearsTest(){
        DegreeToYearsConverter degree = new DegreeToYearsConverter();
        assertEquals(4,degree.degreeToYears("Bsc"));
        assertEquals(2,degree.degreeToYears("Msc"));
        assertEquals(5,degree.degreeToYears("PHd"));

        assertEquals(-1,degree.degreeToYears("hs"));

        assertThrows(NullPointerException.class, () -> degree.degreeToYears(null));
    }
}