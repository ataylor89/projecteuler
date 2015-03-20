package tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import util.PrimeFinder;
import util.SieveOfEratosthenes;

/**
 *
 * @author ataylor
 */
public class PrimeTest {

    public static void main(String[] args) throws IOException {
        int depth = 100;

        PrimeFinder pgen = new SieveOfEratosthenes(depth);
        clock(pgen);

        System.out.println(pgen.getPrimes());
        printToFile(pgen.getPrimes());
    }

    public static void clock(PrimeFinder pgen) {
        long begin = System.currentTimeMillis();
        
        pgen.generate(true); 	
       
        long end = System.currentTimeMillis();
        
        System.out.println(pgen.getClass().getSimpleName() + ": " + (end - begin) + "ms");
    }
    
    public static void printToFile(List<Integer> primes) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/tests/primes.txt"));
        for (Integer p : primes)
            bw.write(p + " ");
        
        bw.flush();
    }
}
