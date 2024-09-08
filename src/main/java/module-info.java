module com.sdm.snake {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    opens com.sdm.snake to javafx.fxml;
    exports com.sdm.snake;
}