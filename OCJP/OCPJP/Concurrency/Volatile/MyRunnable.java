package build;

public class MyRunnable implements Runnable {
    public volatile boolean running = true;
    
    @Override
    public void run() {
        System.out.println("Thread started");
        while (running) {
            System.out.println("running...");
        }
        System.out.println("Thread finish");
    }
}