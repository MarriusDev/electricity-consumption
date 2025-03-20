module com.example.ElectricityConsumption {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ElectricityConsumption to javafx.fxml;
    exports com.example.ElectricityConsumption;
}