package build;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ThrowsExceptionDemo {
    private static void readFromFile() throws FileNotFoundException, 
                                                IOException, 
                                                Exception {
        try (InputStream in = new FileInputStream("a.txt")) {

        }
    }

    private static void readFromFile2() throws Exception, 
                                                IOException, 
                                                FileNotFoundException {
        try (InputStream in = new FileInputStream("a.txt")) {

        }
    }
    public static void main(String[] args) {
        try {
            readFromFile();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        try {
            readFromFile2();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
