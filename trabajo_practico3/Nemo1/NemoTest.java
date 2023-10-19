package Nemo1;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NemoTest {
    @Test
    public void test01NemoStartsAtOrigin() {
        Nemo nemo = new Nemo();
        int[] expected = new int[]{0, 0};
        assertArrayEquals(expected, nemo.cartesianSystem.position());
    }

    @Test
    public void test02NemoCanDescend() {
        Nemo nemo = new Nemo();
        nemo.excecuteCommand("dd");
        assertEquals(-2, nemo.cartesianSystem.depth());
    }

    @Test
    public void test03NemoCanMove() {
        Nemo nemo = new Nemo();
        nemo.excecuteCommand("ddlfflfffa");
        int[] expected = {-3, 2};
        assertArrayEquals(expected, nemo.cartesianSystem.position());
    }
}