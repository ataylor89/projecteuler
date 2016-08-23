package tests;

import org.junit.Assert;
import org.junit.Test;
import util.ContinuedFraction;
import util.ContinuedFractions;
import util.RunningTime;
import util.SquareRoot;

/**
 *
 * @author ataylor
 */
public class SquareRootTest {
    
//    @Test
    public void testRootTwo() {
        ContinuedFraction expected = ContinuedFractions.squareRootTwo;
        SquareRoot root2 = new SquareRoot(2);
        
        int depth = 10;
        
        for (int i = 0; i < depth; i++)     
            Assert.assertEquals(root2.evaluate(i), expected.evaluate(i));
    }
    
//    @Test
    public void testRepresentations() {
        System.out.println(new SquareRoot(2));
        System.out.println(new SquareRoot(3));
        System.out.println(new SquareRoot(5));
        System.out.println(new SquareRoot(6));
        System.out.println(new SquareRoot(11));
        System.out.println(new SquareRoot(12));
        
        Assert.assertEquals(new SquareRoot(2).toString(), "[1; (2)]");
        Assert.assertEquals(new SquareRoot(3).toString(), "[1; (1, 2)]");
        Assert.assertEquals(new SquareRoot(5).toString(), "[2; (4)]");
        Assert.assertEquals(new SquareRoot(6).toString(), "[2; (2, 4)]");
        Assert.assertEquals(new SquareRoot(11).toString(), "[3; (3, 6)]");
        Assert.assertEquals(new SquareRoot(12).toString(), "[3; (2, 6)]");
    }
    
//    @Test
    public void testPerfectSquares() {
        System.out.println(new SquareRoot(1));
        System.out.println(new SquareRoot(4));
        System.out.println(new SquareRoot(9));
        System.out.println(new SquareRoot(16));
        
        Assert.assertEquals(new SquareRoot(1).toString(), "[1]");
        Assert.assertEquals(new SquareRoot(4).toString(), "[2]");
        Assert.assertEquals(new SquareRoot(9).toString(), "[3]");
        Assert.assertEquals(new SquareRoot(16).toString(), "[4]");
    }
    
    @Test
    public void testManyIterations() {
        long begin = System.currentTimeMillis();
        
        SquareRoot sqrtN = new SquareRoot(61);
        System.out.println("Generated period in " + (System.currentTimeMillis() - begin) + " ms.");
        
        System.out.println(sqrtN.evaluate(5000));
        
        RunningTime.print(begin);
    }
}