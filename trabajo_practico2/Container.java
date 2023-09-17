package queue;

class Container {
    private final Object cargo;

    public Container(String cargo) {
        super();
        this.cargo = cargo;
    }

    public Object getContent() {
        return cargo;
    }

}


class EmptyContainer extends Container {
    private static final String cargo = "Empty";

    public EmptyContainer() {
        super(cargo);
    }

    @Override
    public Object getContent() {
        throw new Error("Queue is empty");
    }

}
