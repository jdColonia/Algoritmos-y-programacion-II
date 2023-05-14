package com.example.seguimiento14.model;

import java.time.LocalDate;
import java.util.Objects;

public class Records {

    private double amount;
    private String description;
    private RecordsType type;
    private LocalDate date;

    public Records(double amount, String description, RecordsType type, LocalDate date) {
        if (type == RecordsType.INGRESO) {
            this.amount = amount;
        } else {
            this.amount = amount * (-1);
        }
        this.description = description;
        this.type = type;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RecordsType getType() {
        return type;
    }

    public void setType(RecordsType type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object otroObjeto) {
        if (this == otroObjeto) {
            return true;
        }

        if (otroObjeto == null || getClass() != otroObjeto.getClass()) {
            return false;
        }

        Records otroRecord = (Records) otroObjeto;

        return Double.compare(otroRecord.amount, amount) == 0 &&
                Objects.equals(description, otroRecord.description) &&
                type == otroRecord.type &&
                Objects.equals(date, otroRecord.date);
    }

}
