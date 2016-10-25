/**
 * Created by piers on 04/08/16.
 *
 * Class designed to provide easy parameter sweeping
 */
public interface ParameterSweep {

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * Boolean rule with the same name
     * @param key The key for use
     */
    void setBoolean(String key);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * Boolean rule with the same name
     * @param key The key for use
     * @param trueProbability The probability that the random parameter will be true. Between [0-1]
     */
    void setBoolean(String key, double trueProbability);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * Integer rule with the same name
     * @param key The key for use
     */
    void setInteger(String key);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * Integer rule with the same name.
     *
     * The values will be between [0 - maxValue] inclusive
     * @param key the key for use
     * @param maxValue the maximum value that can be returned
     */
    void setInteger(String key, int maxValue);

    /**
     * Sets a new random parameter with the given key. Will overwrite an existing
     * Integer rule with the same name.
     *
     * The values will be between [minValue - maxValue] inclusive
     * @param key the key for use
     * @param minValue the minimum value that can be returned
     * @param maxValue the maximum value that can be returned
     */
    void setInteger(String key, int minValue, int maxValue);

    /**
     * Sets a new stepped parameter with the given key. Will overwrite an existing
     * Integer rule with the same name.
     *
     * The values will be between [minValue - maxValue] inclusive with a stepping of [step]
     *
     * maxValue may never be returned if it isn't possible due to the step and minValue
     *
     * for example ("T", 2, 5, 2) can't return 5
     * @param key The key for use
     * @param minValue The minimum value that can be returned
     * @param maxValue The maximum value that can be returned
     * @param step The step of the values
     */
    void setInteger(String key, int minValue, int maxValue, int step);

    /**
     * Sets a new parameter that traverses through the given values in the order given
     *
     * @param key The key for use
     * @param values The values for use
     */
    void setOneOfInteger(String key, Integer... values);

    void setFloat(String key);
    void setFloat(String key, int decimalPlaces);
    void setFloat(String key, float maxValue);
    void setFloat(String key, float maxValue, int decimalPlaces);
    void setFloat(String key, float minValue, float maxValue);
    void setFloat(String key, float minValue, float maxValue, int decimalPlaces);
    void setFloat(String key, float minValue, float maxValue, float step);
    void setFloat(String key, float minValue, float maxValue, float step, int decimalPlaces);

    void setDouble(String key);
    void setDouble(String key, int decimalPlaces);
    void setDouble(String key, double maxValue);
    void setDouble(String key, double maxValue, int decimalPlaces);
    void setDouble(String key, double minValue, double maxValue);
    void setDouble(String key, double minValue, double maxValue, int decimalPlaces);
    void setDouble(String key, double minValue, double maxValue, double step);
    void setDouble(String key, double minValue, double maxValue, double step, int decimalPlaces);


    void setOneOfFloat(String key, Float... values);
    void setOneOfDouble(String key, Double... values);

    void setOneOf(String key, Object... values);

    Iterable<Boolean> getBoolean(String key);
    Iterable<Boolean> getBoolean(String key, Integer n);
    Iterable<Integer> getInteger(String key);
    Iterable<Integer> getInteger(String key, Integer n);
    Iterable<Float> getFloat(String key);
    Iterable<Float> getFloat(String key, Integer n);
    Iterable<Double> getDouble(String key);
    Iterable<Double> getDouble(String key, Integer n);
    Iterable<Object> getObject(String key);
    Iterable<Object> getObject(String key, Integer n);



}
