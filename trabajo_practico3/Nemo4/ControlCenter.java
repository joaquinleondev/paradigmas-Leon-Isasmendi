package Nemo;

import java.util.ArrayList;
import java.util.Arrays;

public class ControlCenter {
    private final ArrayList<Instruction> instructions = new ArrayList<>();
    private final ArrayList<State> depthRegistry = new ArrayList<>();
    private final Orientation curerentOrientation = new Orientation();

    public ControlCenter() {
        depthRegistry.add(new OnSurface());
        instructions.add(new ascend());
        instructions.add(new descend());
        instructions.add(new left());
        instructions.add(new right());
        instructions.add(new forward());
        instructions.add(new throwCapsule());
    }

    public int[] getCoordinates(Point point) {
        return point.value();
    }

    public int[] getHeading(Orientation orientation) {
        return orientation.value();
    }

    public void run(String command, Nemo nemo) {
        Arrays.stream(command.split("")).forEach((String instruction) -> {
            Instruction instructionToExecute = instructions.stream().filter((Instruction searchedInstruction) -> searchedInstruction.returnValue().equals(instruction)).toList().get(0);
            instructionToExecute.executeInstruction(nemo);
        });
    }

    public State getCurrentState(Nemo nemo) {
        return depthRegistry.get(depthRegistry.size() - 1);
    }

    public void addState(State state) {
        depthRegistry.add(state);
    }

    public void removeState() {
        depthRegistry.remove(depthRegistry.size() - 1);
    }
}
