package iteration;

import rules.OneOfRule;

import java.util.Iterator;

/**
 * Created by piers on 25/10/16.
 */
public class OneOfIterable<T> implements Iterable<T> {

    private final OneOfRule<T> rule;
    private int count = 0;

    public OneOfIterable(OneOfRule<T> rule) {
        this.rule = rule;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return true;
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
