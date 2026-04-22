package dev.onesnzeroes.designpatterns.iterator;

import java.util.Iterator;

public class FibonacciSequence implements Sequence{

    public  FibonacciSequence(){}
    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }
}
