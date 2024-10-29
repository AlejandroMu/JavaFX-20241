package co.icesi.formsusers.controllers;

import co.icesi.formsusers.HelloApplication;
import co.icesi.formsusers.model.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtLast;

    @FXML
    private TextField textName;

    @FXML
    void signUp(ActionEvent event) {

        String code = txtCode.getText();
        String name = textName.getText();
        String lastName = txtLast.getText();
        String password = txtPassword.getText();
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Insert new User failed");

        try {
            a.setAlertType(Alert.AlertType.INFORMATION);
            UserService.getInstance().addUser(code,password,name,lastName);
            a.setContentText("Successful");
        } catch (Exception e) {
            a.setContentText(e.getMessage());
        }
        a.showAndWait();
        HelloApplication.instance.setScene("/co/icesi/formsusers/view/SignUp.fxml");

    }

}
