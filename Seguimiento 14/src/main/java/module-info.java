module com.example.seguimiento14 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seguimiento14 to javafx.fxml;
    exports com.example.seguimiento14;
    exports com.example.seguimiento14.control;
    opens com.example.seguimiento14.control to javafx.fxml;
    exports com.example.seguimiento14.model;
    opens com.example.seguimiento14.model to javafx.fxml;
}