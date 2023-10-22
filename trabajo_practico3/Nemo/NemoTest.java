package nemo;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.Before;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class NemoTest {
    public static final String INVALID_COMMAND_ERROR = "Invalid command";
    public static final String CAPSULE_CANT_BE_THROWN_ERROR = "Nemo is destroyed, capsule cant be thrown from this depth";
    private Nemo nemo;

    @Before
    public void setUp() {
        nemo = new Nemo();
    }

    @Test
    public void test01NemoStartsAtOrigin() {
        int[] expected = {0, 0, 0};
        assertArrayEquals( expected, nemo.position());
    }

    @Test
    public void test02NemoStartsFacingEast() {
        int[] expected = {1, 0};
        assertArrayEquals( expected, nemo.heading());
    }

    @Test
    public void test03NemoCannotAscendOnTop() {
        nemo.execute("u");
        int[] expected = {0, 0, 0};
        assertArrayEquals( expected, nemo.position());
    }
    @Test
    public void test04NemoCanAscend() {
        nemo.execute("du");
        int[] expected = {0, 0, 0};
        assertArrayEquals( expected, nemo.position());
    }
    @Test
    public void test05NemoCanDescend() {
        nemo.execute("ddd");
        int[] expected = {0, 0, -3};
        assertArrayEquals( expected, nemo.position());
    }
    @Test
    public void test06NemoCanTurnLeft() {
        nemo.execute("l");
        int[] expected = {0, 1};
        assertArrayEquals( expected, nemo.heading());
    }
    @Test
    public void test07NemoCanTurnRight() {
        nemo.execute("r");
        int[] expected = {0, -1};
        assertArrayEquals( expected, nemo.heading());
    }
    @Test
    public void test08NemoCanGoForward() {
        nemo.execute("f");
        int[] expected = {1, 0, 0};
        assertArrayEquals( expected, nemo.position());
    }

    @Test
    public void test09NemoCanGoLeft() {
        nemo.execute("lf");
        int[] expected = {0, 1, 0};
        assertArrayEquals( expected, nemo.position());
    }

    @Test
    public void test10NemoCanGoRight() {
        nemo.execute("rf");
        int[] expected = {0, -1, 0};
        assertArrayEquals( expected, nemo.position());
    }
    @Test
    public void test11NemoCanDoA360Rotation() {
        nemo.execute("llll");
        int[] expected = {1, 0};
        assertArrayEquals( expected, nemo.heading());
    }

    @Test
    public void test12NemoCanThrowCapsule() {
        nemo.execute("dm");
        // There is no way to test this, but it should not throw an exception
    }
    @Test
    public void test13NemoCapsuleCantBeThrownFromDepth() {
        assertThrowsLike(CAPSULE_CANT_BE_THROWN_ERROR,() -> nemo.execute("dddm"));
    }

    @Test
    public void test14NemoInterpretsMessage() {
        nemo.execute("flffrff");
        int[] expected = {3, 2, 0};
        assertArrayEquals( expected, nemo.position());
    }


    @Test
    public void test15NemoDoesntInterpretInvalidMessage() {
        assertThrowsLike(INVALID_COMMAND_ERROR,() -> nemo.execute("z"));
    }


    private void assertThrowsLike(String message,ThrowingRunnable e) {
        assertEquals(message, assertThrows(RuntimeException.class, e).getMessage());
    }
}