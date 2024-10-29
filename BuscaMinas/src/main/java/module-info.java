module co.icesi.buscaminas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens co.icesi.buscaminas to javafx.fxml;
        exports co.icesi.buscaminas;
}