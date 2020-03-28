package com.example.expendituretracker;

public class DataModel {

    String name;
    String amount;



    public DataModel(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }


}
