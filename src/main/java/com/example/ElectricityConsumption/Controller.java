package com.example.ElectricityConsumption;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class Controller {

    @FXML
    private Label calculatedLabel;

    @FXML
    private TextField pricePerMWhTextField;

    @FXML
    private TextField deviceConsumptionTextField;

    @FXML
    private Button calculateButton;

    @FXML
    protected void onButtonClick() {
        ElectricityConsumption obj = new ElectricityConsumption();
        String pricePerMWhText = pricePerMWhTextField.getText();
        String deviceConsumptionText = deviceConsumptionTextField.getText();

        if (pricePerMWhText.isEmpty() || deviceConsumptionText.isEmpty()) {
            calculatedLabel.setText("Vyplňte obě pole prosím.");
        } else {
            try {
                calculatedLabel.setText(obj.toString(Double.parseDouble(pricePerMWhText),
                        Double.parseDouble(deviceConsumptionText)));
            } catch (NumberFormatException e) {
                calculatedLabel.setText("Pouze čísla. (desetinná místa odděl tečkou)");
            }
        }
    }

    @FXML
    public void initialize() {
        // Inicializace tlačítka s animací
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), calculateButton);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(0.9);
        scaleTransition.setToY(0.9);

        calculateButton.setOnMouseReleased(event -> {
            scaleTransition.setFromX(0.9);
            scaleTransition.setFromY(0.9);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
            onButtonClick();
        });
    }
}
