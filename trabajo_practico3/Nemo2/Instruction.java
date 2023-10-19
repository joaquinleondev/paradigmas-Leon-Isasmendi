package Nemo2;

public class Instruction {
    private String value;
    private Runnable runnable;
    public Instruction(String value) {
        this.value = value;
    }

    public Runnable getRunnable() {
        return runnable;
    }
}

class ascend extends Instruction {
    private String value = "u";

    public ascend(String value) {
        super(value);
    }

    @Override
    public Runnable getRunnable() {
        return () -> {
            System.out.println("ascend");
        };
    }

}

class descend extends Instruction {
    public descend(String value) {
        super(value);
    }
}

class left extends Instruction {
    public left(String value) {
        super(value);
    }
}

class right extends Instruction {
    public right(String value) {
        super(value);
    }
}

class forward extends Instruction {
    public forward(String value) {
        super(value);
    }
}

class throwCapsule extends Instruction {
    public throwCapsule(String value) {
        super(value);
    }
}
