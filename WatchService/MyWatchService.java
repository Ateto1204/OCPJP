package build;

import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class MyWatchService implements Runnable {
    private WatchService myWatcher;
    public MyWatchService(WatchService myWatcher) {
        this.myWatcher = myWatcher;
    }
    @Override
    public void run() {
        try {
            WatchKey key = myWatcher.take();
            while (key != null) {
                for (WatchEvent event : key.pollEvents()) {
                    System.out.printf("Recieve event: %s for file: %s%n", 
                                    event.kind(), event.context());
                }
                key.reset();
                key = myWatcher.take();
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}