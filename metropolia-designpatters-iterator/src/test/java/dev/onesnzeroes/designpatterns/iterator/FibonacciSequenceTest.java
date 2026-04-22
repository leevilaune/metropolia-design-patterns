package dev.onesnzeroes.designpatterns.iterator;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciSequenceTest {

    @Test
    void testIteratorCreation() {
        FibonacciSequence sequence = new FibonacciSequence();

        Iterator<Integer> iterator = sequence.iterator();

        assertNotNull(iterator);
        assertTrue(iterator instanceof FibonacciIterator);
    }

    @Test
    void testIteratorsAreIndependent() {
        FibonacciSequence sequence = new FibonacciSequence();

        Iterator<Integer> it1 = sequence.iterator();
        Iterator<Integer> it2 = sequence.iterator();

        assertEquals(1, it1.next());
        assertEquals(1, it1.next());

        // Second iterator should start fresh
        assertEquals(1, it2.next());
    }

}