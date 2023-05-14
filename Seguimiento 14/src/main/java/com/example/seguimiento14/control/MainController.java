package com.example.seguimiento14.control;

import com.example.seguimiento14.Main;
import com.example.seguimiento14.model.Records;
import com.example.seguimiento14.model.RecordsList;
import com.example.seguimiento14.model.RecordsType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TextField amountTF;

    @FXML
    private DatePicker dateDP;

    @FXML
    private TextField descriptionTF;

    @FXML
    private Button showAccountBTN;

    @FXML
    private ComboBox<RecordsType> typeCB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Condiciones iniciales
        ObservableList<RecordsType> list = FXCollections.observableArrayList(RecordsType.GASTO, RecordsType.INGRESO);
        typeCB.setItems(list);
    }

    @FXML
    public void addRecord(ActionEvent event) {
        String amount = amountTF.getText();
        String description = descriptionTF.getText();
        RecordsType selectedType = typeCB.getSelectionModel().getSelectedItem();
        LocalDate selectedDate = dateDP.getValue();

        if (amount.isEmpty() || description.isEmpty() || selectedType == null || selectedDate == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setTitle("Alerta");
            alert.setContentText("No ha sido posible añadir el registro. Por favor, completa todos los campos obligatorios.");
            alert.showAndWait();
        } else {
            try {
                Records newRecord = new Records(Double.parseDouble(amount), description, selectedType, selectedDate);
                RecordsList.getInstance().getRecords().add(newRecord);
                RecordsList.getInstance().getRecordsAdded().add(newRecord);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Éxito");
                alert.setTitle("Alerta");
                alert.setContentText("Registro exitoso.");
                alert.showAndWait();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error");
                alert.setTitle("Alerta");
                alert.setContentText("No ha sido posible añadir el registro. Por favor, ingresa un valor numérico válido para el monto.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void deleteRecord(ActionEvent event) {
        String amount = amountTF.getText();
        String description = descriptionTF.getText();
        RecordsType selectedType = typeCB.getSelectionModel().getSelectedItem();
        LocalDate selectedDate = dateDP.getValue();

        if (amount.isEmpty() || description.isEmpty() || selectedType == null || selectedDate == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setTitle("Alerta");
            alert.setContentText("No ha sido posible eliminar el registro. Por favor, completa todos los campos obligatorios.");
            alert.showAndWait();
        } else {
            try {
                Records recordToRemove = new Records(Double.parseDouble(amount), description, selectedType, selectedDate);
                if (RecordsList.getInstance().getRecords().contains(recordToRemove)) {
                    RecordsList.getInstance().getRecords().remove(recordToRemove);
                    RecordsList.getInstance().getRecordsAdded().remove(recordToRemove);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Éxito");
                    alert.setTitle("Alerta");
                    alert.setContentText("Eliminación exitosa.");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Error");
                    alert.setTitle("Alerta");
                    alert.setContentText("Eliminación fallida.");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error");
                alert.setTitle("Alerta");
                alert.setContentText("No ha sido posible eliminar el registro. Por favor, completa todos los campos obligatorios. ");
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void showAccount(ActionEvent event) {
        Stage stage = (Stage) this.showAccountBTN.getScene().getWindow();
        stage.close();
        Main.openWindow("account-view.fxml");
    }

}
