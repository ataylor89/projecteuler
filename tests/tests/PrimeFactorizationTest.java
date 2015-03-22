package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.PrimeFactorization;

/**
 *
 * @author ataylor
 */
public class PrimeFactorizationTest {
    
    public PrimeFactorizationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test() {
        test(10, "2 * 5");
        test(11, "11");
        test(64, "2^6");
        test(2*3*4*5, "2^3 * 3 * 5");
    }
    
    private void test(long number, String expected) {
        PrimeFactorization pf = new PrimeFactorization(number);
        pf.generate(true);
        
        System.out.println(pf);
        Assert.assertEquals(expected, pf.toString());
    }
}