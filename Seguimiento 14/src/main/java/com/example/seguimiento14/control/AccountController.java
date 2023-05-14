package com.example.seguimiento14.control;

import com.example.seguimiento14.Main;
import com.example.seguimiento14.model.Records;
import com.example.seguimiento14.model.RecordsList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Comparator;
import java.util.Date;
import java.util.ResourceBundle;

public class AccountController implements Initializable {

    @FXML
    private TableView<Records> recordsTable;

    @FXML
    private TableColumn<Records, Integer> amountTC;

    @FXML
    private TableColumn<Records, Date> dateTC;

    @FXML
    private TableColumn<Records, String> descriptionTC;

    @FXML
    private Label balance;

    @FXML
    private Button backBTN;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        descriptionTC.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));

        showExpensesAndIncome(null);
    }

    @FXML
    public void reloadBalance(ActionEvent event) {
        double balance = 0, expenses = 0, income = 0;
        for (Records record : RecordsList.getInstance().getRecords()) {
            double amount = record.getAmount();
            if (amount < 0) {
                expenses += amount;
            } else {
                income += amount;
            }
        }
        balance = income + expenses;
        this.balance.setText(" Balance: $" + balance);
    }

    @FXML
    public void showExpenses(ActionEvent event) {
        ObservableList<Records> expensesList = FXCollections.observableArrayList();
        for (Records record : RecordsList.getInstance().getRecords()) {
            if (record.getAmount() < 0) {
                expensesList.add(record);
            }
        }
        Comparator<Records> byDate = (d1, d2) -> d2.getDate().compareTo(d1.getDate());
        expensesList.sort(byDate);
        recordsTable.setItems(expensesList);
    }

    @FXML
    public void showIncome(ActionEvent event) {
        ObservableList<Records> incomeList = FXCollections.observableArrayList();
        for (Records record : RecordsList.getInstance().getRecords()) {
            if (record.getAmount() > 0) {
                incomeList.add(record);
            }
        }
        Comparator<Records> byDate = (d1, d2) -> d2.getDate().compareTo(d1.getDate());
        incomeList.sort(byDate);
        recordsTable.setItems(incomeList);
    }

    @FXML
    public void showExpensesAndIncome(ActionEvent event) {
        ObservableList<Records> records = RecordsList.getInstance().getRecords();
        Comparator<Records> byDate = (d1, d2) -> d2.getDate().compareTo(d1.getDate());
        records.sort(byDate);
        recordsTable.setItems(records);
    }

    @FXML
    public void showMain(ActionEvent event) {
        Stage stage = (Stage) this.backBTN.getScene().getWindow();
        stage.close();
        Main.openWindow("main-view.fxml");
    }

}
