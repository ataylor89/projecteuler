package problems.problem58;

import util.PrimeFinder;
import util.SieveOfEratosthenes;

/**
 *
 * @author ataylor
 */
public class Problem58 {
    public static void main(String[] args) {
        int depth = 30001;
        PrimeFinder pgen = new SieveOfEratosthenes(depth * depth);
        pgen.generate(true);
        
        SquareSpiral sp = new SquareSpiral(depth, pgen);
        sp.solve();
    }
}
