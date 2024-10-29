package co.icesi.formsusers;

import co.icesi.formsusers.controllers.LoginController;
import co.icesi.formsusers.view.LoginView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static HelloApplication instance;


    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        this.stage = stage;
        instance = this;
        LoginView loginView = new LoginView();
        loginView.getController().setMainStage(this);
        Parent root = loginView.load();
        Scene scene = new Scene(root, 400,200);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public void setScene(Scene sc){
        this.stage.setScene(sc);
        //this.stage.show();
    }
    public void setScene(Parent parent){
        Scene sc = new Scene(parent);
        setScene(sc);
    }
    public void setScene(String file){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(file));
        try {
            Scene sc = new Scene(fxmlLoader.load());
            setScene(sc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        launch();
    }
}