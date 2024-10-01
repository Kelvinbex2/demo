package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {
    private final static String MSG_ERR="Introduzca un numero";
    private final static String MSG_ERR2="Error de entradad";
    private final static String MSG_TITULO1="Calculadora";
    private final static String MSG_TITULO2="Tienes %s anios.";
    private final static String MSG_ERR3="No  puedes tener  un anio  %s .";




    @FXML
    private Button btnCal;

    @FXML
    private TextField txtAct; 

    @FXML
    private TextField txtNac; 

    @FXML
    void calcularAnio(ActionEvent event) {
        try {
            
            int anioAct = Integer.parseInt(txtAct.getText());
            int anioNac = Integer.parseInt(txtNac.getText());

            
            int anio = calcular(anioAct, anioNac);
            if (anio < 0) {
                String msg1 = String.format(MSG_ERR3, anio);
                showErrorAlert(msg1);
            }else{
                showAlert(anio);
            }

            
            
        } catch (NumberFormatException e) {
            
            showErrorAlert(MSG_ERR);
        }
    }

    public int calcular(int anioAct, int anioNac) {
         return anioAct - anioNac;
    }

    private void showAlert(int age) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String msg = String.format(MSG_TITULO2,age);
        alert.setTitle(MSG_TITULO1);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void showErrorAlert(String message) {
        // Create an alert for error messages
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(MSG_ERR2);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
