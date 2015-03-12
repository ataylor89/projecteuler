package util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Permutation<E> {
    
    protected List<E> objects;
    
    public Permutation() {
        objects = new ArrayList<>();
    }
    
    public Permutation(E ... objects) {
        this();
        add(objects);
    }
    
    public void add(E object) {
        objects.add(object);
    }
    
    public final void add(E ... objects) {
        for (E obj : objects)
            add(obj);
    }
            
    
    public List<E> getObjects() {
        return objects;
    }
    
    public E get(int i) {
        return objects.get(i);
    }
    
    public Integer size() {
        return objects.size();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Permutation))
            return false;
        
        Permutation pmt = (Permutation) o;
        
        if (size() != pmt.size())
            return false;
        
        for (int i = size() - 1; i >= 0; i--) 
            if (!get(i).equals(pmt.get(i)))
                return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        
        for (E obj : objects)
            hashCode += obj.hashCode();
        
        return hashCode;
    }
    
    @Override
    public String toString() {
        return objects.toString();
    }
}
