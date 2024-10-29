package co.icesi.formsusers.view;

import co.icesi.formsusers.controllers.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView {

    private LoginController controller;

    public LoginView(){
        controller = new LoginController();
    }

    public Parent load(){
        GridPane pane = new GridPane();

        Label lbCode = new Label("Code:");
        TextField txfCode = new TextField("Write code");

        Label lbPass = new Label("Password:");
        TextField txfpass = new TextField("Write password");

        Button log = new Button("LogIn");
        Button sign = new Button("SignUp");


        log.setOnAction(e->controller.onLoginClick());
        sign.setOnAction(e->controller.onSignClick());

        pane.add(lbCode,0,0);
        pane.add(txfCode,0,1);
        pane.add(lbPass,0,2);
        pane.add(txfpass,0,3);
        pane.add(log,0,4);
        pane.add(sign,0,5);


        return pane;
    }

    public LoginController getController() {
        return controller;
    }
}
