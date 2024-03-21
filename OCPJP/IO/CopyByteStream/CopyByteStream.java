package build;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CopyByteStream {
    public static void main(String[] args) {
        String source = "inputDemo.txt";
        String target = "outputDemo.txt";
        byte[] bytes = new byte[128];
        int byteLength = bytes.length;
        try (FileInputStream fileInputStream = new FileInputStream(source); 
            FileOutputStream fileOutputStream = new FileOutputStream(target)) {
            System.out.println("Will copy bytes: " + fileInputStream.available());
            int read = 0;
            while ((read = fileInputStream.read(bytes)) != -1) {
                if (read < byteLength) {
                    fileOutputStream.write(bytes, 0, read);
                } else {
                    fileOutputStream.write(bytes);
                }
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}