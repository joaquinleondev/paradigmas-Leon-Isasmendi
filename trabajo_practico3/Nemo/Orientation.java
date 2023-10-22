package nemo;

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
    final int[] value;

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
    final int[] value;

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
    final int[] value;

    public East() {
        this.value = new int[]{1, 0};
    }

    @Override
    public int[] value() {
        return value;
    }
}

class South extends Orientation {
    final int[] value;

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