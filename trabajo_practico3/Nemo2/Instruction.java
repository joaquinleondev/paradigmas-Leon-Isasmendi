package Nemo2;

public class Instruction {
    private String value;
    private Runnable runnable;
    public Instruction(String value) {
        this.value = value;
    }
    public String returnValue() {
        return value;
    }
    public void executeInstruction(Nemo nemo) throws RuntimeException {
        throw new RuntimeException("Command not found");
    };
}

class ascend extends Instruction {
    private static final String value = "u";

    public ascend() {
        super(value);
    }
    public String returnValue() {
        return value;
    }
    public void executeInstruction(Nemo nemo) {
        nemo.point.z++;
    }

}

class descend extends Instruction {
    private static final String value = "d";

    public descend() {
        super(value);
    }
    public String returnValue() {
        return value;
    }
}

class left extends Instruction {
    private static final String value = "l";

    public left() {
        super(value);
    }
    public String returnValue() {
        return value;
    }
}

class right extends Instruction {
    private static final String value = "r";

    public right() {
        super(value);
    }
    public String returnValue() {
        return value;
    }
}

class forward extends Instruction {
    private static final String value = "f";

    public forward() {
        super(value);
    }
    public String returnValue() {
        return value;
    }
}

class throwCapsule extends Instruction {
    private static final String value = "m";

    public throwCapsule() {
        super(value);
    }
    public String returnValue() {
        return value;
    }
}
