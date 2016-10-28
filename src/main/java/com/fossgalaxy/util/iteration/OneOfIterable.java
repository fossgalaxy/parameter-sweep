package com.fossgalaxy.util.iteration;

import com.fossgalaxy.util.rules.OneOfRule;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by piers on 25/10/16.
 */
public class OneOfIterable<T> implements Iterable<T> {

    private final OneOfRule<T> rule;
    private final int iterations;
    private int count = 0;

    public OneOfIterable(OneOfRule<T> rule, Integer n) {
        this.rule = rule;
        iterations = (n == null) ? rule.numValues() : n;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return count < iterations;
            }

            @Override
            public T next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                count = count % (rule.numValues() + 1);
                T item = rule.getValues()[count];
                count++;
                return item;
            }

            @Override
            public void remove() {

            }
        };
    }
}
