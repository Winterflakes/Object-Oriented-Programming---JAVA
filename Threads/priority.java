package Threads;

class threadp implements Runnable {
    long count = 0;
    private volatile boolean running = true;
    Thread t;

    public threadp(int p) {
        t = new Thread(this, "Tno." + p);
        t.setPriority(p);
    }

    public void run() {
        System.out.println("execution of thread " + t.getName());
        while (running) {
            count++;
        }
        System.out.println("thread " + t.getName() + "count " + count);
    }

    void startthread() throws InterruptedException {
        System.out.println("thread priority is " + t.getPriority());
        t.start();
    }

    void stopthread() {
        running = false;
    }
}

public class priority {
    public static void main(String a[]) throws InterruptedException {
        Thread.currentThread().setPriority(5);
        threadp t1, t2;
        t1 = new threadp(Thread.MAX_PRIORITY);
        t2 = new threadp(5);
        t2.startthread();
        t1.startthread();
        Thread.sleep(100);
        t1.stopthread();
        t2.stopthread();
        System.out.println("high priority: " + t1.count);
        System.out.println("low priority: " + t2.count);
    }
}
