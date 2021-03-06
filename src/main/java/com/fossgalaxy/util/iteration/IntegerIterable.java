package com.fossgalaxy.util.iteration;

import com.fossgalaxy.util.rules.NumberRule;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Piers on 09/08/2016.
 */
public class IntegerIterable extends NumberIterable<Integer> {

    public IntegerIterable(NumberRule<Integer> rule, Integer n) {
        super(rule, n);
        if (step == null) {
            iterations = n;
        } else if (n == null) {
            iterations = ((max - min) / step);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return hasNextNumber();
            }

            @Override
            public Integer next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                if (step == null) {
                    count++;
                    return random.nextInt(max - min + 1) + min;
                }
                return min + (count++ * step);
            }

            @Override
            public void remove() {

            }
        };
    }
}
