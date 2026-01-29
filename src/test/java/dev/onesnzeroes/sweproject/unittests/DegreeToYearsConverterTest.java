package dev.onesnzeroes.sweproject.unittests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DegreeToYearsConverterTest {

    @Test
    public void degreeToYearsTest(){
        DegreeToYearsConverter degree = new DegreeToYearsConverter();
        assertEquals(degree.degreeToYears("Bsc"),4);
        assertEquals(degree.degreeToYears("Msc"),2);
        assertEquals(degree.degreeToYears("PHd"),5);

        assertEquals(degree.degreeToYears("hs"),-1);

        assertThrows(NullPointerException.class, () -> degree.degreeToYears(null));

    }
}