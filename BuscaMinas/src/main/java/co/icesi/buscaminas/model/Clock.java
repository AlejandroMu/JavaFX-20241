package co.icesi.buscaminas.model;

import java.util.ArrayList;
import java.util.List;

public class Clock extends Thread implements ClockSubject{

    private List<ClockObserver> observers;
    private short seconds;
    private short minutes;

    public Clock(){
        observers = new ArrayList<>();
    }
    public void run(){
        while (true){
            try {
                seconds +=1;
                minutes = (short)(seconds/60);
                notifyObservers();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void registerObserver(ClockObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(){
        for(ClockObserver o: observers){
            o.updateClock(minutes,(short)(seconds%60));
        }
    }
}
