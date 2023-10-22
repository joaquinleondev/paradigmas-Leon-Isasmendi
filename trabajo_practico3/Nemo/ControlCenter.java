package nemo;

import java.util.ArrayList;
import java.util.Arrays;

public class ControlCenter {
    private final ArrayList<Instruction> instructions = new ArrayList<>();
    private final ArrayList<State> depthRegistry = new ArrayList<>();
    public Point point ;
    public Orientation orientation;
    private Instruction instructionToExecute;

    public ControlCenter(Point point,Orientation orientation) {
        this.point = point;
        this.orientation = orientation;
        depthRegistry.add(new OnSurface());
        instructions.add(new Ascend());
        instructions.add(new Descend());
        instructions.add(new Left());
        instructions.add(new Right());
        instructions.add(new Forward());
        instructions.add(new ThrowCapsule());
    }

    public int[] getCoordinates(Point point) {
        return point.value();
    }


    public void run(String command, Nemo nemo) {
        Arrays.stream(command.split("")).forEach((String instruction) -> {
            try{
            instructionToExecute = instructions.stream().filter((Instruction searchedInstruction) -> searchedInstruction.getCommand().equals(instruction)).toList().get(0);}
            catch (Exception e){
                throw new RuntimeException("Invalid command");
            }
            instructionToExecute.execute(this);}

        );
    }

    public State getCurrentState() {
        return depthRegistry.get(depthRegistry.size() - 1);
    }

    public void addState(State state) {
        depthRegistry.add(state);
    }

    public void removeState() {
        depthRegistry.remove(depthRegistry.size() - 1);
    }
}
