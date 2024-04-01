package build;

import java.io.File;
import java.io.IOException;


public class MultiCatchDemo {
    public static void main(String[] args) {
        mutiCatch();
    }

    private static void mutiCatch() {
        try {
            createTempFile();
        } catch (IOException 
                | IllegalArgumentException
                | ArrayIndexOutOfBoundsException
                | SecurityException exception) {
            System.out.println("Known Exception: " + exception.getClass());
        } catch (Exception exception) {
            System.out.println("Unknown Exception: " + exception.getClass() + " is caught!");
        }
    }

    private static void createTempFile() throws IOException {
        String path = System.getProperty("user.dir");
        System.out.println(path);
        File file = new File(path);
        File tempFile = File.createTempFile("temp", ".txt", file);
        System.out.println("Temp file name: " + tempFile.getPath());
        tempFile.deleteOnExit();
        int arr[] = new int[5];
        arr[5] = 25;
    }
}
