package com.fossgalaxy.util.iteration;

import com.fossgalaxy.util.rules.NumberRule;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Piers on 09/08/2016.
 */
public class FloatIterable extends NumberIterable<Float> {

    public FloatIterable(NumberRule<Float> rule, Integer n) {
        super(rule, n);
    }

    @Override
    public Iterator<Float> iterator() {
        return new Iterator<Float>() {
            @Override
            public boolean hasNext() {
                return hasNextNumber();
            }

            @Override
            public Float next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                if (step == null) {
                    count++;
                    return (random.nextFloat() * (max - min)) + min;
                }
                return min + (count++ * step);
            }

            @Override
            public void remove() {

            }
        };
    }
}
