package co.icesi.formsusers.controllers;

import co.icesi.formsusers.HelloApplication;
import co.icesi.formsusers.HelloController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController{


    private HelloApplication mainStage;

    public void setMainStage(HelloApplication mainStage) {
        this.mainStage = mainStage;
    }


    public void loadNewScene(Parent parent){
            Scene sc = new Scene(parent);
            mainStage.setScene(sc);
    }
    public void onLoginClick(){
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/co/icesi/formsusers/view/hello-view.fxml"));
        try {
            loadNewScene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onSignClick(){
        FXMLLoader fxmlLoader = new FXMLLoader(SignUpController.class.getResource("/co/icesi/formsusers/view/SignUp.fxml"));
        try {
            loadNewScene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
