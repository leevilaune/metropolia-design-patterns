package dev.onesnzeroes.designpatterns.prototype;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalendarNewDateAdaptorTest {

    @Test
    void setDaySetsCorrectDay() {
        CalendarNewDateAdapter date = new CalendarNewDateAdapter();

        date.setDay(15);

        assertEquals(15, date.getDay());
    }

    @Test
    void setMonthSetsCorrectMonth() {
        CalendarNewDateAdapter date = new CalendarNewDateAdapter();

        date.setMonth(5); // May

        assertEquals(5, date.getMonth());
    }

    @Test
    void setYearSetsCorrectYear() {
        CalendarNewDateAdapter date = new CalendarNewDateAdapter();

        date.setYear(2024);

        assertEquals(2024, date.getYear());
    }

    @Test
    void getDayReturnsCorrectValueAfterSetting() {
        CalendarNewDateAdapter date = new CalendarNewDateAdapter();

        date.setDay(1);

        assertEquals(1, date.getDay());
    }

    @Test
    void getMonthReturnsValueBetweenOneAndTwelve() {
        CalendarNewDateAdapter date = new CalendarNewDateAdapter();

        int month = date.getMonth();

        assertTrue(month >= 1 && month <= 12);
    }

    @Test
    void getYearReturnsPositiveYear() {
        CalendarNewDateAdapter date = new CalendarNewDateAdapter();

        int year = date.getYear();

        assertTrue(year > 0);
    }

    @Test
    void advanceDaysIncreasesDayWithinSameMonth() {
        CalendarNewDateAdapter date = new CalendarNewDateAdapter();
        date.setYear(2024);
        date.setMonth(3);
        date.setDay(10);

        date.advanceDays(5);

        assertEquals(15, date.getDay());
    }

    @Test
    void advanceDaysHandlesMonthOverflow() {
        CalendarNewDateAdapter date = new CalendarNewDateAdapter();
        date.setYear(2024);
        date.setMonth(1); // January
        date.setDay(31);

        date.advanceDays(1);

        assertEquals(2, date.getMonth()); // February
        assertEquals(1, date.getDay());
    }

    @Test
    void advanceDaysHandlesYearOverflow() {
        CalendarNewDateAdapter date = new CalendarNewDateAdapter();
        date.setYear(2023);
        date.setMonth(12); // December
        date.setDay(31);

        date.advanceDays(1);

        assertEquals(2024, date.getYear());
        assertEquals(1, date.getMonth());
        assertEquals(1, date.getDay());
    }

    @Test
    void advanceDaysHandlesLeapYear() {
        CalendarNewDateAdapter date = new CalendarNewDateAdapter();
        date.setYear(2024); // leap year
        date.setMonth(2);   // February
        date.setDay(28);

        date.advanceDays(1);

        assertEquals(29, date.getDay());
    }

    @Test
    void advanceDaysHandlesNonLeapYear() {
        CalendarNewDateAdapter date = new CalendarNewDateAdapter();
        date.setYear(2023); // not leap year
        date.setMonth(2);   // February
        date.setDay(28);

        date.advanceDays(1);

        assertEquals(3, date.getMonth());
        assertEquals(1, date.getDay());
    }

    @Test
    void advanceDaysAllowsNegativeValues() {
        CalendarNewDateAdapter date = new CalendarNewDateAdapter();
        date.setYear(2024);
        date.setMonth(3);
        date.setDay(10);

        date.advanceDays(-5);

        assertEquals(5, date.getDay());
    }

    @Test
    void advanceDaysAcrossMultipleMonths() {
        CalendarNewDateAdapter date = new CalendarNewDateAdapter();
        date.setYear(2026);
        date.setMonth(1); // January
        date.setDay(30);

        date.advanceDays(120);

        // 2026 is a leap year: Jan 30 + 120 days → May 30th
        assertEquals(5, date.getMonth()); // March
        assertEquals(30, date.getDay());
        assertEquals(2026, date.getYear());
    }
}