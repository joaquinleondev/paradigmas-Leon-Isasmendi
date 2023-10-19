package Nemo2;

public class Nemo {
    CoordinatesSystem coordinatesSystem;
    ControlCenter controlCenter;

    public Nemo() {
        this.coordinatesSystem = new CoordinatesSystem();
        this.controlCenter = new ControlCenter();
    }

    public void execute(String command) {
        this.controlCenter.executeCommand(command);
    }
}
