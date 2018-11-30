package com.example.socratis.symbols;

import android.widget.Button;

public class Reservation {

    private String name;
    private int numOfPeople;
    private int rTableNumber;
    private Button tableButton;
    private String comments;

    public Reservation(int rTableNumber, String name, int numOfPeople, Button tableButton){
        this.tableButton = tableButton;
        this.rTableNumber = rTableNumber;
        this.name = name;
        this.numOfPeople = numOfPeople;
        this.comments = "";
    }

    public Reservation(Button tableButton){
        this.tableButton = tableButton;
    }

    public Reservation(Reservation reservation){
        this.name=reservation.name;
        this.numOfPeople=reservation.numOfPeople;
        this.rTableNumber=reservation.rTableNumber;
        this.comments=reservation.comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setrTableNumber(int rTableNumber) {
        this.rTableNumber = rTableNumber;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setTableButton(Button tableButton) {
        this.tableButton = tableButton;
    }

    public String getName() {
        return name;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public int getrTableNumber() {
        return rTableNumber;
    }

    public Button getTableButton() {
        return tableButton;
    }

    public String getComments() {
        return comments;
    }
}
