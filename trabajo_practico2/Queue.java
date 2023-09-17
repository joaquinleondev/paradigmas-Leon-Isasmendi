package queue;

import java.util.ArrayList;

public class Queue {

    private static ArrayList<Object> queue;

    public Queue() {
        queue = new ArrayList<>();
        queue.add(0, new EmptyContainer());
    }

    public boolean isEmpty() {
        return queue.size() == 1;
    }

    public Queue add(Object cargo) {
        Object newContainer = new Container((String) cargo);
        queue.add(1, newContainer);
        return this;
    }

    public Object take() {
        int lastObjectPosition = queue.size() - 1;
        Container lastObject = (Container) queue.get(lastObjectPosition);
        queue.remove(lastObjectPosition);
        return lastObject.getContent();
    }

    public int size() {
        return queue.size() - 1;
    }

    public Object head() {
        Container aboutToBeRemoved = (Container) queue.get(queue.size() - 1);
        return aboutToBeRemoved.getContent();
    }

}

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
