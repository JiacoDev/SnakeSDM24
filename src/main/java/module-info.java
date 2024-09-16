module com.sdm {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires java.desktop;

    exports com.sdm.model.snake;
    opens com.sdm.model.snake to javafx.fxml;
    exports com.sdm.model.snake.body;
    opens com.sdm.model.snake.body to javafx.fxml;
    exports com.sdm.model;
    opens com.sdm.model to javafx.fxml;
    exports com.sdm.logic;
    opens com.sdm.logic to javafx.fxml;
    exports com.sdm.view;
    opens com.sdm.view to javafx.fxml;
    exports com.sdm.main;
    opens com.sdm.main to javafx.fxml;
}