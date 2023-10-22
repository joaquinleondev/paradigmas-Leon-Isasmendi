package Nemo;

public class Orientation {
    private final int[] value;

    public Orientation() {
        this.value = new int[]{1, 0};
    }

    public int[] value() {
        return value;
    }

    public Orientation left() {
        return new North();
    }

    public Orientation right() {
        return new South();
    }
}

class North extends Orientation {
    int[] value = new int[]{0, 1};

    public North() {
        this.value = new int[]{0, 1};
    }

    @Override
    public Orientation left() {
        return new West();
    }

    @Override
    public Orientation right() {
        return new East();
    }

    @Override
    public int[] value() {
        return value;
    }
}

class West extends Orientation {
    int[] value;

    public West() {
        this.value = new int[]{-1, 0};
    }

    @Override
    public Orientation left() {
        return new South();
    }

    @Override
    public Orientation right() {
        return new North();
    }

    @Override
    public int[] value() {
        return value;
    }
}

class East extends Orientation {
    int[] value;

    public East() {
        this.value = new int[]{1, 0};
    }


    @Override
    public Orientation left() {
        return new North();
    }

    @Override
    public Orientation right() {
        return new South();
    }

    @Override
    public int[] value() {
        return value;
    }
}

class South extends Orientation {
    int[] value;

    public South() {
        this.value = new int[]{0, -1};
    }

    @Override
    public Orientation left() {
        return new East();
    }

    @Override
    public Orientation right() {
        return new West();
    }

    @Override
    public int[] value() {
        return value;
    }
}