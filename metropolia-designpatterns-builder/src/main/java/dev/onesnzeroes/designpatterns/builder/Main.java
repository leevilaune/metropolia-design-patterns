package dev.onesnzeroes.designpatterns.builder;

import dev.onesnzeroes.designpatterns.builder.model.Computer;
import dev.onesnzeroes.designpatterns.builder.model.ComputerBuilder;
import dev.onesnzeroes.designpatterns.builder.model.ComputerDirector;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder builder = new ComputerBuilder();
        ComputerDirector director = new ComputerDirector(builder);

        Computer gamingPc = director.constructGamingComputer();
        System.out.println(gamingPc);

        Computer officePc = director.constructOfficeComputer();
        System.out.println(officePc);
    }
}