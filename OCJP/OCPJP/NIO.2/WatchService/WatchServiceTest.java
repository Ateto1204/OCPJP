package build;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchService;
import static java.nio.file.StandardWatchEventKinds.*;

public class WatchServiceTest {
    final static String DIRECTORY_TO_WATCH = "/Users/ateto/Desktop/Project/OCPJP/WatchService/";
    public static void main(String[] args) throws Exception {
        Path watchPath = Paths.get(DIRECTORY_TO_WATCH);
        if (Files.exists(watchPath) == false) {
            Files.createDirectories(watchPath);
        }

        WatchService myWatcher = watchPath.getFileSystem().newWatchService();
        MyWatchService fileWatcher = new MyWatchService(myWatcher);

        Thread thread = new Thread(fileWatcher);
        thread.start();

        watchPath.register(myWatcher, 
                        ENTRY_CREATE, 
                        ENTRY_MODIFY, 
                        ENTRY_DELETE);

        thread.join();
    }
}
