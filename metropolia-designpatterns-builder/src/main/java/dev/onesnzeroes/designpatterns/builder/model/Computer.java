package dev.onesnzeroes.designpatterns.builder.model;

public class Computer {

    private String processor;
    private int ramGb;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRamGb() {
        return ramGb;
    }

    public void setRamGb(int ramGb) {
        this.ramGb = ramGb;
    }

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", ramGb=" + ramGb +
                ", hardDrive='" + hardDrive + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                '}';
    }
}
