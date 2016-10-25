package iteration;

import rules.OneOfRule;

import java.util.Iterator;

/**
 * Created by piers on 25/10/16.
 */
public class OneOfIterable<T> implements Iterable<T> {

    private final OneOfRule<T> rule;
    private int count = 0;
    private final int iterations;

    public OneOfIterable(OneOfRule<T> rule, Integer n) {
        this.rule = rule;
        iterations = (n == null)? rule.numValues() : n;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return count < iterations;
            }

            @Override
            public T next() {
                T item = rule.getValues()[count];
                count++;
                count %= rule.numValues();
                return item;
            }

            @Override
            public void remove() {

            }
        };
    }
}
