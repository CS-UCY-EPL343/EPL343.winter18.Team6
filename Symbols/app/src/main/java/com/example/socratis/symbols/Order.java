package com.example.socratis.symbols;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {

    private ArrayList<String> drinkOrder;
    private ArrayList<String> foodOrder;
    private int tableNumber;

    public Order(int tableNumber){
        this.drinkOrder = new ArrayList<>();
        this.foodOrder = new ArrayList<>();
        this.tableNumber=tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public ArrayList<String> getDrinkOrder() {
        return drinkOrder;
    }

    public ArrayList<String> getFoodOrder() {
        return foodOrder;
    }

    public void addFood(String food){
        foodOrder.add(food);
    }

    public void addDrink(String drink){
        drinkOrder.add(drink);
    }

}