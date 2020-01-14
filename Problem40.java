package problems;

/**
 *
 * @author ataylor
 */
public class Problem40 {

    public void solve() {
        int product = 1;
        for (int i = 0; i <= 6; i++) {
            int n = (int) Math.pow(10, i);
            product *= d(n);
        }
        
        System.out.println(product);
    }

    public int d(int n) {
        int i = 0, count = 0;
        while (count < n) {
            i++;
            count += String.valueOf(i).length();
        }
        
        String s = String.valueOf(i);
        Character c = s.charAt(s.length() - 1 - (count - n));
        return Integer.parseInt(c.toString());
    }

    public static void main(String[] args) {
        new Problem40().solve();
    }
}
