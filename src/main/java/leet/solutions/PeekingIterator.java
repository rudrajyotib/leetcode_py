package leet.solutions;

/*
https://leetcode.com/problems/peeking-iterator/
Leetcode#284
 */


import java.util.Iterator;

public class PeekingIterator<T> implements Iterator<T> {

    private final Iterator<T> iterator;
    private T nextElement = null;

    public PeekingIterator(Iterator<T> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (this.iterator.hasNext())
        {
            this.nextElement = this.iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public T peek() {
        return this.nextElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public T next() {
        T temp = this.nextElement;
        if (this.iterator.hasNext())
        {
            this.nextElement = this.iterator.next();
        }else
        {
            this.nextElement = null;
        }
        return temp;
    }

    @Override
    public boolean hasNext() {
        return this.nextElement != null;
    }
}
