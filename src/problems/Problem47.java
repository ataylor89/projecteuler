package problems;

import java.util.ArrayList;

/**
 *
 * @author ataylor
 */
public class Problem47 {
    
    private final int NUM_PRIMES = 10000;
    private boolean[] primeSieve = new boolean[NUM_PRIMES];
    
    private final int MAX_N = NUM_PRIMES * 100;
    private ArrayList[] primeFactors = new ArrayList[MAX_N];
    
    private final int ND = 4;
    
    private void fillSieve() {
        primeSieve[2] = true;
        
        for (int n = 3; n < primeSieve.length; n++) {
            primeSieve[n] = true;
            
            for (int m = 2; m < n; m++) {
                if (n % m == 0) {
                    primeSieve[n] = false;
                    break;
                }
            }
        }
    }
    
    private void primeFactorize() {
        for (int n = 2; n < MAX_N; n++) {
            primeFactors[n] = new ArrayList();
            
            for (int j = 2; j <= n && j < NUM_PRIMES; j++) {
                if (primeSieve[j] && (n % j == 0)) {
                    primeFactors[n].add(j);
                }
            }
        }
    }
    
    private void display() {
        for (int n = 2; n < NUM_PRIMES; n++) 
            display(n);
    }
    
    private void display(int n ) {
        System.out.print(n + ":");
            
        for (Object o : primeFactors[n])
            System.out.print(" " + o);

        System.out.println();
    }
    
    public void solve() {
        fillSieve();
        
        primeFactorize();
        
//        display();
        
        boolean solved = false;
        int n = 2;
        
        while(n < (MAX_N - ND) && !solved) {
            solved = true;
            
            for (int i = n; i < n + ND; i++) {
                int num = primeFactors[i].size();
                
                if (num < ND) {
                    solved = false;
                    n++;
                    break;
                }
            }
        }
        
        if (solved)
            for (int i = n; i < n + ND; i++)
                display(i);
        else
            System.out.println("Not solved :(");
        
//        int n = 2 * 3 * 5 * 7;
//        boolean solved = false;
//        
//        while (!solved && (n < MAX - 4)) {
//            solved = true;
//            
//            for (int i = n; i < n + 4; i++) {
//                int numPFs = 0;
//                
//                for (int j = 2; j < i; j++) {
//                    if (primeSieve[j] && (i % j) == 0) {
//                        numPFs++;
//                    }
//                }
//                
//                if (numPFs < 4) {
//                    solved = false;
//                    n = i + 1;
//                    break;
//                }
//            }
//        }
//        
//        if (solved)
//            System.out.println(n);
//        else
//            System.out.println("Not solved!");
    }
    
    public static void main(String[] args) {
        new Problem47().solve();
    }
}
