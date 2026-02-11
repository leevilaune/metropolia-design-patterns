package dev.onesnzeroes.designpatterns.decorator.printers;

public class BasicPrinter implements Printer{

    @Override
    public String print(String s) {
        System.out.println(s);
        return s;
    }
}
