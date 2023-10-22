package nemo;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import static org.junit.Assert.*;

public class NemoTest {
    @Test
    public void testNemoStartsAtOrigin() {
        Nemo nemo = new Nemo();
        int[] expected = {0, 0, 0};
        assertArrayEquals("Nemo starts at the origin", expected, nemo.position());
    }

    @Test
    public void testNemoStartsFacingEast() {
        Nemo nemo = new Nemo();
        int[] expected = {1, 0};
        assertArrayEquals("Nemo starts facing east", expected, nemo.heading());
    }

    @Test
    public void testNemoCannotAscendOnTop() {
        Nemo nemo = new Nemo();
        nemo.execute("u");
        int[] expected = {0, 0, 0};
        assertArrayEquals("Nemo cannot ascend on top", expected, nemo.position());
    }

    @Test
    public void testNemoCanDescend() {
        Nemo nemo = new Nemo();
        nemo.execute("ddduuuuuu");
        int[] expected = {0, 0, 0};
        assertArrayEquals("Nemo can descend", expected, nemo.position());
    }

    @Test
    public void testNemoCanAscend() {
        Nemo nemo = new Nemo();
        nemo.execute("du");
        int[] expected = {0, 0, 0};
        assertArrayEquals("Nemo can ascend", expected, nemo.position());
    }

    @Test
    public void testNemoCanGoLeft() {
        Nemo nemo = new Nemo();
        nemo.execute("l");
    }

    @Test
    public void testNemoCanGoRight() {
        Nemo nemo = new Nemo();
        nemo.execute("rf");
        int[] expected = {0, -1, 0};
        assertArrayEquals("Nemo can go right", expected, nemo.position());
    }

    @Test
    public void testNemoCanThrowCapsule() {
        Nemo nemo = new Nemo();
        nemo.execute("dm");
    }

    @Test
    public void testNemoInterpretsMessage() {
        Nemo nemo = new Nemo();
        nemo.execute("flffrff");
        int[] expected = {3, 2, 0};
        assertArrayEquals("Nemo can interpret a message", expected, nemo.position());
    }

    @Test
    public void testNemoHeadingIn360Module() {
        Nemo nemo = new Nemo();
        nemo.execute("l");
        int[] expected = {0, 1};
        assertArrayEquals("Nemo heading is within a 360-degree module", expected, nemo.heading());
    }

    @Test
    public void testNemoCapsuleCantBeThrownFromDepth() {
        Nemo nemo = new Nemo();
        assertThrowsLike(() -> nemo.execute("dddm"));
    }

    private void assertThrowsLike(ThrowingRunnable e) {
        assertEquals("Nemo is destroyed, capsule cant be thrown from this depth", assertThrows(RuntimeException.class, e).getMessage());
    }
}