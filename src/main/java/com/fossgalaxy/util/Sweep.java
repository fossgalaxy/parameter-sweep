package com.fossgalaxy.util;

import com.fossgalaxy.util.iteration.*;
import com.fossgalaxy.util.rules.*;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by piers on 04/08/16.
 */
public class Sweep implements ParameterSweep {

    private final HashMap<String, BooleanRule> booleanRules = new HashMap<>();
    private final HashMap<String, IntegerRule> integerRules = new HashMap<>();
    private final HashMap<String, FloatRule> floatRules = new HashMap<>();
    private final HashMap<String, DoubleRule> doubleRules = new HashMap<>();
    private final HashMap<String, OneOfRule<Integer>> integerOneOfRules = new HashMap<>();
    private final HashMap<String, OneOfRule<Float>> floatOneOfRules = new HashMap<>();
    private final HashMap<String, OneOfRule<Double>> doubleOneOfRules = new HashMap<>();
    private final HashMap<String, OneOfRule<Object>> objectOneOfRules = new HashMap<>();

    private final HashMap<String, Iterator<Boolean>> cachedBooleanIterators = new HashMap<>();
    private final HashMap<String, Iterator<Integer>> cachedIntegerIterators = new HashMap<>();
    private final HashMap<String, Iterator<Float>> cachedFloatIterators = new HashMap<>();
    private final HashMap<String, Iterator<Double>> cachedDoubleIterators = new HashMap<>();

    // Stores the maps that a key has been used in
    private final HashMap<String, ArrayList<HashMap>> keyMap = new HashMap<>();

    /**
     * Will clear the key from any map that has been registered as using it
     *
     * @param key The key to clear with
     */
    private void clearKey(String key) {
        // Clear out old use of this key
        if (keyMap.containsKey(key)) {
            keyMap.get(key).forEach(x -> x.remove(key));
        }
    }

    /**
     * Will register a key as used with a map without overwriting the key anywhere
     *
     * @param key The key that is being used
     * @param map The map that the key is being used in
     */
    private void registerKey(String key, HashMap map) {
        keyMap.computeIfAbsent(key, x -> new ArrayList<>()).add(map);
    }

    @Override
    public void setBoolean(String key) {
        clearKey(key);
        booleanRules.put(key, new BooleanRule());
        registerKey(key, booleanRules);
    }

    @Override
    public void setBoolean(String key, double trueProbability) {
        clearKey(key);
        booleanRules.put(key, new BooleanRule(trueProbability));
        registerKey(key, booleanRules);
    }

    @Override
    public void setInteger(String key) {
        clearKey(key);
        integerRules.put(key, new IntegerRule());
        registerKey(key, integerRules);
    }

    @Override
    public void setInteger(String key, int maxValue) {
        clearKey(key);
        integerRules.put(key, new IntegerRule(maxValue));
        registerKey(key, integerRules);
    }

    @Override
    public void setInteger(String key, int minValue, int maxValue) {
        clearKey(key);
        integerRules.put(key, new IntegerRule(minValue, maxValue));
        registerKey(key, integerRules);
    }

    @Override
    public void setInteger(String key, int minValue, int maxValue, int step) {
        clearKey(key);
        integerRules.put(key, new IntegerRule(minValue, maxValue, step));
        registerKey(key, integerRules);
    }

    @Override
    public void setOneOfInteger(String key, Integer... values) {
        clearKey(key);
        integerOneOfRules.put(key, new OneOfRule<>(values));
        registerKey(key, integerOneOfRules);
    }

    @Override
    public void setFloat(String key) {
        clearKey(key);
        floatRules.put(key, new FloatRule());
        registerKey(key, floatRules);
    }

    @Override
    public void setFloat(String key, int decimalPlaces) {
        clearKey(key);
        floatRules.put(key, new FloatRule(decimalPlaces));
        registerKey(key, floatRules);
    }

    @Override
    public void setFloat(String key, float maxValue) {
        clearKey(key);
        floatRules.put(key, new FloatRule(maxValue));
        registerKey(key, floatRules);
    }

    @Override
    public void setFloat(String key, float maxValue, int decimalPlaces) {
        clearKey(key);
        floatRules.put(key, new FloatRule(maxValue, decimalPlaces));
        registerKey(key, floatRules);
    }

    @Override
    public void setFloat(String key, float minValue, float maxValue) {
        clearKey(key);
        floatRules.put(key, new FloatRule(minValue, maxValue));
        registerKey(key, floatRules);
    }

    @Override
    public void setFloat(String key, float minValue, float maxValue, int decimalPlaces) {
        clearKey(key);
        floatRules.put(key, new FloatRule(minValue, maxValue, decimalPlaces));
        registerKey(key, floatRules);
    }

    @Override
    public void setFloat(String key, float minValue, float maxValue, float step) {
        clearKey(key);
        floatRules.put(key, new FloatRule(minValue, maxValue, step));
        registerKey(key, floatRules);
    }

    @Override
    public void setFloat(String key, float minValue, float maxValue, float step, int decimalPlaces) {
        clearKey(key);
        floatRules.put(key, new FloatRule(minValue, maxValue, step, decimalPlaces));
        registerKey(key, floatRules);
    }

    @Override
    public void setOneOfFloat(String key, Float... values) {
        clearKey(key);
        floatOneOfRules.put(key, new OneOfRule<>(values));
        registerKey(key, floatOneOfRules);
    }

    @Override
    public void setDouble(String key) {
        clearKey(key);
        doubleRules.put(key, new DoubleRule());
        registerKey(key, doubleRules);
    }

    @Override
    public void setDouble(String key, int decimalPlaces) {
        clearKey(key);
        doubleRules.put(key, new DoubleRule(decimalPlaces));
        registerKey(key, doubleRules);
    }

    @Override
    public void setDouble(String key, double maxValue) {
        clearKey(key);
        doubleRules.put(key, new DoubleRule(maxValue));
        registerKey(key, doubleRules);
    }

    @Override
    public void setDouble(String key, double maxValue, int decimalPlaces) {
        clearKey(key);
        doubleRules.put(key, new DoubleRule(maxValue, decimalPlaces));
        registerKey(key, doubleRules);
    }

    @Override
    public void setDouble(String key, double minValue, double maxValue) {
        clearKey(key);
        doubleRules.put(key, new DoubleRule(minValue, maxValue));
        registerKey(key, doubleRules);
    }

    @Override
    public void setDouble(String key, double minValue, double maxValue, int decimalPlaces) {
        clearKey(key);
        doubleRules.put(key, new DoubleRule(minValue, maxValue, decimalPlaces));
        registerKey(key, doubleRules);
    }

    @Override
    public void setDouble(String key, double minValue, double maxValue, double step) {
        clearKey(key);
        doubleRules.put(key, new DoubleRule(minValue, maxValue, step));
        registerKey(key, doubleRules);
    }

    @Override
    public void setDouble(String key, double minValue, double maxValue, double step, int decimalPlaces) {
        clearKey(key);
        doubleRules.put(key, new DoubleRule(minValue, maxValue, step, decimalPlaces));
        registerKey(key, doubleRules);
    }

    @Override
    public void setOneOfDouble(String key, Double... values) {
        clearKey(key);
        doubleOneOfRules.put(key, new OneOfRule<>(values));
        registerKey(key, doubleOneOfRules);
    }

    @Override
    public void setOneOf(String key, Object... values) {
        clearKey(key);
        objectOneOfRules.put(key, new OneOfRule<>(values));
        registerKey(key, objectOneOfRules);
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
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
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
    public Boolean getBooleanSingle(String key) {
        return cachedBooleanIterators.computeIfAbsent(
                key,
                (x) -> {
                    registerKey(x, cachedBooleanIterators);
                    return getBoolean(x).iterator();
                }
        ).next();
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
        return (integerRules.containsKey(key)) ? new IntegerIterable(integerRules.get(key), n) : new OneOfIterable<>(integerOneOfRules.get(key), n);
    }

    @Override
    public Integer getIntegerSingle(String key) {
        return cachedIntegerIterators.computeIfAbsent(
                key,
                (x) -> {
                    registerKey(x, cachedIntegerIterators);
                    return getInteger(x).iterator();
                }
        ).next();
    }

    @Override
    public Stream<Integer> getIntegerStream(String key) {
        return getIntegerStream(key, null);
    }

    @Override
    public Stream<Integer> getIntegerStream(String key, Integer n) {
        return Stream.generate(new IterableToSupplier<>(getInteger(key, n)));
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
        return (floatRules.containsKey(key)) ? new FloatIterable(floatRules.get(key), n) : new OneOfIterable<>(floatOneOfRules.get(key), n);
    }

    @Override
    public Float getFloatSingle(String key) {
        return cachedFloatIterators.computeIfAbsent(
                key,
                (x) -> {
                    registerKey(x, cachedFloatIterators);
                    return getFloat(x).iterator();
                }
        ).next();
    }

    @Override
    public Stream<Float> getFloatStream(String key) {
        return getFloatStream(key, null);
    }

    @Override
    public Stream<Float> getFloatStream(String key, Integer n) {
        return Stream.generate(new IterableToSupplier<>(getFloat(key, n)));
    }

    @Override
    public Iterable<Double> getDouble(final String key) {
        return getDouble(key, null);
    }

    @Override
    public Iterable<Double> getDouble(final String key, final Integer n) {
        if (!doubleRules.containsKey(key) && !doubleOneOfRules.containsKey(key)) {
            throw new IllegalArgumentException("Key not present: " + key);
        }
        return (doubleRules.containsKey(key)) ? new DoubleIterable(doubleRules.get(key), n) : new OneOfIterable<>(doubleOneOfRules.get(key), n);
    }

    @Override
    public Double getDoubleSingle(String key) {
        return cachedDoubleIterators.computeIfAbsent(
                key,
                (x) -> {
                    registerKey(x, cachedDoubleIterators);
                    return getDouble(x).iterator();
                }
        ).next();
    }

    @Override
    public Stream<Double> getDoubleStream(String key) {
        return getDoubleStream(key, null);
    }

    @Override
    public Stream<Double> getDoubleStream(final String key, final Integer n) {
        return Stream.generate(new IterableToSupplier<>(getDouble(key, n)));
    }

    @Override
    public Iterable<Object> getObject(String key) {
        return getObject(key, null);
    }

    @Override
    public Iterable<Object> getObject(String key, Integer n) {
        if (!objectOneOfRules.containsKey(key)) {
            throw new IllegalArgumentException("Key not present: " + key);
        }
        return new OneOfIterable<>(objectOneOfRules.get(key), n);
    }

    @Override
    public Stream getObjectStream(String key) {
        return getObjectStream(key, -1);
    }

    @Override
    public Stream getObjectStream(String key, Integer n) {
        OneOfRule rule = objectOneOfRules.get(key);
        if (n == null || n < 0 || n >= rule.numValues()) {
            return Arrays.stream((rule.getValues()));
        }
        Object[] temp = new Object[n];
        System.arraycopy(rule.getValues(), 0, temp, 0, n);
        return Arrays.stream(temp);
    }

    @Override
    public <T> Stream<T> getObjectStream(String key, Class<T> clazz) {
        return getObjectStream(key, null, clazz);
    }

    public <T> Stream<T> getObjectStream(String key, Integer n, Class<T> clazz) {
        return getObjectStream(key, n)
                .filter(clazz::isInstance)
                .map(clazz::cast);
    }
}
