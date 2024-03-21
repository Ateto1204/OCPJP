package build;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CopyBufferedStream {
    public static void main(String[] args) {
        String source = "inputDemo.txt";
        String target = "outputDemo.txt";
        try (BufferedReader input = new BufferedReader(new FileReader(source)); 
            BufferedWriter output = new BufferedWriter(new FileWriter(target))) {
            String line = "";
            while ((line = input.readLine()) != null) {
                output.write(line);
                output.newLine();
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
