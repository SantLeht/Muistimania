module com.example.muistimania {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.muistimania to javafx.fxml;
    exports com.example.muistimania;
}