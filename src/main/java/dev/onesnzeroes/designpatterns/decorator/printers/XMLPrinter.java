package dev.onesnzeroes.designpatterns.decorator.printers;

public class XMLPrinter implements Printer {

    public Printer printer;
    public XMLPrinter(Printer printer) {

        this.printer = printer;
    }

    @Override
    public String print(String s) {
        s = "<message>" + s + "</message>";
        return printer.print(s);
    }
}
