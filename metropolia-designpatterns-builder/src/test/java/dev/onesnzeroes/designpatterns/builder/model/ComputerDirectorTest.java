package dev.onesnzeroes.designpatterns.builder.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComputerDirectorTest {

    @Test
    void constructGamingComputerSetsHighEndProcessor() {
        ComputerDirector director = new ComputerDirector(new ComputerBuilder());

        Computer computer = director.constructGamingComputer();

        assertEquals("Intel i9", computer.getProcessor());
    }

    @Test
    void constructGamingComputerSetsHighRam() {
        ComputerDirector director = new ComputerDirector(new ComputerBuilder());

        Computer computer = director.constructGamingComputer();

        assertTrue(computer.getRamGb() >= 32);
    }

    @Test
    void constructGamingComputerSetsLinuxOperatingSystem() {
        ComputerDirector director = new ComputerDirector(new ComputerBuilder());

        Computer computer = director.constructGamingComputer();

        assertEquals("Ubuntu", computer.getOperatingSystem());
    }

    @Test
    void constructOfficeComputerSetsMidRangeProcessor() {
        ComputerDirector director = new ComputerDirector(new ComputerBuilder());

        Computer computer = director.constructOfficeComputer();

        assertEquals("Intel i5", computer.getProcessor());
    }

    @Test
    void constructOfficeComputerSetsLowerRamThanGaming() {
        ComputerDirector director = new ComputerDirector(new ComputerBuilder());

        Computer office = director.constructOfficeComputer();
        Computer gaming = director.constructGamingComputer();

        assertTrue(office.getRamGb() < gaming.getRamGb());
    }

    @Test
    void constructOfficeComputerSetsMacOs() {
        ComputerDirector director = new ComputerDirector(new ComputerBuilder());

        Computer computer = director.constructOfficeComputer();

        assertEquals("macOS", computer.getOperatingSystem());
    }

    @Test
    void eachConstructionReturnsNewInstance() {
        ComputerDirector director = new ComputerDirector(new ComputerBuilder());

        Computer first = director.constructGamingComputer();
        Computer second = director.constructGamingComputer();

        assertNotSame(first, second);
    }

    @Test
    void builderResetEnsuresIndependentComputers() {
        ComputerBuilder builder = new ComputerBuilder();
        ComputerDirector director = new ComputerDirector(builder);

        Computer first = director.constructGamingComputer();
        Computer second = director.constructOfficeComputer();

        assertNotEquals(first.getProcessor(), second.getProcessor());
    }
}