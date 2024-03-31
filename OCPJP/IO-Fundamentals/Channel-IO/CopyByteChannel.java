package build;

// java.nio
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;

// java.io
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CopyByteChannel {
    public static void main(String[] args) {
        String source = "input.txt";
        String target = "output.txt";
        try (FileChannel input = new FileInputStream(source).getChannel(); 
            FileChannel output = new FileOutputStream(target).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate((int)input.size());
            input.read(buffer);
            buffer.position(0);
            output.write(buffer);
            System.out.println("Completed!");
            input.close();
            output.close();
        } catch(FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}