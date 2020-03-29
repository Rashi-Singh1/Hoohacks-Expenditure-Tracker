package com.example.expendituretracker;
public class expense {
    private float amount;
    private String category;
    private String desc;
    private boolean debit_or_credit;
    private int date_time;

    public expense(){}

    public expense(float amount, String category, String desc, boolean debit_or_credit, int date_time) {
        this.amount = amount;
        this.category = category;
        this.desc = desc;
        this.debit_or_credit = debit_or_credit;
        this.date_time = date_time;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isDebit_or_credit() {
        return debit_or_credit;
    }

    public void setDebit_or_credit(boolean debit_or_credit) {
        this.debit_or_credit = debit_or_credit;
    }

    public int getDate_time() {
        return date_time;
    }

    public void setDate_time(int date_time) {
        this.date_time = date_time;
    }
}
