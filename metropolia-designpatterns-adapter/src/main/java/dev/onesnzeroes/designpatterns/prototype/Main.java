package dev.onesnzeroes.designpatterns.prototype;
public class Main {
    public static void main(String[] args) {
        CalendarNewDateAdapter adapter = new CalendarNewDateAdapter();
        adapter.setYear(2024);
        adapter.setMonth(1);
        adapter.setDay(10);
        System.out.println("Original date: " + adapter);
        adapter.advanceDays(75);
        System.out.println("After advancing 75 days: " + adapter);
        adapter.advanceDays(-100);
        System.out.println("After going back 100 days: " + adapter);
    }
}