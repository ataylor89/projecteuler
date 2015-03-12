package util;

import java.util.Collections;

/**
 *
 * @author ataylor
 */
public class Combination<E extends Comparable> extends Permutation<E> {
    
    public Combination() {
        super();
    }
    
    public Combination(E ... objects) {
        this();
        add(objects);
    }
    
    @Override
    public void add(E object) {
        objects.add(object);
        Collections.sort(objects);
    }
}
