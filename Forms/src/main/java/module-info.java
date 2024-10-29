module co.icesi.forms {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    exports co.icesi.forms;
    exports co.icesi.forms.controller;
    exports co.icesi.forms.model;

    opens co.icesi.forms to javafx.fxml;
    opens co.icesi.forms.controller to javafx.fxml;

}