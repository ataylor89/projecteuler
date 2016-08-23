package archived;

import java.util.Arrays;

/**
 *
 * @author ataylor
 */
public class BooleanArray64 {
    
    private boolean[][] data;
    private long size;
    
    public static final int MAX_ROW_LENGTH = Short.MAX_VALUE;
    
    private final int ROW_LENGTH;
    private final int NUM_ROWS;
    
    public BooleanArray64(long size) {
        this.size = size;
        
        if (size <= MAX_ROW_LENGTH) {
            ROW_LENGTH = (int) size;
            NUM_ROWS = 1;
        }
        else {
            ROW_LENGTH = MAX_ROW_LENGTH;
            NUM_ROWS = (int) (divides(MAX_ROW_LENGTH, size) ? (size / MAX_ROW_LENGTH) : (size / MAX_ROW_LENGTH + 1));
        }
        
        data = new boolean[NUM_ROWS][ROW_LENGTH];
    }
    
    private boolean divides(long n, long m) {
        return n % m == 0;
    }
    
    public void set(long index, boolean value) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException();
        
        int rowIndex = (int) (index / ROW_LENGTH);
        int colIndex = (int) (index % ROW_LENGTH);
        
        data[rowIndex][colIndex] = value;
    }
    
    public boolean get(long index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException();
        
        int rowIndex = (int) (index / ROW_LENGTH);
        int colIndex = (int) (index % ROW_LENGTH);
        
        return data[rowIndex][colIndex];
    }
    
    public void fill(boolean value) {
        for (int i = 0; i < NUM_ROWS; i++)
            Arrays.fill(data[i], value);
    }
    
    public long length() {
        return size;
    }

    public static void main(String[] args) {
        long size = 0xFFFFFFFFL;
        
        BooleanArray64 b = new BooleanArray64(size);
        b.fill(false);
        
        long n = BooleanArray64.MAX_ROW_LENGTH * 2;
        b.set(n, true);
        b.set(n + 1, true);
        
        System.out.println("n-1: " + b.get(n-1));
        System.out.println("n: " + b.get(n));
        System.out.println("n+1: " + b.get(n+1));
        System.out.println("n+2: " + b.get(n+2));
    }
}
