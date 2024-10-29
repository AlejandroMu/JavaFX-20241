package co.icesi.threads.model;

public class CounterThread extends Thread{
    private Counter counter;
    private int step;


    public CounterThread(Counter c, int step){
        counter =c;
        this.step = step;
    }
    @Override
    public void run() {
        try {
            counter.acquire();

            int tmp = counter.getCount();
            Thread.sleep(100);
            tmp += step;
            counter.setCount(tmp);
            counter.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {

        }

    }
}
