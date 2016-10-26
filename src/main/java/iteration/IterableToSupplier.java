package iteration;

import java.util.Iterator;
import java.util.function.Supplier;

/**
 * Created by piers on 26/10/16.
 */
public class IterableToSupplier<T> implements Supplier<T> {

    private Iterator<T> iterableIterator;

    public IterableToSupplier(Iterable<T> iterable) {
        iterableIterator = iterable.iterator();
    }

    public IterableToSupplier(OneOfIterable<T> iterable){
        iterableIterator = iterable.iterator();
    }

    @Override
    public T get() {
        if(iterableIterator.hasNext()){
            return iterableIterator.next();
        }
        return null;
    }
}
