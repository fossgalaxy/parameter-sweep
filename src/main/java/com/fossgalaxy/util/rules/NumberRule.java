package com.fossgalaxy.util.rules;

/**
 * Created by piers on 04/08/16.
 */
public abstract class NumberRule<T extends Number> {

    private final T minValue;
    private final T maxValue;
    private final T step;
    private final Integer decimalPlaces;

    public NumberRule() {
        this(null, null, null, null);
    }

    public NumberRule(Integer[] decimalPlaces) {
        this(null, null, null, decimalPlaces);
    }

    public NumberRule(T maxValue) {
        this(null, maxValue, null, null);
    }

    public NumberRule(T maxValue, Integer[] decimalPlaces) {
        this(null, maxValue, null, decimalPlaces);
    }

    public NumberRule(T minValue, T maxValue) {
        this(minValue, maxValue, null, null);
    }

    public NumberRule(T minValue, T maxValue, Integer[] decimalPlaces) {
        this(minValue, maxValue, null, decimalPlaces);
    }

    public NumberRule(T minValue, T maxValue, T step) {
        this(minValue, maxValue, step, null);
    }

    public NumberRule(T minValue, T maxValue, T step, Integer[] decimalPlaces) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.step = step;
        this.decimalPlaces = (decimalPlaces == null) ? null : decimalPlaces[0];
    }

    public T getMinValue() {
        return minValue;
    }

    public T getMaxValue() {
        return maxValue;
    }

    public T getStep() {
        return step;
    }

    public Integer getDecimalPlaces() {
        return decimalPlaces;
    }
}
