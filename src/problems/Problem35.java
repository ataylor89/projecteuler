package problems;

/**
 *
 * @author ataylor
 */
public class Problem35 {

    public static void main(String[] args) {
        int max = 1000000;
        Library.generatePrimes(max);
        
        System.out.println("Finished filling sieve");
        int count = 0;
        
        for (int i = 1; i < max; i++) {
            if (Library.isCircularPrime(i)) {
                System.out.println(i + " is a circular prime " + Library.rotations(i));
                count++;
            }
        }
        System.out.println(count);
    }
}
