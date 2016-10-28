package com.fossgalaxy.util.rules;

/**
 * Created by piers on 04/08/16.
 */
public class FloatRule extends NumberRule<Float> {

    public FloatRule() {
    }

    public FloatRule(Integer decimalPlaces) {
        super(new Integer[]{decimalPlaces});
    }

    public FloatRule(Float maxValue) {
        this(0.0f, maxValue);
    }

    public FloatRule(Float maxValue, Integer decimalPlaces) {
        super(maxValue, new Integer[]{decimalPlaces});
    }

    public FloatRule(Float minValue, Float maxValue) {
        super(minValue, maxValue);
    }

    public FloatRule(Float minValue, Float maxValue, Integer decimalPlaces) {
        super(minValue, maxValue, new Integer[]{decimalPlaces});
    }

    public FloatRule(Float minValue, Float maxValue, Float step) {
        super(minValue, maxValue, step);
    }

    public FloatRule(Float minValue, Float maxValue, Float step, Integer decimalPlaces) {
        super(minValue, maxValue, step, new Integer[]{decimalPlaces});
    }
}
