package com.example.socratis.symbols;

public class Employee {

    private int id;
    private String name;
    private int telephone;

    public Employee(int id, String name, int telephone){
        this.id = id;
        this.name = name;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getTelephone() {
        return telephone;
    }

    public String toString(){
        return this.id + " " + name + " " +telephone;
    }

}
