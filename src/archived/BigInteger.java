package archived;

/**
 *
 * @author ataylor
 */
public class BigInteger {
    
    public static final BigInteger ZERO;
    public static final BigInteger ONE;
    
    static {
        ZERO = new BigInteger("0");
        ONE = new BigInteger("1");
    }
    
    private String s;
    
    public BigInteger(String s) {
        this.s = s;
    }
    
    public BigInteger add(BigInteger num) {
        String s2 = num.toString();
        
        int N1 = s.toString().length();
        int N2 = s2.toString().length();
        
        String result = "";
        int carry = 0;
        
        for (int i = 0; i < ((N1>N2)?N1:N2); i++) {
            int a = 0, b = 0;
            
            if (i < N1)
                a = Integer.parseInt(s.substring(N1-i-1, N1-i));
            
            if (i < N2)
                b = Integer.parseInt(s2.substring(N2-i-1, N2-i));
            
            int sum = a + b + carry;
            int digit = sum % 10;
            
            result = digit + result;
            
            carry = sum/10;
        }
        
        if (carry > 0)
            result = carry + result;
        
        return new BigInteger(result);
    }
    
    public BigInteger multiply(long val) {
        BigInteger sum = BigInteger.ZERO;
        
        for (int i = 0; i < val; i++) 
            sum = sum.add(this);
        
        return sum;
    }
    
    public BigInteger multiply(BigInteger n) {
        return multiply(n.longValue());
    }
    
    public BigInteger pow(int exp) {
        BigInteger product = BigInteger.ONE;
        long base = longValue();
        
        for (int i = 0; i < exp; i++)
            product = product.multiply(base);
        
        return product;
    }
    
    public long longValue() {
        return Long.parseLong(s);
    }
    
    public static BigInteger valueOf(long val) {
        return new BigInteger(String.valueOf(val));
    }
    
    @Override
    public String toString() {
        return s;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof BigInteger) {
            BigInteger num = (BigInteger) o;
            
            return s.equals(num.toString());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return s.hashCode();
    }
}
