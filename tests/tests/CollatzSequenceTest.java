package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.CollatzSequence;

/**
 *
 * @author ataylor
 */
public class CollatzSequenceTest {
    
    public CollatzSequenceTest() {
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
    public void testKnownSequence() {
        CollatzSequence s = new CollatzSequence(13);
        System.out.println(s);
        
        String expected = "[13, 40, 20, 10, 5, 16, 8, 4, 2, 1]";
        Assert.assertEquals(s.toString(), expected);
    }
}