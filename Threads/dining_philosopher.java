package Threads;

class Table {
    private boolean[] usedFork;

    public Table(int numberForks) {
        usedFork = new boolean[numberForks];
        for (int i = 0; i < usedFork.length; i++)
            usedFork[i] = false;
    }

    private int left(int i) {
        return i;
    }

    private int right(int i) {
        return ((i + 1) % usedFork.length);
    }

    public synchronized void takeForks(int place) {
        while (usedFork[left(place)] || usedFork[right(place)]) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        usedFork[left(place)] = true;
        usedFork[right(place)] = true;
    }

    public synchronized void putBackForks(int place) {
        usedFork[left(place)] = false;
        usedFork[right(place)] = false;
        notifyAll();
    }
} // table

class Philosoph extends Thread {
    private Table Table;// shared memory
    private int place;

    public Philosoph(Table Table, int place) {
        this.Table = Table;
        this.place = place;
        start();
    }

    public void run() { // life of a philosopher
        while (true) {
            thinking(place);
            Table.takeForks(place);
            eating(place);
            Table.putBackForks(place);
        }
    }

    private void thinking(int place) {
        System.out.println("Philosoph " + place + " thinking.");
        try {
            sleep((int) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eating(int place) {
        System.out.println("Philosoph " + place + " starts eating.");
        try {
            sleep((int) (Math.random() * 20000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Philosoph " + place + " finished eating.");
    }
}

class Philosophers {
    private static final int numberPhilisophers = 5;
    private static final int numberForks = 5;

    public static void main(String[] args) {
        Table Table = new Table(numberForks);
        for (int i = 0; i < numberPhilisophers; i++)
            new Philosoph(Table, i);
    }
}
