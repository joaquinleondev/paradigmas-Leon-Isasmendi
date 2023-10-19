package Nemo2;

import java.util.Arrays;

public class NavigationSystem {
    public void excecute(String command) {
        Arrays.stream(command.split("")).forEach(instruction -> {
            Instruction instructionObject = new Instruction(instruction);
            instructionObject.getRunnable().run();
        });
    }

}
