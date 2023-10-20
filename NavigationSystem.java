package Nemo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NavigationSystem {
    ArrayList<Instruction> instructions;
    Nemo nemo;
    public NavigationSystem(Nemo nemo) {
        this.nemo = nemo;
        this.instructions = new ArrayList<Instruction>();
        instructions.add(new ascend());
        instructions.add(new descend());
        instructions.add(new left());
        instructions.add(new right());
        instructions.add(new forward());
        instructions.add(new throwCapsule());
    }
    public void execute(String command) {
        Arrays.stream(command.split("")).forEach(instruction -> {
            Instruction retorno = instructions.stream().filter(searchedInstruction -> searchedInstruction.returnValue().equals(instruction)).collect(Collectors.toCollection(ArrayList::new)).get(0);
            retorno.executeInstruction(nemo);
        });
    }

}
