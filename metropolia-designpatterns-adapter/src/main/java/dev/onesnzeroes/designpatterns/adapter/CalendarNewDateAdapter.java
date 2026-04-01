package dev.onesnzeroes.designpatterns.adapter;

import java.util.Calendar;

public class CalendarNewDateAdapter implements INewDate{

    private Calendar calendar;

    public CalendarNewDateAdapter(){
        this.calendar = Calendar.getInstance();
    }
    @Override
    public void setDay(int day) {
        this.calendar.set(Calendar.DAY_OF_MONTH, day);
    }
    @Override
    public void setMonth(int month) {
        this.calendar.set(Calendar.MONTH, month - 1);
    }
    @Override
    public void setYear(int year) {
        this.calendar.set(Calendar.YEAR, year);
    }
    @Override
    public int getDay() {
        return this.calendar.get(Calendar.DAY_OF_MONTH);
    }
    @Override
    public int getMonth() {
        return this.calendar.get(Calendar.MONTH) + 1;
    }
    @Override
    public int getYear() {
        return this.calendar.get(Calendar.YEAR);
    }
    @Override
    public void advanceDays(int days) {
        this.calendar.add(Calendar.DAY_OF_MONTH, days);
    }

    @Override
    public String toString() {
        return getYear() + "-" + getMonth() + "-" + getDay();
    }
}