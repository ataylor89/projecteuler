package tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ataylor
 */
public class SerializeSieveTest {
    
    private SerializableSieve sieve1, sieve2;
    private String path = "tests/tests/sieve.ser";
    
    public SerializeSieveTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.sieve1 = new SerializableSieve(1000);
        sieve1.generate(true);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void serialize() {
        long begin = System.currentTimeMillis();
        
        try (FileOutputStream fileOut = new FileOutputStream(path); 
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            
            out.writeObject(sieve1);
            System.out.printf("Serialized in %d ms (%s).%n", System.currentTimeMillis() - begin, path);
        } catch (IOException ex) {
           System.out.println(ex);
        }
    }
    
    @Test
    public void deserialize() {        
        long begin = System.currentTimeMillis();
        
        try (FileInputStream fileIn = new FileInputStream(path); 
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            
            sieve2 = (SerializableSieve) in.readObject();
            System.out.printf("Deserialized in %d ms.%n", System.currentTimeMillis() - begin);
        }
        catch(IOException ex) {
            System.out.println(ex);
        } catch(ClassNotFoundException c) {
           System.out.println("SerializableSieve class not found");
           System.out.println(c);
        }
        
        Assert.assertEquals(sieve1, sieve2);
    }
}