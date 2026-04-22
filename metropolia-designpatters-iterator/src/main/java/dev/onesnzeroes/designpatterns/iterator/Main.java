package dev.onesnzeroes.designpatterns.iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Sequence sequence = new FibonacciSequence();
        Iterator<Integer> iterator = sequence.iterator();
        for(int i = 0; i<10; i++){
            System.out.println(iterator.next());
        }
    }
}