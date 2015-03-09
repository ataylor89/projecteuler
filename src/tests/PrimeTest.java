package tests;

import java.util.List;
import primes.PrimeGenerator;
import primes.SieveOfEratosthenes;
import primes.TrialDivision;

/**
 *
 * @author ataylor
 */
public class PrimeTest {

    public static void main(String[] args) {
        int depth = 100;

        PrimeGenerator pgen = new SieveOfEratosthenes(depth, false);
        clock(pgen);

        System.out.println(pgen.getPrimes());
    }

    public static void clock(PrimeGenerator pgen) {
        long begin = System.currentTimeMillis();
        
        pgen.generate(); 	
       
        long end = System.currentTimeMillis();
        
        System.out.println(pgen.getClass().getSimpleName() + ": " + (end - begin) + "ms");
    }
}
