package util;

/**
 *
 * @author ataylor
 */
public class RunningTime {
    
    public static void print(long begin) {
        long runningTime = System.currentTimeMillis() - begin;
        
        System.out.println("Execution time: " + runningTime + "ms.");
    }
    
    public static long get(long begin) {
        return System.currentTimeMillis() - begin;
    }
}
