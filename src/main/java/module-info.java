module com.sdm {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    opens com.sdm to javafx.fxml;
    exports com.sdm;
    exports com.sdm.snake;
    opens com.sdm.snake to javafx.fxml;
    exports com.sdm.snake.body;
    opens com.sdm.snake.body to javafx.fxml;
}