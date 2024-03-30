package build;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            String s = "";
            while(s != null) {
                s = input.readLine();
                if (s != null) {
                    s = s.trim();
                }
                System.out.println("Read: " + s);
                if (s.equals("abc")) {
                    System.out.println("=== Right answer! Quit! ===");
                    System.exit(0);
                }
            }
            input.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
