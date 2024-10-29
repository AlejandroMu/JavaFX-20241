package co.icesi.buscaminas;

import co.icesi.buscaminas.model.BoardGame;
import co.icesi.buscaminas.model.Clock;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 440);
        stage.setTitle("Hello!");
        HelloController c =(HelloController)fxmlLoader.getController();
        Clock clock = new Clock();
        clock.start();
        c.setClock(clock);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
/*
        BoardGame bg = new BoardGame();
        int mines = bg.initGame(8,8,10);
        System.out.println("LandMines on the table: "+mines);
//        bg.showAll(true);
//        bg.printBoard();
//        bg.showAll(false);
        bg.printBoard();
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        do{
            try {
                boolean r = bg.selectCell(i, j);
                if (r) {
                    System.out.println("you win, Congratulations");
                    break;
                }
                bg.printBoard();
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
                break;
            }
            i = scanner.nextInt();
            j = scanner.nextInt();
        }while (i>=0 && j>=0);
        bg.showAll(true);
        bg.printBoard();
        System.out.println("exit");
*/
    }
}