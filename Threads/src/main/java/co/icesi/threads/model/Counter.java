package co.icesi.threads.model;

import java.util.concurrent.Semaphore;

public class Counter {

    private Semaphore semaphore = new Semaphore(1);
    private int count;

    public void acquire() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void release() {
        semaphore.release();
    }

    public int getCount() {

        return count;
    }

    public void setCount(int count) {

        this.count = count;
    }

}
