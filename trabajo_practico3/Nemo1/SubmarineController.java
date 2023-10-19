package Nemo1;

public class SubmarineController {
    private final Nemo nemo;

    public SubmarineController( Nemo nemo ) {
        this.nemo = nemo;
    }

    public void execute (String instruction) {
        InstructionMap instructionMap = new InstructionMap( this.nemo );
        Runnable executableInstruction = instructionMap.getExecutableInstruction( instruction );
        executableInstruction.run();
    }
}

