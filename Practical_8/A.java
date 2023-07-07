package Practical_8;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class A {
    public static void main(String[] args) {
        CricketWebsite website = new CricketWebsite();
        ServerThread serverThread = new ServerThread(website);
        ClientThread clientThread1 = new ClientThread(website);
        ClientThread clientThread2 = new ClientThread(website);

        serverThread.start();
        clientThread1.start();
        clientThread2.start();
    }
}

class CricketWebsite {
    private String liveScore;
    private final ReentrantReadWriteLock lock;

    public CricketWebsite() {
        liveScore = "No score available";
        lock = new ReentrantReadWriteLock();
    }

    public void updateScore(String score) {
        lock.writeLock().lock();
        try {
            liveScore = score;
            System.out.println("Updated score: " + score);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public String readScore() {
        lock.readLock().lock();
        try {
            return liveScore;
        } finally {
            lock.readLock().unlock();
        }
    }
}

class ServerThread extends Thread {
    private final CricketWebsite website;

    public ServerThread(CricketWebsite website) {
        this.website = website;
    }

    @Override
    public void run() {
        try {
            // Simulating score updates every 2 seconds
            for (int i = 1; i <= 5; i++) {
                String score = "Score " + i;
                website.updateScore(score);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ClientThread extends Thread {
    private final CricketWebsite website;

    public ClientThread(CricketWebsite website) {
        this.website = website;
    }

    @Override
    public void run() {
        try {
            // Simulating clients reading the score every 1 second
            for (int i = 1; i <= 5; i++) {
                String score = website.readScore();
                System.out.println("Client " + getId() + " - Current score: " + score);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


