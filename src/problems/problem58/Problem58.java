package problems.problem58;

import util.PrimeGenerator;
import util.SieveOfEratosthenes;

/**
 *
 * @author ataylor
 */
public class Problem58 {
    public static void main(String[] args) {
        int depth = 30001;
        PrimeGenerator pgen = new SieveOfEratosthenes(depth * depth, true);
        
        SquareSpiral sp = new SquareSpiral(depth, pgen);
        sp.solve();
    }
}
