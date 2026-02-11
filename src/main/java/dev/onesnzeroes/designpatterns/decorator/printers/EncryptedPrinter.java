package dev.onesnzeroes.designpatterns.decorator.printers;

import dev.onesnzeroes.designpatterns.decorator.util.CryptoUtil;

import java.security.Key;

public class EncryptedPrinter implements Printer{

    private final String KEY = "ZjvMMkkbUPCQfOWFWhBBcRhfKkCGlbyw";

    private Printer printer;
    public EncryptedPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public String print(String s) {
        try {
            s = CryptoUtil.encrypt(this.KEY, s);
            return this.printer.print(s);

        } catch (Exception e) {
            return this.printer.print(s);

        }
    }
}
