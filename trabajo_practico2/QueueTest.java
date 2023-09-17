package queue;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.Test;


public class QueueTest {

    @Test
    public void test01QueueShouldBeEmptyWhenCreated() {
        assertTrue(new Queue().isEmpty());

    }

    @Test
    public void test02AddElementsToTheQueue() {
        assertFalse(new Queue().add(SOMETHING).isEmpty());
    }

    @Test
    public void test03AddedElementsIsAtHead() {
        assertEquals(SOMETHING, new Queue().add(SOMETHING).head());
    }

    @Test
    public void test04TakeRemovesElementsFromTheQueue() {
        Queue queue = new Queue().add(SOMETHING);
        queue.take();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void test05TakeReturnsLastAddedObject() {
        Queue queue = new Queue();
        queue.add(SOMETHING);

        assertEquals(SOMETHING, queue.take());
    }

    @Test
    public void test06QueueBehavesFIFO() {
        Queue queue = new Queue();

        queue.add(firstAddedObject());
        queue.add(secondAddedObject());

        assertEquals(queue.take(), firstAddedObject());
        assertEquals(queue.take(), secondAddedObject());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test07HeadReturnsFirstAddedObject() {
        Queue queue = new Queue();

        queue.add(firstAddedObject());
        queue.add(secondAddedObject());

        assertEquals(queue.head(), firstAddedObject());
    }

    @Test
    public void test08HeadDoesNotRemoveObjectFromQueue() {
        Queue queue = new Queue();
        queue.add(SOMETHING);
        assertEquals(1, queue.size());
        queue.head();
        assertEquals(1, queue.size());
    }

    @Test
    public void test09SizeRepresentsObjectInTheQueue() {
        assertEquals(2, new Queue().add(firstAddedObject()).add(secondAddedObject()).size());
    }

    @Test
    public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
        Queue queue = new Queue();
        assertThrowsLike(queue::take, TEST_ERROR);
    }

    @Test
    public void test11CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
        Queue queue = new Queue();
        queue.add(SOMETHING);
        queue.take();
        assertThrowsLike(queue::take, TEST_ERROR);
    }

    @Test
    public void test12CanNotHeadWhenThereAreNoObjectsInTheQueue() {
        Queue queue = new Queue();
        assertThrowsLike(queue::head, TEST_ERROR);
    }

    public static final String SOMETHING = "Something";
    public static final String TEST_ERROR = "Queue is empty";

    private String firstAddedObject() {
        return "First";
    }

    private String secondAddedObject() {
        return "Second";
    }

    private void assertThrowsLike(ThrowingRunnable executable, String message) {
        assertEquals(message, assertThrows(Error.class, executable).getMessage());
    }
}