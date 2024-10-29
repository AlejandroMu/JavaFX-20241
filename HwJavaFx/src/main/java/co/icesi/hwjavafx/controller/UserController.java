package co.icesi.hwjavafx.controller;

import co.icesi.hwjavafx.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML
    private TableView<User> tableId;

    @FXML
    private TableColumn<User, String> codeCol;

    @FXML
    private TableColumn<User, String> nameCol;

    @FXML
    private Button btnUser;

    private ObservableList<User> users;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        users = FXCollections.observableArrayList();

        tableId.setItems(users);

        codeCol.setCellValueFactory(new PropertyValueFactory<>("code"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));


    }
    @FXML
    void addUser(ActionEvent event) {
//        users.add(new User("Code","Name"));
    }
}
