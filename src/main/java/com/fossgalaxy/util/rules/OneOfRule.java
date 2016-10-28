package com.fossgalaxy.util.rules;

/**
 * Created by piers on 25/10/16.
 */
public class OneOfRule<T> {

    private final T[] values;

    public OneOfRule(T... values) {
        this.values = values;
    }

    public T[] getValues() {
        return values;
    }

    public int numValues() {
        return values.length;
    }
}
