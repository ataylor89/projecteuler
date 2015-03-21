/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import util.SieveOfEratosthenes;

/**
 *
 * @author ataylor
 */
public class SerializableSieve extends SieveOfEratosthenes implements Serializable {
    
    public SerializableSieve(int size) {
        super(size);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof SieveOfEratosthenes) {
            SieveOfEratosthenes other = (SieveOfEratosthenes) o;
            
            if (size() != other.size())
                return false;
            
            for (int n = 0; n < size(); n++)
                if (isPrime(n) != other.isPrime(n))
                    return false;
            
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return sieve.length;
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        List<Integer> primes = this.getPrimes();
        
        int[] arr = new int[primes.size()];
        
        for (int i = 0; i < arr.length; i++) 
            arr[i] = primes.get(i);
        
        
        out.writeInt(sieve.length);
        out.writeObject(primes);
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        int size = in.readInt();
        
        List<Integer> primes = (List<Integer>) in.readObject();
        
        sieve = new boolean[size];
        Arrays.fill(sieve, false);
        
        for (int p : primes)
            sieve[p] = true;
    }
    
    public static SerializableSieve from(String path) {
        long begin = System.currentTimeMillis();
        SerializableSieve sieve = null;
        
        try (FileInputStream fileIn = new FileInputStream(path); 
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            
            sieve = (SerializableSieve) in.readObject();
            System.out.printf("Deserialized in %d ms.%n", System.currentTimeMillis() - begin);
        }
        catch(IOException ex) {
            System.out.println(ex);
        } catch(ClassNotFoundException c) {
           System.out.println("SerializableSieve class not found");
           System.out.println(c);
        }
        
        return sieve;
    }
}
