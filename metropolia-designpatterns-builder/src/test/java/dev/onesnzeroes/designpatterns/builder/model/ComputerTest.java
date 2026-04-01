package dev.onesnzeroes.designpatterns.builder.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void setProcessorSetsValue() {
        Computer computer = new Computer();

        computer.setProcessor("Intel i7");

        assertEquals("Intel i7", computer.getProcessor());
    }

    @Test
    void setRamGbSetsValue() {
        Computer computer = new Computer();

        computer.setRamGb(16);

        assertEquals(16, computer.getRamGb());
    }

    @Test
    void setHardDriveSetsValue() {
        Computer computer = new Computer();

        computer.setHardDrive("512GB SSD");

        assertEquals("512GB SSD", computer.getHardDrive());
    }

    @Test
    void setGraphicsCardSetsValue() {
        Computer computer = new Computer();

        computer.setGraphicsCard("RTX 3070");

        assertEquals("RTX 3070", computer.getGraphicsCard());
    }

    @Test
    void setOperatingSystemSetsValue() {
        Computer computer = new Computer();

        computer.setOperatingSystem("Windows 11");

        assertEquals("Windows 11", computer.getOperatingSystem());
    }

    // Edge cases

    @Test
    void setRamGbAllowsZero() {
        Computer computer = new Computer();

        computer.setRamGb(0);

        assertEquals(0, computer.getRamGb());
    }

    @Test
    void setProcessorAllowsNull() {
        Computer computer = new Computer();

        computer.setProcessor(null);

        assertNull(computer.getProcessor());
    }

    @Test
    void setHardDriveAllowsEmptyString() {
        Computer computer = new Computer();

        computer.setHardDrive("");

        assertEquals("", computer.getHardDrive());
    }

    @Test
    void setRamGbAcceptsNegativeValueIfNoValidation() {
        Computer computer = new Computer();

        computer.setRamGb(-8);

        assertEquals(-8, computer.getRamGb());
    }

    @Test
    void toStringContainsAllFields() {
        Computer computer = new Computer();
        computer.setProcessor("Intel i9");
        computer.setRamGb(32);
        computer.setHardDrive("1TB SSD");
        computer.setGraphicsCard("RTX 4090");
        computer.setOperatingSystem("Linux");

        String result = computer.toString();

        assertAll(
                () -> assertTrue(result.contains("Intel i9")),
                () -> assertTrue(result.contains("32")),
                () -> assertTrue(result.contains("1TB SSD")),
                () -> assertTrue(result.contains("RTX 4090")),
                () -> assertTrue(result.contains("Linux"))
        );
    }
}