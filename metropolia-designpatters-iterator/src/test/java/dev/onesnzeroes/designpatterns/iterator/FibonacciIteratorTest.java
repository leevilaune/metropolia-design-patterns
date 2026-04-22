package dev.onesnzeroes.designpatterns.iterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciIteratorTest {

    @Test
    void testInitialSequenceValues() {
        FibonacciIterator iterator = new FibonacciIterator();

        assertEquals(1, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(5, iterator.next());
    }

    @Test
    void testSequenceProgression() {
        FibonacciIterator iterator = new FibonacciIterator();

        int[] expected = {1, 1, 2, 3, 5, 8, 13};

        for (int value : expected) {
            assertEquals(value, iterator.next());
        }
    }

    @Test
    void testCountIncrements() {
        FibonacciIterator iterator = new FibonacciIterator();

        iterator.next();
        iterator.next();
        iterator.next();

        assertEquals(3, iterator.getCount());
    }

    @Test
    void testHasNextAlwaysTrueForInfiniteSequence() {
        FibonacciIterator iterator = new FibonacciIterator();

        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
    }
    @Test
    void testFirstTenFibonacciNumbers() {
        FibonacciIterator iterator = new FibonacciIterator();

        int[] expected = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

        for (int value : expected) {
            assertTrue(iterator.hasNext());
            assertEquals(value, iterator.next());
        }
    }
}