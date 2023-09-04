module com.example.backend_utvikling {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.backend_utvikling to javafx.fxml;
    exports com.example.backend_utvikling;
}