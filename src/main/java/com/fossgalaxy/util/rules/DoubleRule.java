package com.fossgalaxy.util.rules;

/**
 * Created by piers on 04/08/16.
 */
public class DoubleRule extends NumberRule<Double> {

    public DoubleRule() {
    }

    public DoubleRule(Integer decimalPlaces) {
        super(new Integer[]{decimalPlaces});
    }

    public DoubleRule(Double maxValue) {
        this(0.0d, maxValue);
    }

    public DoubleRule(Double maxValue, Integer decimalPlaces) {
        super(maxValue, new Integer[]{decimalPlaces});
    }

    public DoubleRule(Double minValue, Double maxValue) {
        super(minValue, maxValue);
    }

    public DoubleRule(Double minValue, Double maxValue, Integer decimalPlaces) {
        super(minValue, maxValue, new Integer[]{decimalPlaces});
    }

    public DoubleRule(Double minValue, Double maxValue, Double step) {
        super(minValue, maxValue, step);
    }

    public DoubleRule(Double minValue, Double maxValue, Double step, Integer decimalPlaces) {
        super(minValue, maxValue, step, new Integer[]{decimalPlaces});
    }
}
