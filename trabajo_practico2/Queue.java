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
        Object lastObject = lastObject();
        removeLast();
        return lastObject;
    }

    private void removeLast() {
        queue.remove(queue.size() - 1);
    }

    private Object lastObject() {
        Container aboutToBeRemoved = (Container) queue.get(queue.size() - 1);
        return aboutToBeRemoved.getContent();
    }

    public int size() {
        return queue.size() - 1;
    }

    public Object head() {
        return lastObject();
    }

}
