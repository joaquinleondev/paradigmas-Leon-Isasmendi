package Nemo;

public class Orientation {
    private final int[] value = new int[]{0, 1};

    public int[] value() {
        return this.value;
    }

    public Orientation left() {
        return new Orientation();
    }

    public Orientation right() {
        return new Orientation();
    }
}

class North extends Orientation {
    int[] value = new int[]{0, 1};

    @Override
    public Orientation left() {
        return new West();
    }

    @Override
    public Orientation right() {
        return new East();
    }
}

class West extends Orientation {
    int[] value = new int[]{-1, 0};

    @Override
    public Orientation left() {
        return new South();
    }

    @Override
    public Orientation right() {
        return new North();
    }
}

class East extends Orientation {
    int[] value = new int[]{1, 0};

    @Override
    public Orientation left() {
        return new North();
    }

    @Override
    public Orientation right() {
        return new South();
    }
}

class South extends Orientation {
    int[] value = new int[]{0, -1};

    @Override
    public Orientation left() {
        return new East();
    }

    @Override
    public Orientation right() {
        return new West();
    }
}