package problems.problem59;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Problem59 {
    
    public static void main(String[] args) throws IOException {
        byte[] message = readFromFile("src/problems/problem59/p059_cipher.txt");
        
        List<Message> decodings = new ArrayList<>();
        List<String> keys = generateKeys();
        
        for (String key : keys) {
            decodings.add(new Message(key, message));
        }
        
        System.out.println(Collections.max(decodings));
    }
    
    private static List<String> generateKeys() {
        List<String> keys = new ArrayList<>();
        
        for (char a = 'a'; a <= 'z'; a++) {
            for (char b = 'a'; b <= 'z'; b++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    keys.add("" + a + b + c);
                }
            }
        }
        
        return keys;
    }
    
    private static byte[] readFromFile(String filename) throws IOException {
        String s = new String(Files.readAllBytes(Paths.get(filename))).trim();
        String[] values = s.split(",");
        
        byte[] message = new byte[values.length];
        for (int i = 0; i < values.length; i++) {
            message[i] = Byte.parseByte(values[i]);
        }
        
        return message;
//        
//        byte[] msg = new byte[] {'h' ^ 'a', 20 ^ 'a', 20 ^ 'a', 'i' ^ 'a'};
//        return msg;
    }
}
