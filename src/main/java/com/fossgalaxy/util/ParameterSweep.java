package com.fossgalaxy.util;

import java.util.stream.Stream;

/**
 * Created by piers on 04/08/16.
 * <p>
 * Class designed to provide easy parameter sweeping
 */
public interface ParameterSweep {

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name
     *
     * @param key The key for use
     */
    void setBoolean(String key);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name
     *
     * @param key             The key for use
     * @param trueProbability The probability that the random parameter will be true. Between [0-1]
     */
    void setBoolean(String key, double trueProbability);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name
     *
     * @param key The key for use
     */
    void setInteger(String key);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name.
     * <p>
     * The values will be between [0 - maxValue] inclusive
     *
     * @param key      the key for use
     * @param maxValue the maximum value that can be returned
     */
    void setInteger(String key, int maxValue);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name.
     * <p>
     * The values will be between [minValue - maxValue] inclusive
     *
     * @param key      the key for use
     * @param minValue the minimum value that can be returned
     * @param maxValue the maximum value that can be returned
     */
    void setInteger(String key, int minValue, int maxValue);

    /**
     * Sets a new stepped parameter with the given key. Will overwrite an existing
     * rule with the same name.
     * <p>
     * The values will be between [minValue - maxValue] inclusive with a stepping of [step]
     * <p>
     * maxValue may never be returned if it isn't possible due to the step and minValue
     * <p>
     * for example ("T", 2, 5, 2) can't return 5
     *
     * @param key      The key for use
     * @param minValue The minimum value that can be returned
     * @param maxValue The maximum value that can be returned
     * @param step     The step of the values
     */
    void setInteger(String key, int minValue, int maxValue, int step);

    /**
     * Sets a new parameter that traverses through the given values in the order given
     *
     * @param key    The key for use
     * @param values The values for use
     */
    void setOneOfInteger(String key, Integer... values);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name
     *
     * @param key The key for use
     */
    void setFloat(String key);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name
     *
     * @param key           The key for use
     * @param decimalPlaces The number of decimal places to truncate the value to
     */
    void setFloat(String key, int decimalPlaces);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name.
     * <p>
     * The values will be between [0 - maxValue] inclusive
     *
     * @param key      the key for use
     * @param maxValue the maximum value that can be returned
     */
    void setFloat(String key, float maxValue);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name.
     * <p>
     * The values will be between [0 - maxValue] inclusive
     *
     * @param key           the key for use
     * @param maxValue      the maximum value that can be returned
     * @param decimalPlaces The number of decimal places to truncate the value to
     */
    void setFloat(String key, float maxValue, int decimalPlaces);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name.
     * <p>
     * The values will be between [minValue - maxValue] inclusive
     *
     * @param key      the key for use
     * @param minValue the minimum value that can be returned
     * @param maxValue the maximum value that can be returned
     */
    void setFloat(String key, float minValue, float maxValue);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name.
     * <p>
     * The values will be between [minValue - maxValue] inclusive
     *
     * @param key           the key for use
     * @param minValue      the minimum value that can be returned
     * @param maxValue      the maximum value that can be returned
     * @param decimalPlaces The number of decimal places to truncate the value to
     */
    void setFloat(String key, float minValue, float maxValue, int decimalPlaces);

    /**
     * Sets a new stepped parameter with the given key. Will overwrite an existing
     * rule with the same name.
     * <p>
     * The values will be between [minValue - maxValue] inclusive with a stepping of [step]
     * <p>
     * maxValue may never be returned if it isn't possible due to the step and minValue
     * <p>
     * for example ("T", 2, 5, 2) can't return 5
     *
     * @param key      The key for use
     * @param minValue The minimum value that can be returned
     * @param maxValue The maximum value that can be returned
     * @param step     The step of the values
     */
    void setFloat(String key, float minValue, float maxValue, float step);


    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name
     *
     * @param key The key for use
     */
    void setDouble(String key);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name
     *
     * @param key           The key for use
     * @param decimalPlaces The number of decimal places to truncate the value to
     */
    void setDouble(String key, int decimalPlaces);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name.
     * <p>
     * The values will be between [0 - maxValue] inclusive
     *
     * @param key      the key for use
     * @param maxValue the maximum value that can be returned
     */
    void setDouble(String key, double maxValue);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name.
     * <p>
     * The values will be between [0 - maxValue] inclusive
     *
     * @param key           the key for use
     * @param maxValue      the maximum value that can be returned
     * @param decimalPlaces The number of decimal places to truncate the value to
     */
    void setDouble(String key, double maxValue, int decimalPlaces);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name.
     * <p>
     * The values will be between [minValue - maxValue] inclusive
     *
     * @param key      the key for use
     * @param minValue the minimum value that can be returned
     * @param maxValue the maximum value that can be returned
     */
    void setDouble(String key, double minValue, double maxValue);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * rule with the same name.
     * <p>
     * The values will be between [minValue - maxValue] inclusive
     *
     * @param key           the key for use
     * @param minValue      the minimum value that can be returned
     * @param maxValue      the maximum value that can be returned
     * @param decimalPlaces The number of decimal places to truncate the value to
     */
    void setDouble(String key, double minValue, double maxValue, int decimalPlaces);

    /**
     * Sets a new stepped parameter with the given key. Will overwrite an existing
     * rule with the same name.
     * <p>
     * The values will be between [minValue - maxValue] inclusive with a stepping of [step]
     * <p>
     * maxValue may never be returned if it isn't possible due to the step and minValue
     * <p>
     * for example ("T", 2, 5, 2) can't return 5
     *
     * @param key      The key for use
     * @param minValue The minimum value that can be returned
     * @param maxValue The maximum value that can be returned
     * @param step     The step of the values
     */
    void setDouble(String key, double minValue, double maxValue, double step);

    /**
     * Set a new parameter that will iterate through the provided list
     *
     * @param key    The key for use
     * @param values The values for use
     */
    void setOneOfFloat(String key, Float... values);

    /**
     * Set a new parameter that will iterate through the provided list
     *
     * @param key    The key for use
     * @param values The values for use
     */
    void setOneOfDouble(String key, Double... values);

    /**
     * Set a new parameter that will iterate through the provided list
     *
     * @param key    The key for use
     * @param values The values for use
     */
    void setOneOf(String key, Object... values);

    /**
     * Gets an Iterable<Boolean> that corresponds to the given key
     *
     * @param key The key for use
     * @return The iterable
     */
    Iterable<Boolean> getBoolean(String key);

    /**
     * Gets an Iterable<Boolean> that corresponds to the given key
     *
     * @param key The key for use
     * @return The iterable
     */
    Iterable<Boolean> getBoolean(String key, Integer n);

    Boolean getBooleanSingle(String key);

    /**
     * Gets an Iterable<Integer> that corresponds to the given key
     *
     * @param key The key for use
     * @return The iterable
     */
    Iterable<Integer> getInteger(String key);

    /**
     * Gets an Iterable<Integer> that corresponds to the given key
     *
     * @param key The key for use
     * @return The iterable
     */
    Iterable<Integer> getInteger(String key, Integer n);

    Integer getIntegerSingle(String key);

    Stream<Integer> getIntegerStream(String key);

    Stream<Integer> getIntegerStream(String key, Integer n);

    /**
     * Gets an Iterable<Float> that corresponds to the given key
     *
     * @param key The key for use
     * @return The iterable
     */
    Iterable<Float> getFloat(String key);

    /**
     * Gets an Iterable<Float> that corresponds to the given key
     *
     * @param key The key for use
     * @return The iterable
     */
    Iterable<Float> getFloat(String key, Integer n);

    Float getFloatSingle(String key);

    Stream<Float> getFloatStream(String key);

    Stream<Float> getFloatStream(String key, Integer n);

    /**
     * Gets an Iterable<Double> that corresponds to the given key
     *
     * @param key The key for use
     * @return The iterable
     */
    Iterable<Double> getDouble(String key);

    /**
     * Gets an Iterable<Double> that corresponds to the given key
     *
     * @param key The key for use
     * @return The iterable
     */
    Iterable<Double> getDouble(String key, Integer n);

    Double getDoubleSingle(String key);

    Stream<Double> getDoubleStream(String key);

    Stream<Double> getDoubleStream(String key, Integer n);

    /**
     * Gets an Iterable<Object> that corresponds to the given key
     *
     * @param key The key for use
     * @return The iterable
     */
    Iterable<Object> getObject(String key);

    /**
     * Gets an Iterable<Object> that corresponds to the given key
     *
     * @param key The key for use
     * @return The iterable
     */
    Iterable<Object> getObject(String key, Integer n);

    Stream getObjectStream(String key);

    Stream getObjectStream(String key, Integer n);

    <T extends Object> Stream<T> getObjectStream(String key, Class<T> clazz);

    <T extends Object> Stream<T> getObjectStream(String key, Integer n, Class<T> clazz);


}
