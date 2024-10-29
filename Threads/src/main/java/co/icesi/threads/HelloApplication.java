package co.icesi.threads;

import co.icesi.threads.model.Counter;
import co.icesi.threads.model.CounterThread;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /**FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    **/
        List<CounterThread> tre = new ArrayList<>();
        Counter counter = new Counter();
        for (int i = 1; i <= 100; i++) {
            CounterThread a = new CounterThread(counter,i);
            tre.add(a);
            a.start();
        }
        for (CounterThread a : tre) {
            try {
                a.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(counter.getCount());
    }

    public static void main(String[] args) {
        launch();
    }
}