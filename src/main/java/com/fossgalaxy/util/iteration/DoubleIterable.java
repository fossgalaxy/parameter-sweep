package com.fossgalaxy.util.iteration;

import com.fossgalaxy.util.rules.NumberRule;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Piers on 09/08/2016.
 */
public class DoubleIterable extends NumberIterable<Double> {

    public DoubleIterable(NumberRule<Double> rule, Integer n) {
        super(rule, n);
        if (step == null) {
            iterations = n;
        } else if (n == null) {
            iterations = (int) ((max - min) / step);
        }
    }

    @Override
    public Iterator<Double> iterator() {
        return new Iterator<Double>() {
            @Override
            public boolean hasNext() {
                return hasNextNumber();
            }

            @Override
            public Double next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                if (step == null) {
                    count++;
                    return (random.nextDouble() * (max - min)) + min;
                }
                return min + (count++ * step);
            }

            @Override
            public void remove() {

            }
        };
    }
}
