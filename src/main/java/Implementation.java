import rules.BooleanRule;
import rules.DoubleRule;
import rules.FloatRule;
import rules.IntegerRule;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by piers on 04/08/16.
 */
public class Implementation implements ParameterSweep {

    private final HashMap<String, BooleanRule> booleanRules = new HashMap<String, BooleanRule>();
    private final HashMap<String, IntegerRule> integerRules = new HashMap<String, IntegerRule>();
    private final HashMap<String, FloatRule> floatRules = new HashMap<String, FloatRule>();
    private final HashMap<String, DoubleRule> doubleRules = new HashMap<String, DoubleRule>();


    public void setBoolean(String key) {
        booleanRules.put(key, new BooleanRule());
    }

    public void setBoolean(String key, double trueProbability) {
        booleanRules.put(key, new BooleanRule(trueProbability));
    }

    public void setInteger(String key) {
        integerRules.put(key, new IntegerRule());
    }

    public void setInteger(String key, int maxValue) {
        integerRules.put(key, new IntegerRule(maxValue));
    }

    public void setInteger(String key, int minValue, int maxValue) {
        integerRules.put(key, new IntegerRule(minValue, maxValue));
    }

    public void setInteger(String key, int minValue, int maxValue, int step) {
        integerRules.put(key, new IntegerRule(minValue, maxValue, step));
    }

    public void setFloat(String key) {
        floatRules.put(key, new FloatRule());
    }

    public void setFloat(String key, int decimalPlaces) {
        floatRules.put(key, new FloatRule(decimalPlaces));
    }

    public void setFloat(String key, float maxValue) {
        floatRules.put(key, new FloatRule(maxValue));
    }

    public void setFloat(String key, float maxValue, int decimalPlaces) {
        floatRules.put(key, new FloatRule(maxValue, decimalPlaces));
    }

    public void setFloat(String key, float minValue, float maxValue) {
        floatRules.put(key, new FloatRule(minValue, maxValue));
    }

    public void setFloat(String key, float minValue, float maxValue, int decimalPlaces) {
        floatRules.put(key, new FloatRule(minValue, maxValue, decimalPlaces));
    }

    public void setFloat(String key, float minValue, float maxValue, float step) {
        floatRules.put(key, new FloatRule(minValue, maxValue, step));
    }

    public void setFloat(String key, float minValue, float maxValue, float step, int decimalPlaces) {
        floatRules.put(key, new FloatRule(minValue, maxValue, step, decimalPlaces));
    }

    public void setDouble(String key) {
        doubleRules.put(key, new DoubleRule());
    }

    public void setDouble(String key, int decimalPlaces) {
        doubleRules.put(key, new DoubleRule(decimalPlaces));
    }

    public void setDouble(String key, double maxValue) {
        doubleRules.put(key, new DoubleRule(maxValue));
    }

    public void setDouble(String key, double maxValue, int decimalPlaces) {
        doubleRules.put(key, new DoubleRule(maxValue, decimalPlaces));
    }

    public void setDouble(String key, double minValue, double maxValue) {
        doubleRules.put(key, new DoubleRule(minValue, maxValue));
    }

    public void setDouble(String key, double minValue, double maxValue, int decimalPlaces) {
        doubleRules.put(key, new DoubleRule(minValue, maxValue, decimalPlaces));
    }

    public void setDouble(String key, double minValue, double maxValue, double step) {
        doubleRules.put(key, new DoubleRule(minValue, maxValue, step));
    }

    public void setDouble(String key, double minValue, double maxValue, double step, int decimalPlaces) {
        doubleRules.put(key, new DoubleRule(minValue, maxValue, step, decimalPlaces));
    }

    public Iterable<Boolean> getBoolean(final String key) {
        return getBoolean(key, null);
    }

    public Iterable<Boolean> getBoolean(final String key, final Integer n) {
        if(!booleanRules.containsKey(key)) throw new IllegalArgumentException("Key not present: " + key);
        return new Iterable<Boolean>() {
            int count = 0;
            BooleanRule rule = booleanRules.get(key);

            Random random = new Random();

            public Iterator<Boolean> iterator() {
                return new Iterator<Boolean>() {
                    public boolean hasNext() {
                        return (n == null) || (count < n);
                    }

                    public Boolean next() {
                        count++;
                        return rule.getTrueProbability() < random.nextDouble();
                    }

                    public void remove() {

                    }
                };
            }
        };
    }

    public Iterable<Integer> getInteger(final String key) {
        return getInteger(key, null);
    }

    public Iterable<Integer> getInteger(final String key, final Integer n) {
        if(!integerRules.containsKey(key)) throw new IllegalArgumentException("Key not present: " + key);
        return new Iterable<Integer>() {
            int count = 0;
            IntegerRule rule = integerRules.get(key);
            Random random = new Random();

            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    public boolean hasNext() {
                        return (n == null) || (count < n);
                    }

                    public Integer next() {
                        if (rule.getStep() == null) {
                            count++;
                            return random.nextInt((rule.getMaxValue() - rule.getMinValue()) + 1) + rule.getMinValue();
                        }
                        return rule.getMinValue() + (count++ * rule.getStep());
                    }

                    public void remove() {

                    }
                };
            }
        };
    }

    public Iterable<Float> getFloat(final String key) {
        return getFloat(key, null);
    }

    public Iterable<Float> getFloat(final String key, final Integer n) {
        if(!floatRules.containsKey(key)) throw new IllegalArgumentException("Key not present: " + key);
        return new Iterable<Float>() {
            int count = 0;
            FloatRule rule = floatRules.get(key);
            Random random = new Random();

            public Iterator<Float> iterator() {
                return new Iterator<Float>() {
                    public boolean hasNext() {
                        return (n == null) || (count < n);
                    }

                    public Float next() {
                        if (rule.getStep() == null) {
                            count++;
                            return (random.nextFloat() * (rule.getMaxValue() - rule.getMinValue())) + rule.getMinValue();
                        }
                        return rule.getMinValue() + (count++ * rule.getStep());
                    }

                    public void remove() {

                    }
                };
            }
        };
    }

    public Iterable<Double> getDouble(final String key) {
        return getDouble(key, null);
    }

    public Iterable<Double> getDouble(final String key, final Integer n) {
        if(!doubleRules.containsKey(key)) throw new IllegalArgumentException("Key not present: " + key);
        return new Iterable<Double>() {
            int count = 0;
            DoubleRule rule = doubleRules.get(key);
            Random random = new Random();

            public Iterator<Double> iterator() {
                return new Iterator<Double>() {
                    public boolean hasNext() {
                        return (n == null) || (n < count);
                    }

                    public Double next() {
                        if (rule.getStep() == null) {
                            count++;
                            return (random.nextDouble() * (rule.getMaxValue() - rule.getMinValue())) + rule.getMinValue();
                        }
                        return rule.getMaxValue() + (count++ * rule.getStep());
                    }

                    public void remove() {

                    }
                };
            }
        };
    }
}
