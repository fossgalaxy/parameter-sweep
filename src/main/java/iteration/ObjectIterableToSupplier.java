package iteration;

import java.util.Iterator;
import java.util.function.Supplier;

/**
 * Created by piers on 26/10/16.
 */
public class ObjectIterableToSupplier<T> implements Supplier<T> {

    private Iterator<Object> iterableIterator;

    public ObjectIterableToSupplier(Iterable<Object> iterable) {
        this.iterableIterator = iterable.iterator();
    }

    @Override
    public T get() {
        if(iterableIterator.hasNext()) {
            return (T) iterableIterator.next();
        }
        return null;
    }
}
