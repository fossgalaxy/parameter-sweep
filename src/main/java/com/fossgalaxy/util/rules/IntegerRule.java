package com.fossgalaxy.util.rules;

/**
 * Created by piers on 04/08/16.
 */
public class IntegerRule extends NumberRule<Integer> {

    public IntegerRule() {
    }

    public IntegerRule(Integer maxValue) {
        this(0, maxValue);
    }

    public IntegerRule(Integer minValue, Integer maxValue) {
        super(minValue, maxValue);
    }

    public IntegerRule(Integer minValue, Integer maxValue, Integer step) {
        super(minValue, maxValue, step);
    }

    public IntegerRule(Integer minValue, Integer maxValue, Integer step, Integer decimalPlaces) {
        super(minValue, maxValue, step, new Integer[]{decimalPlaces});
    }

    @Override
    public Integer getMinValue() {
        return (super.getMinValue() == null) ? 0 : super.getMinValue();
    }

    @Override
    public Integer getMaxValue() {
        return (super.getMaxValue() == null) ? Integer.MAX_VALUE : super.getMaxValue();
    }
}
