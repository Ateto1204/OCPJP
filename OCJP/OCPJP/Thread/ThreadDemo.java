package build;

import build.ExampleRunnable;
import build.ExampleThread;

public class ThreadDemo {
    public static void main(String[] args) {
        ThreadDemo main = new ThreadDemo();
        main.threadDemo();
        main.runnableDemo();
    }

    private void threadDemo() {
        ExampleThread thread = new ExampleThread();
        thread.start();
    }

    private void runnableDemo() {
        ExampleRunnable runnable = new ExampleRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
