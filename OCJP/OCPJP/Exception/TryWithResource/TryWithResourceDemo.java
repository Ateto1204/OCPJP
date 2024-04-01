package build;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResourceDemo {
    public static void main(String[] args) {
        System.out.println("Opening a file...");
        try (InputStream in = new FileInputStream("lostFile.txt")) {
            System.out.println("File is opened");
            int data = in.read();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
