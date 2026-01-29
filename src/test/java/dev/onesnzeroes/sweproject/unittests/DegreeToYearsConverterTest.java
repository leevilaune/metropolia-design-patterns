package dev.onesnzeroes.sweproject.unittests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DegreeToYearsConverterTest {
    DegreeToYearsConverter degree = new DegreeToYearsConverter();

    @Test
    public void bscShouldBe4(){
        assertEquals(4,degree.degreeToYears("BSc"));
    }
    @Test
    public void mscShouldBe2(){
        assertEquals(2,degree.degreeToYears("MSc"));
    }
    @Test
    public void phdShouldBe5(){
        assertEquals(5,degree.degreeToYears("PHd"));
    }
    @Test
    public void unsupportedShouldBeNegative(){
        assertEquals(-1,degree.degreeToYears("HS"));
    }
    @Test
    public void nullShouldThrowError(){
        assertThrows(NullPointerException.class, () -> degree.degreeToYears(null));
    }
}