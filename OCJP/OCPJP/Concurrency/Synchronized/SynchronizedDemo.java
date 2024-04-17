package build;

import java.util.Date;

public class SynchronizedDemo {
    public static void main(String[] args) {
        SynchronizedAll o = new SynchronizedAll();
        System.out.println("Start main at: " + new Date());
        Thread method1 = new Method1Runner(o);
        method1.start();
        Thread method2 = new Method2Runner(o);
        method2.start();
        System.out.println("End main at: " + new Date());
    }
}

class SynchronizedAll {
    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
    public synchronized void method1() {
        sleep();
        System.out.println("-- Run method1() at: " + new Date());
    }
    public synchronized void method2() {
        sleep();
        System.out.println("-- Run method2() at: " + new Date());
    }
}

class Method1Runner extends Thread {
    SynchronizedAll o;
    public Method1Runner(SynchronizedAll o) {
        this.o = o;
    }
    public void run() {
        o.method1();
    }
}

class Method2Runner extends Thread {
    SynchronizedAll o;
    public Method2Runner(SynchronizedAll o) {
        this.o = o;
    }
    public void run() {
        o.method2();
    }
}