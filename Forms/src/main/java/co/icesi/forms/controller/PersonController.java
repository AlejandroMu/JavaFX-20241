package co.icesi.forms.controller;

import co.icesi.forms.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonController implements Initializable {

    @FXML
    private TableView<Person> table;

    @FXML
    private TableColumn<Person, String> colCode;

    @FXML
    private TableColumn<Person, String> colName;

    private ObservableList<Person> persons;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        persons = FXCollections.observableArrayList();
        table.setItems(persons);

        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        persons.add(new Person("A00049176","Santiago"));

    }
}
