package build;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CopyCharStream {
    public static void main(String[] args) {
        String source = "inputDemo.txt";
        String target = "outputDemo.txt";
        char[] chars = new char[128];
        int charLength = chars.length;

        try (FileReader fileReader = new FileReader(source); 
            FileWriter fileWriter = new FileWriter(target)) {
            int read = 0;
            while ((read = fileReader.read(chars)) != -1) {
                if (read < charLength) {
                    fileWriter.write(chars, 0, read);
                } else {
                    fileWriter.write(chars);
                }
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
