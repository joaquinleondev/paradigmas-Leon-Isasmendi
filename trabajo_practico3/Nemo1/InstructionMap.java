package Nemo1;

import java.util.HashMap;
import java.util.Map;

public class InstructionMap {
    private final Map<String, Runnable> instructionMap;

    public InstructionMap( Nemo nemo ) {
        this.instructionMap = new HashMap<>();
        this.instructionMap.put("d", nemo::descend);
        this.instructionMap.put("u", nemo::ascend);
        this.instructionMap.put("l", nemo::rotateLeft);
        this.instructionMap.put("r", nemo::rotateRight);
        this.instructionMap.put("f", nemo::moveForward);
        this.instructionMap.put("m", nemo::throwCapsule);
    }

    public Runnable getExecutableInstruction( String instruction ) {
        return this.instructionMap.get( instruction );
    }
}

