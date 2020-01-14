package util;

/**
 *
 * @author ataylor
 */
public class ContinuedFractions {
    
    public static ContinuedFraction squareRootTwo;
    public static ContinuedFraction eulersNumber;
    
    static {
        squareRootTwo = new SquareRootTwo();
        eulersNumber = new EulersNumber();
    }        
    
    private static class SquareRootTwo extends ContinuedFraction {
        @Override
        public int getA(int n) {
            return (n > 0) ? 2 : 1;
        }

        @Override
        public int getB(int n) {
            return 1;
        }
    }
    
    private static class EulersNumber extends ContinuedFraction {
        @Override
        public int getA(int n) {
            if (n == 0)
                return 2;
            
            if ((n - 2) % 3 != 0) 
                return 1;
            
            int j = (n - 2) / 3;
            return 2 * (j+1);
        }
        
        @Override
        public int getB(int n) {
            return 1;
        }
    }
}
