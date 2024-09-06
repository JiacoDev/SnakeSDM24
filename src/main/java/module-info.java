module com.sdm.snakesdm24 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.sdm.snakesdm24 to javafx.fxml;
    exports com.sdm.snakesdm24;
}