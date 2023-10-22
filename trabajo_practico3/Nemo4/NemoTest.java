package Nemo;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.Arrays;

import static org.junit.Assert.*;

public class NemoTest {
    @Test public void test01StartsAtOrigin () {
        Nemo nemo = new Nemo();
        int[] expected = {0, 0, 0};
        assertArrayEquals(expected, nemo.position());
    }

    @Test public void test02StartsFacingEast () {
        Nemo nemo = new Nemo();
        int[] expected = {1, 0};
        assertArrayEquals(expected, nemo.heading());
    }

    @Test public void test03CantAscendOnTop () {
        Nemo nemo = new Nemo();
        nemo.execute("u");
        int[] expected = {0, 0, 0};
        assertArrayEquals(expected, nemo.position());
    }

    @Test public void test04CanDescend () {
        Nemo nemo = new Nemo();
        nemo.execute("ddduuuuuu");
        int[] expected = {0, 0, 0};
        assertArrayEquals(expected, nemo.position());
    }

    @Test public void test05CanAscend () {
        Nemo nemo = new Nemo();
        nemo.execute("du");
        int[] expected = {0, 0, 0};
        assertArrayEquals(expected, nemo.position());
    }

    @Test public void test06CanGoLeft () {
        Nemo nemo = new Nemo();
        nemo.execute("l");
        System.out.println(Arrays.toString(nemo.heading()));
    }

    @Test public void test07CanGoRight () {
        Nemo nemo = new Nemo();
        nemo.execute("rf");
        int[] expected = {0, -1, 0};
        assertArrayEquals(expected, nemo.position());
    }

    @Test public void test08CanThrowCapsule () {
        Nemo nemo = new Nemo();
        nemo.execute("dm");
    }

    @Test public void test09InterpretsMessage () {
        Nemo nemo = new Nemo();
        nemo.execute("flffrff");
        int[] expected = {3, 2, 0};
        assertArrayEquals(expected, nemo.position());
    }

    @Test public void test10HeadingIn360Module () {
        Nemo nemo = new Nemo();
        nemo.execute("l");
        int[] expected = {0, 1};
        assertArrayEquals(expected, nemo.heading());
    }

    @Test public void test11CapsuleCantBeThrownFromDepth () {
        Nemo nemo = new Nemo();
        assertThrowsLike(() -> nemo.execute("ddm"));
    }

    private void assertThrowsLike( ThrowingRunnable e ) {
        assertEquals("Nemo is destroyed, capsule cant be thrown from this depth", assertThrows( RuntimeException.class, (ThrowingRunnable) e).getMessage() );
    }
}