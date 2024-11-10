package org.example.fuelconsumption;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.ResourceBundle;

public class ControllerClass {

    @FXML
    private Label distanceLabel;

    @FXML
    private TextField distanceInput;

    @FXML
    private Label fuelLabel;

    @FXML
    private TextField fuelInput;

    @FXML
    private Button calculateButton;

    @FXML
    private Label resultLabel;

    private ResourceBundle bundle;

    // Method to load the resource bundle based on the language code
    private ResourceBundle getBundle(String languageCode) {
        return ResourceBundle.getBundle("org.example.fuelconsumption.message", new Locale(languageCode));
    }

    // Method to apply localization based on the selected language
    private void applyLocalization(String languageCode) {
        this.bundle = getBundle(languageCode);

        distanceLabel.setText(bundle.getString("distance.label"));
        fuelLabel.setText(bundle.getString("fuel.label"));
        calculateButton.setText(bundle.getString("calculate.button"));
        resultLabel.setText(bundle.getString("result.label"));
    }

    // Initialize the default language (e.g., English)
    @FXML
    public void initialize() {
        applyLocalization("en"); // Default to English
    }

    // Method for calculating fuel consumption
    @FXML
    private void calculateFuelConsumption() {
        try {
            double distance = Double.parseDouble(distanceInput.getText());
            double fuel = Double.parseDouble(fuelInput.getText());
            double consumption = (fuel / distance) * 100;
            resultLabel.setText(String.format(bundle.getString("result.label"), consumption));
        } catch (NumberFormatException e) {
            resultLabel.setText(bundle.getString("invalid.input"));
        }
    }

    // Language Selection Methods
    @FXML
    private void setEnglish() {
        applyLocalization("en");
    }

    @FXML
    private void setFrench() {
        applyLocalization("fr");
    }

    @FXML
    private void setJapanese() {
        applyLocalization("jp");
    }

    @FXML
    private void setPersian() {
        applyLocalization("ir");
    }
}
