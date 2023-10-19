package Nemo2;

import java.util.Arrays;

public class ControlCenter {
    public void executeCommand(String command) {
        Arrays.stream(command.split("")).forEach((String instruction) -> {
            this.executeInstruction((new Instruction(instruction) {
                @Override
                public String getInstruction() {
                    return null;
                }
            }).);
        });
    }

    public void executeInstruction(Instruction instruction) {

    }
}
