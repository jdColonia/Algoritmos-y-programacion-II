package com.example.seguimiento14.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class RecordsList {

    // Global
    private ObservableList<Records> records = FXCollections.observableArrayList();
    private ArrayList<Records> recordsAdded = new ArrayList<>();

    // Constructor privado
    private RecordsList() {

    }

    private static RecordsList instance = null;

    public static RecordsList getInstance() {
        if (instance == null) {
            instance = new RecordsList();
        }
        return instance;
    }

    public ObservableList<Records> getRecords() {
        return records;
    }

    public void setRecords(ObservableList<Records> records) {
        this.records = records;
    }

    public ArrayList<Records> getRecordsAdded() {
        return recordsAdded;
    }

    public void setRecordsAdded(ArrayList<Records> recordsAdded) {
        this.recordsAdded = recordsAdded;
    }

}
