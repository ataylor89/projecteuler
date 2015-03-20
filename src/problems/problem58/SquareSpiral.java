package problems.problem58;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.fraction.Fraction;
import util.PrimeFinder;

/**
 *
 * @author ataylor
 */
public class SquareSpiral {
    int row, col;
    int counter = 1;
    
    final int SIZE;
    final int RIGHT = 1, LEFT = 2, UP = 3, DOWN = 4;
    
    List<Integer> diagonals;
    List<Integer> primeDiagonals;
    
    private PrimeFinder pgen;

    public SquareSpiral(int depth, PrimeFinder pgen) {
        assert (depth % 2 == 1);
        
        SIZE = depth;
        row = col = depth / 2;
        
        diagonals = new ArrayList<>();
        primeDiagonals = new ArrayList<>();
        
        this.pgen = pgen;
    }

    public void solve() {
        // starting location
        diagonals.add(1);
        
        int step = 1;
        while (step < SIZE) {
            step(RIGHT, 1);
            step(UP, step);
            step(LEFT, step + 1);
            step(DOWN, step + 1);
            step(RIGHT, step + 1);
            
            step += 2;
            
            if (solved()) {
                Fraction ratio = new Fraction(primeDiagonals.size(), diagonals.size());
                System.out.println("Size: " + step + "\nRatio: " + ratio);
                break;
            }
        }
    }

    private void step(int direction) {
        switch (direction) {
            case RIGHT:
                col++;
                break;
            case UP:
                row--;
                break;
            case LEFT:
                col--;
                break;
            case DOWN:
                row++;
                break;
        }
        counter++;   
    }

    private void step(int direction, int numTimes) {
        for (int i = 0; i < numTimes; i++) {
            step(direction);
        }
        
        if (row == col || (row + col == SIZE - 1)) {
            diagonals.add(counter);
            
            if (pgen.isPrime(counter)) 
                primeDiagonals.add(counter);
        }
    }
    
    private boolean solved() {
        if (diagonals.size() < 2)
            return false;
        
        Fraction ratio = new Fraction(primeDiagonals.size(), diagonals.size());
        Fraction oneTenth = new Fraction(1, 10);
        
        return ratio.compareTo(oneTenth) < 0;
    }
    
    @Override
    public String toString() {
        return diagonals.toString();
    }
}
