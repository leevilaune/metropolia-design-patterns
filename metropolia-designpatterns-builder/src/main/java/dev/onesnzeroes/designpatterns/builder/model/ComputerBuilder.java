package dev.onesnzeroes.designpatterns.builder.model;

public class ComputerBuilder {

    private Computer computer;

    public ComputerBuilder(){
        this.computer = new Computer();
    }

    public ComputerBuilder addProcessor(String processor) {
        this.computer.setProcessor(processor);
        return this;
    }

    public ComputerBuilder addRam(int gb) {
        this.computer.setRamGb(gb);
        return this;
    }

    public ComputerBuilder addHardDrive(String hardDrive){
        this.computer.setHardDrive(hardDrive);
        return this;
    }

    public ComputerBuilder addGraphicsCard(String graphicsCard){
        this.computer.setGraphicsCard(graphicsCard);
        return this;
    }

    public ComputerBuilder addOperatingSystem(String os){
        this.computer.setOperatingSystem(os);
        return this;
    }
    public Computer build() {
        if (this.computer.getProcessor() == null) {
            throw new IllegalStateException("Processor required");
        }
        Computer result = this.computer;
        this.computer = new Computer();
        return result;
    }
}
