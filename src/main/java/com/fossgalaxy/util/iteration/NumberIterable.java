package com.fossgalaxy.util.iteration;

import com.fossgalaxy.util.rules.NumberRule;

import java.util.Random;

/**
 * Created by Piers on 09/08/2016.
 */
public abstract class NumberIterable<T extends Number> implements Iterable<T> {
    protected int count = 0;
    protected final T min, max, step;
    protected final Integer decimalPlaces;
    protected Integer iterations;
    protected final Random random = new Random();

    public NumberIterable(NumberRule<T> rule, final Integer n) {
        this.min = rule.getMinValue();
        this.max = rule.getMaxValue();
        this.step = rule.getStep();
        this.decimalPlaces = rule.getDecimalPlaces();
    }

    public boolean hasNextNumber() {
        return (iterations == null) || (count <= iterations);
    }

    @Override
    public String toString() {
        return "NumberIterable{" +
                "count=" + count +
                ", min=" + min +
                ", max=" + max +
                ", step=" + step +
                ", decimalPlaces=" + decimalPlaces +
                ", iterations=" + iterations +
                ", random=" + random +
                '}';
    }

    protected double truncate(double number) {
        if(decimalPlaces == null) return number;
        return Math.round(number * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);
    }

    protected float truncate(float number) {
        return (float) truncate(number * 1.0d);
    }
}
