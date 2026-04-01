package dev.onesnzeroes.designpatterns.builder.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComputerBuilderTest {

    @Test
    void addProcessorSetsProcessor() {
        ComputerBuilder builder = new ComputerBuilder();

        builder.addProcessor("Intel i7");
        Computer computer = builder.build();

        assertEquals("Intel i7", computer.getProcessor());
    }

    @Test
    void addRamSetsRamGb() {
        ComputerBuilder builder = new ComputerBuilder();

        builder.addProcessor("Intel i5");
        builder.addRam(16);
        Computer computer = builder.build();

        assertEquals(16, computer.getRamGb());
    }

    @Test
    void addHardDriveSetsHardDrive() {
        ComputerBuilder builder = new ComputerBuilder();

        builder.addProcessor("Intel i5");
        builder.addHardDrive("512GB SSD");
        Computer computer = builder.build();

        assertEquals("512GB SSD", computer.getHardDrive());
    }

    @Test
    void addGraphicsCardSetsGraphicsCard() {
        ComputerBuilder builder = new ComputerBuilder();

        builder.addProcessor("Intel i5");
        builder.addGraphicsCard("RTX 3060");
        Computer computer = builder.build();

        assertEquals("RTX 3060", computer.getGraphicsCard());
    }

    @Test
    void addOperatingSystemSetsOperatingSystem() {
        ComputerBuilder builder = new ComputerBuilder();

        builder.addProcessor("Intel i5");
        builder.addOperatingSystem("Windows 11");
        Computer computer = builder.build();

        assertEquals("Windows 11", computer.getOperatingSystem());
    }

    @Test
    void methodsCanBeChained() {
        ComputerBuilder builder = new ComputerBuilder();

        Computer computer = builder
                .addProcessor("Intel i9")
                .addRam(32)
                .addHardDrive("1TB SSD")
                .addGraphicsCard("RTX 4090")
                .addOperatingSystem("Linux")
                .build();

        assertAll(
                () -> assertEquals("Intel i9", computer.getProcessor()),
                () -> assertEquals(32, computer.getRamGb()),
                () -> assertEquals("1TB SSD", computer.getHardDrive()),
                () -> assertEquals("RTX 4090", computer.getGraphicsCard()),
                () -> assertEquals("Linux", computer.getOperatingSystem())
        );
    }

    @Test
    void buildThrowsExceptionWhenProcessorMissing() {
        ComputerBuilder builder = new ComputerBuilder();

        assertThrows(IllegalStateException.class, builder::build);
    }

    @Test
    void buildReturnsNewInstanceEachTime() {
        ComputerBuilder builder = new ComputerBuilder();

        Computer first = builder.addProcessor("Intel i5").build();
        Computer second = builder.addProcessor("Intel i7").build();

        assertNotSame(first, second);
    }

    @Test
    void builderResetsAfterBuild() {
        ComputerBuilder builder = new ComputerBuilder();

        builder.addProcessor("Intel i5").build();

        // Second build without setting processor again should fail
        assertThrows(IllegalStateException.class, builder::build);
    }

    @Test
    void allowsZeroRam() {
        ComputerBuilder builder = new ComputerBuilder();

        Computer computer = builder
                .addProcessor("Intel i5")
                .addRam(0)
                .build();

        assertEquals(0, computer.getRamGb());
    }

    @Test
    void allowsNullOptionalFields() {
        ComputerBuilder builder = new ComputerBuilder();

        Computer computer = builder
                .addProcessor("Intel i5")
                .addGraphicsCard(null)
                .build();

        assertNull(computer.getGraphicsCard());
    }
}