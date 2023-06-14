package de.uulm.sp.oop.exercises.e05.tests;

import de.uulm.sp.oop.exercises.e05.Pair;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PairTests {

    Pair<Integer, String> pair1;
    Pair<Integer, String> pair2;


    @BeforeEach
    void setUp() {
        pair1 = new Pair<Integer, String>(420, "B");
        pair2 = new Pair<Integer, String>(69, "A");
    }

    @Test
    void getFirst() {
        Assertions.assertEquals(pair1.getFirst(), 420);
        Assertions.assertEquals(pair2.getFirst(), 69);
    }

    @Test
    void getSecond() {
        Assertions.assertEquals(pair1.getSecond(), "B");
        Assertions.assertEquals(pair2.getSecond(), "A");
    }

    @Test
    void testEquals() {
        var shouldBeEqualToFirst = new Pair<Integer, String>(420, "B");

        Assertions.assertEquals(pair1, shouldBeEqualToFirst);
        Assertions.assertNotEquals(pair1, pair2);
    }

    @Test
    void compareTo() {
        Assertions.assertTrue(pair1.compareTo(pair2) < 0);
    }

    @Test
    void compareToFirstNull() {
        var pairFirstEqual = new Pair<Integer, String>(420, "C");
        Assertions.assertTrue(pair1.compareTo(pairFirstEqual) > 0);
    }
}
