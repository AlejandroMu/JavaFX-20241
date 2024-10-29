package co.icesi.hwjavafx.controller;

import co.icesi.hwjavafx.model.ClassRoom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField textCode;

    @FXML
    private TextField textPass;

    @FXML
    private Button btnLog;

    @FXML
    void loginAction(ActionEvent event) {
        String code = textCode.getText();
        String password = textPass.getText();
        ClassRoom clas = ClassRoom.getInstance();
        boolean log = clas.login(code, password);
        String message = log ? "Successfull":"Failed";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);

        alert.showAndWait();
    }

}
