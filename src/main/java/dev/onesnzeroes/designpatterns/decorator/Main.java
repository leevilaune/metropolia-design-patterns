package dev.onesnzeroes.designpatterns.decorator;

import dev.onesnzeroes.designpatterns.decorator.printers.BasicPrinter;
import dev.onesnzeroes.designpatterns.decorator.printers.EncryptedPrinter;
import dev.onesnzeroes.designpatterns.decorator.printers.Printer;
import dev.onesnzeroes.designpatterns.decorator.printers.XMLPrinter;
import dev.onesnzeroes.designpatterns.decorator.util.CryptoUtil;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");
        try {
            System.out.println("decrypted: " + CryptoUtil.decrypt("ZjvMMkkbUPCQfOWFWhBBcRhfKkCGlbyw","rE8XO7P/rnlmiLPgTaMdHA=="));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Printer printer3 = new XMLPrinter(new BasicPrinter());
        printer3.print("Hello World!");

        Printer printer4 = new XMLPrinter(new EncryptedPrinter(new BasicPrinter()));
        printer4.print("Hello World!");

    }
}
