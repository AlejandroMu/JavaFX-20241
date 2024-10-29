module co.icesi.hwjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens co.icesi.hwjavafx to javafx.fxml;
    opens co.icesi.hwjavafx.controller to javafx.fxml;

    exports co.icesi.hwjavafx;
    exports co.icesi.hwjavafx.controller;
    exports co.icesi.hwjavafx.model;

}