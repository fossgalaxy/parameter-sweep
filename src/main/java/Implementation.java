import iteration.DoubleIterable;
import iteration.FloatIterable;
import iteration.IntegerIterable;
import iteration.OneOfIterable;
import rules.*;

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
    private final HashMap<String, OneOfRule<Integer>> integerOneOfRules = new HashMap<>();
    private final HashMap<String, OneOfRule<Float>> floatOneOfRules = new HashMap<>();
    private final HashMap<String, OneOfRule<Double>> doubleOneOfRules = new HashMap<>();
    private final HashMap<String, OneOfRule<Object>> objectOneOfRules = new HashMap<>();

    @Override
    public void setBoolean(String key) {
        booleanRules.put(key, new BooleanRule());
    }

    @Override
    public void setBoolean(String key, double trueProbability) {
        booleanRules.put(key, new BooleanRule(trueProbability));
    }

    @Override
    public void setInteger(String key) {
        integerRules.put(key, new IntegerRule());
        if (integerOneOfRules.containsKey(key)) integerOneOfRules.remove(key);
    }

    @Override
    public void setInteger(String key, int maxValue) {
        integerRules.put(key, new IntegerRule(maxValue));
        if (integerOneOfRules.containsKey(key)) integerOneOfRules.remove(key);
    }

    @Override
    public void setInteger(String key, int minValue, int maxValue) {
        integerRules.put(key, new IntegerRule(minValue, maxValue));
        if (integerOneOfRules.containsKey(key)) integerOneOfRules.remove(key);
    }

    @Override
    public void setInteger(String key, int minValue, int maxValue, int step) {
        integerRules.put(key, new IntegerRule(minValue, maxValue, step));
        if (integerOneOfRules.containsKey(key)) integerOneOfRules.remove(key);
    }

    @Override
    public void setOneOfInteger(String key, Integer... values) {
        integerOneOfRules.put(key, new OneOfRule<>(values));
        if (integerRules.containsKey(key)) integerRules.remove(key);
    }

    @Override
    public void setFloat(String key) {
        floatRules.put(key, new FloatRule());
        if (floatOneOfRules.containsKey(key)) floatOneOfRules.remove(key);
    }

    @Override
    public void setFloat(String key, int decimalPlaces) {
        floatRules.put(key, new FloatRule(decimalPlaces));
        if (floatOneOfRules.containsKey(key)) floatOneOfRules.remove(key);
    }

    @Override
    public void setFloat(String key, float maxValue) {
        floatRules.put(key, new FloatRule(maxValue));
        if (floatOneOfRules.containsKey(key)) floatOneOfRules.remove(key);
    }

    @Override
    public void setFloat(String key, float maxValue, int decimalPlaces) {
        floatRules.put(key, new FloatRule(maxValue, decimalPlaces));
        if (floatOneOfRules.containsKey(key)) floatOneOfRules.remove(key);
    }

    @Override
    public void setFloat(String key, float minValue, float maxValue) {
        floatRules.put(key, new FloatRule(minValue, maxValue));
        if (floatOneOfRules.containsKey(key)) floatOneOfRules.remove(key);
    }

    @Override
    public void setFloat(String key, float minValue, float maxValue, int decimalPlaces) {
        floatRules.put(key, new FloatRule(minValue, maxValue, decimalPlaces));
        if (floatOneOfRules.containsKey(key)) floatOneOfRules.remove(key);
    }

    @Override
    public void setFloat(String key, float minValue, float maxValue, float step) {
        floatRules.put(key, new FloatRule(minValue, maxValue, step));
        if (floatOneOfRules.containsKey(key)) floatOneOfRules.remove(key);
    }

    @Override
    public void setFloat(String key, float minValue, float maxValue, float step, int decimalPlaces) {
        floatRules.put(key, new FloatRule(minValue, maxValue, step, decimalPlaces));
        if (floatOneOfRules.containsKey(key)) floatOneOfRules.remove(key);

    }

    @Override
    public void setOneOfFloat(String key, Float... values) {
        floatOneOfRules.put(key, new OneOfRule<>(values));
        if (floatRules.containsKey(key)) floatRules.remove(key);
    }

    @Override
    public void setDouble(String key) {
        doubleRules.put(key, new DoubleRule());
        if (doubleOneOfRules.containsKey(key)) doubleOneOfRules.remove(key);
    }

    @Override
    public void setDouble(String key, int decimalPlaces) {
        doubleRules.put(key, new DoubleRule(decimalPlaces));
        if (doubleOneOfRules.containsKey(key)) doubleOneOfRules.remove(key);
    }

    @Override
    public void setDouble(String key, double maxValue) {
        doubleRules.put(key, new DoubleRule(maxValue));
        if (doubleOneOfRules.containsKey(key)) doubleOneOfRules.remove(key);
    }

    @Override
    public void setDouble(String key, double maxValue, int decimalPlaces) {
        doubleRules.put(key, new DoubleRule(maxValue, decimalPlaces));
        if (doubleOneOfRules.containsKey(key)) doubleOneOfRules.remove(key);
    }

    @Override
    public void setDouble(String key, double minValue, double maxValue) {
        doubleRules.put(key, new DoubleRule(minValue, maxValue));
        if (doubleOneOfRules.containsKey(key)) doubleOneOfRules.remove(key);
    }

    @Override
    public void setDouble(String key, double minValue, double maxValue, int decimalPlaces) {
        doubleRules.put(key, new DoubleRule(minValue, maxValue, decimalPlaces));
        if (doubleOneOfRules.containsKey(key)) doubleOneOfRules.remove(key);
    }

    @Override
    public void setDouble(String key, double minValue, double maxValue, double step) {
        doubleRules.put(key, new DoubleRule(minValue, maxValue, step));
        if (doubleOneOfRules.containsKey(key)) doubleOneOfRules.remove(key);
    }

    @Override
    public void setDouble(String key, double minValue, double maxValue, double step, int decimalPlaces) {
        doubleRules.put(key, new DoubleRule(minValue, maxValue, step, decimalPlaces));
        if (doubleOneOfRules.containsKey(key)) doubleOneOfRules.remove(key);
    }

    @Override
    public void setOneOfDouble(String key, Double... values) {
        doubleOneOfRules.put(key, new OneOfRule<>(values));
        if (doubleRules.containsKey(key)) doubleRules.remove(key);
    }

    @Override
    public void setOneOf(String key, Object... values) {
        objectOneOfRules.put(key, new OneOfRule<>(values));
    }

    @Override
    public Iterable<Boolean> getBoolean(final String key) {
        return getBoolean(key, null);
    }

    @Override
    public Iterable<Boolean> getBoolean(final String key, final Integer n) {
        if (!booleanRules.containsKey(key)) throw new IllegalArgumentException("Key not present: " + key);
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

    @Override
    public Iterable<Integer> getInteger(final String key) {
        return getInteger(key, null);
    }

    @Override
    public Iterable<Integer> getInteger(final String key, final Integer n) {
        if (!integerRules.containsKey(key) && !integerOneOfRules.containsKey(key)) {
            throw new IllegalArgumentException("Key not present: " + key);
        }
        return (integerRules.containsKey(key)) ? new IntegerIterable(integerRules.get(key), n) : new OneOfIterable<>(integerOneOfRules.get(key));
    }

    @Override
    public Iterable<Float> getFloat(final String key) {
        return getFloat(key, null);
    }

    @Override
    public Iterable<Float> getFloat(final String key, final Integer n) {
        if (!floatRules.containsKey(key) && !floatOneOfRules.containsKey(key)) {
            throw new IllegalArgumentException("Key not present: " + key);
        }
        return (floatRules.containsKey(key)) ? new FloatIterable(floatRules.get(key), n) : new OneOfIterable<>(floatOneOfRules.get(key));
    }

    @Override
    public Iterable<Double> getDouble(final String key) {
        return getDouble(key, null);
    }

    @Override
    public Iterable<Double> getDouble(final String key, final Integer n) {
        if (!doubleRules.containsKey(key) && !doubleOneOfRules.containsKey(key)){
            throw new IllegalArgumentException("Key not present: " + key);
        }
        return (doubleRules.containsKey(key)) ? new DoubleIterable(doubleRules.get(key), n) : new OneOfIterable<>(doubleOneOfRules.get(key));
    }

    @Override
    public Iterable<Object> getObject(String key) {
        return getObject(key, null);
    }

    @Override
    public Iterable<Object> getObject(String key, Integer n) {
        if(!objectOneOfRules.containsKey(key)){
            throw  new IllegalArgumentException("Key not present: " + key);
        }
        return new OneOfIterable<>(objectOneOfRules.get(key), n);
    }
}
