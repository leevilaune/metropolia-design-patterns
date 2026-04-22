package dev.onesnzeroes.designpatterns.iterator;

import java.util.Iterator;

/**
 * FibonacciIterator keeps track of its own state allowing multiple separate
 * iterators with different states
 */
public class FibonacciIterator implements Iterator<Integer> {

    private int fib1;
    private int fib2;
    private int count;

    public FibonacciIterator(){
        this.fib1 = 1;
        this.fib2 = 1;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        if(this.count <= 1){
            this.count++;
            return 1;
        }
        int nextFib = this.fib1+this.fib2;
        this.fib1 = this.fib2;
        this.fib2 = nextFib;
        this.count++;
        return nextFib;
    }
}
