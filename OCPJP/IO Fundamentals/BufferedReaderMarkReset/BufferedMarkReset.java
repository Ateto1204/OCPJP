package build;

import java.io.*;

public class BufferedMarkReset {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            System.out.println("Is markSupported on...");
            String file = System.getProperty("user.dir") + "\\test.txt";
            inputStream = new FileInputStream(file);
            System.out.println("FileInputStream? " + inputStream.markSupported());

            // Create new input stream reader
            inputStreamReader = new InputStreamReader(inputStream);
            System.out.println("InputStreamReader? " + inputStreamReader.markSupported());

            // Create new buffered reader
            bufferedReader = new BufferedReader(inputStreamReader);
            System.out.println("BufferedReader? " + bufferedReader.markSupported());

            System.out.println("---------------------------------------");

            // reads and prints BufferedReader
            System.out.println((char) bufferedReader.read());
            System.out.println((char) bufferedReader.read());

            bufferedReader.mark(99);
            
            System.out.println("mark() invoked");
            System.out.println((char) bufferedReader.read());
            System.out.println((char) bufferedReader.read());

            bufferedReader.reset();

            System.out.println("reset() invoked");
            System.out.println((char) bufferedReader.read());
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if(inputStreamReader != null) {
                inputStreamReader.close();
            }
            if(bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }
}