package dev.onesnzeroes.designpatterns.builder.model;

public class ComputerDirector {

    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer constructGamingComputer() {
        return this.builder
                .addProcessor("Intel i9")
                .addRam(32)
                .addHardDrive("1TB SSD")
                .addGraphicsCard("RTX 4090")
                .addOperatingSystem("Ubuntu")
                .build();
    }

    public Computer constructOfficeComputer() {
        return this.builder
                .addProcessor("Intel i5")
                .addRam(16)
                .addHardDrive("512GB SSD")
                .addGraphicsCard("Integrated Graphics")
                .addOperatingSystem("macOS")
                .build();
    }
}