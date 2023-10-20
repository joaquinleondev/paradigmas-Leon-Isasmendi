package Nemo2;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import static org.junit.Assert.*;

public class NemoTest {
    @Test public void test01StartsAtOrigin () {
        Nemo nemo = new Nemo();
        int[] expected = {0, 0, 0};
        assertArrayEquals(expected, nemo.controlCenter.getPosition());
    }

    @Test public void test02StartsFacingNorth () {
        Nemo nemo = new Nemo();
        int expected = 0;
        assertEquals(expected, nemo.controlCenter.getHeading());
    }

    @Test public void test03CantAscendOnTop () {
        Nemo nemo = new Nemo();
        nemo.navigationSystem.execute("u");
        int[] expected = {0, 0, 0};
        assertArrayEquals(expected, nemo.controlCenter.getPosition());
    }

    @Test public void test04CanDescend () {
        Nemo nemo = new Nemo();
        nemo.navigationSystem.execute("dd");
        int[] expected = {0, 0, -2};
        assertArrayEquals(expected, nemo.controlCenter.getPosition());
    }

    @Test public void test05CanAscend () {
        Nemo nemo = new Nemo();
        nemo.navigationSystem.execute("du");
        int[] expected = {0, 0, 0};
        assertArrayEquals(expected, nemo.controlCenter.getPosition());
    }

//    @Test public void test06CanGoLeft () {
//        Nemo nemo = new Nemo();
//        nemo.navigationSystem.execute("lf");
//        int[] expected = {0, 1, 0};
//        assertArrayEquals(expected, nemo.controlCenter.getPosition());
//    }

//    @Test public void test07CanGoRight () {
//        Nemo nemo = new Nemo();
//        nemo.executeCommand("rf");
//        Integer[] expected = {0, -1, 0};
//        assertArrayEquals(expected, nemo.getPosition());
//    }
//
//    @Test public void test08CanThrowCapsule () { esta ya esta en el 11 hay que mostrar que si se puede
//        Nemo nemo = new Nemo();
//        assertThrowsLike(() -> nemo.navigationSystem.execute("ddm"));
//    }
//
//    @Test public void test09InterpretsMessage () {
//        Nemo nemo = new Nemo();
//        nemo.executeCommand("flffrff");
//        Integer[] expected = {3, 2, 0};
//        assertArrayEquals(expected, nemo.getPosition());
//    }
//
//    @Test public void test10HeadingIn360Module () {
//        Nemo nemo = new Nemo();
//        nemo.executeCommand("rrrr");
//        Integer expected = 0;
//        assertEquals(expected, nemo.getHeading());
//    }
//
    @Test public void test11CapsuleCantBeThrownFromDepth () {
        Nemo nemo = new Nemo();
        assertThrowsLike(() -> nemo.navigationSystem.execute("ddm"));
    }

    private void assertThrowsLike( ThrowingRunnable e ) {
        assertEquals("Nemo is destroyed, capsule cant be thrown from this depth", assertThrows( RuntimeException.class, (ThrowingRunnable) e).getMessage() );
    }
}