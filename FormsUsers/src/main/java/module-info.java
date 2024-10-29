module co.icesi.formsusers {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens co.icesi.formsusers to javafx.fxml;
    opens co.icesi.formsusers.controllers to javafx.fxml;

    exports co.icesi.formsusers;
}