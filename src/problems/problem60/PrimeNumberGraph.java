package util;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class PrimeNumberGraph extends Graph {
    
    private SieveOfEratosthenes sieve;
    private int sizeOfSieve = Integer.MAX_VALUE - 8;
    private int sizeOfGraph;
    
    public PrimeNumberGraph(int sizeOfGraph) {
        super();
        this.sizeOfGraph = sizeOfGraph;
        
        sieve = new SieveOfEratosthenes(sizeOfSieve);
        sieve.generate(true);
    }
    
    public void generate(boolean showRunningTime) {
        long begin = System.currentTimeMillis();
        
        List<Integer> primes = sieve.getPrimes(sizeOfGraph);
        
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                Integer n1 = primes.get(i);
                Integer n2 = primes.get(j);
                
                if (hasProperty(n1, n2))
                    addEdge(n1, n2);
            }
        }
        
        long runningTime = System.currentTimeMillis() - begin;
        
        if (showRunningTime)
            System.out.println("Generated graph in " + runningTime + "ms. Highest prime: " + Collections.max(vertices.keySet()));
    }
    
    private boolean hasProperty(Integer n1, Integer n2) {
        long c1 = concat(n1, n2);
        long c2 = concat(n2, n1);

        if (c1 < sizeOfSieve && c2 < sizeOfSieve)
            return sieve.isPrime((int) c1) && sieve.isPrime((int) c2);
        
        return false; 
        
//        if (digits(n1) + digits(n2) > 10)
//            return false;
//        
//        BigInteger b1 = BigInteger.valueOf(c1);
//        BigInteger b2 = BigInteger.valueOf(c2);
//        
//        int certainty = 5;
//        
//        if (c1 <= sieveDepth)
//            return primeFinder.isPrime((int) c1) && b2.isProbablePrime(certainty);
//        
//        if (c2 <= sieveDepth)
//            return primeFinder.isPrime((int) c2) && b1.isProbablePrime(certainty);
//        
//        return b1.isProbablePrime(certainty) && b2.isProbablePrime(certainty);
    }
    
    private long concat(Integer n1, Integer n2) {
        int nd = n2.toString().length();
        
        Long m1 = n1.longValue();
        Long m2 = n2.longValue();
        
        for (int i = 0; i < nd; i++)
            m1 *= 10;
        
        return m1 + m2;
    }
    
//    private int digits(Integer n) {
//        return n.toString().length();
//    }
       
    @Override
    public String toString() {
        List<Vertex> lst = vertices();
        
        return "Prime concatenation graph\n====================" 
                + "\nVertices: " + vertices.size() 
                + "\nEdges: " + edges.size() 
                + "\nMaximum vertex: " + lst.get(vertices.size() - 1) + "\n====================";
    }
}
