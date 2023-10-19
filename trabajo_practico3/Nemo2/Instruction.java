package Nemo2;

public abstract class Instruction {
    private String content;
    public Instruction(String command) {
        this.content = command;
    }
    public abstract String getInstruction();
}

class Ascend extends Instruction{
    private String content = "u";

    public Ascend(String command) {
        super(command);
    }

    @Override public String getInstruction() {
        return content;
    }
}

class Descend extends Instruction{
    private String content = "d";

    public Descend(String command) {
        super(command);
    }

    @Override public String getInstruction() {
        return content;
    }
}

class Left extends Instruction{
    private String content = "l";

    public Left(String command) {
        super(command);
    }

    @Override public String getInstruction() {
        return content;
    }
}

class Right extends Instruction{
    private String content = "r";

    public Right(String command) {
        super(command);
    }

    @Override public String getInstruction() {
        return content;
    }
}

class Forward extends Instruction{
    private String content = "f";

    public Forward(String command) {
        super(command);
    }

    @Override public String getInstruction() {
        return content;
    }
}

class ThrowCapsule extends Instruction{
    private String content = "m";

    public ThrowCapsule(String command) {
        super(command);
    }

    @Override public String getInstruction() {
        return content;
    }
}