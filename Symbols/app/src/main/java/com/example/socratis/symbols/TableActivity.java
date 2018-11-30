package com.example.socratis.symbols;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.PopupMenu;
import java.util.ArrayList;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;


/*

    Written by Giorgos Harakis, Socratis Christodoulou

 */

public class TableActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    Order order;
    ListView drinkList;
    ListView foodList;
    ArrayList<Order> orders;
    Button tableButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        tableButton = Handler.tableButton;
        orders = Handler.orders;
        TextView tv = findViewById(R.id.tableNumber);
        tv.setText(tableButton.getText());
        int tableNumber = Integer.parseInt(tableButton.getText().toString());
        if(orders.isEmpty()){
            order = new Order(tableNumber);
            orders.add(order);
        }else{
            boolean flag = false;
            for(int i=0;i<orders.size();i++){
                if(orders.get(i).getTableNumber()==tableNumber){
                    order=orders.get(i);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                order = new Order(tableNumber);
                orders.add(order);
            }
        }
        drinkList = findViewById(R.id.drinksList);
        ArrayAdapter<String> drinkArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,order.getDrinkOrder());
        drinkList.setAdapter(drinkArrayAdapter);
        drinkList.setOnItemClickListener(this);
        foodList = findViewById(R.id.foodList);
        ArrayAdapter<String> foodArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,order.getFoodOrder());
        foodList.setAdapter(foodArrayAdapter);
        foodList.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.inflate(R.menu.delete_popup);
        switch(adapterView.getId()) {
            case R.id.drinksList:
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        order.getDrinkOrder().remove(i);
                        drinkList = findViewById(R.id.drinksList);
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(TableActivity.this, android.R.layout.simple_list_item_1,order.getDrinkOrder());
                        drinkList.setAdapter(arrayAdapter);
                        return true;
                    }
                });
                break;
            case R.id.foodList:
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        order.getFoodOrder().remove(i);
                        foodList = findViewById(R.id.foodList);
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(TableActivity.this, android.R.layout.simple_list_item_1,order.getFoodOrder());
                        foodList.setAdapter(arrayAdapter);
                        return true;
                    }
                });
                break;
        }
        popup.show();
    }

    public void changeFragment(View view){
        Fragment fragment;
        FragmentManager fm;
        FragmentTransaction ft;
        LinearLayout ll;
        View v;

        switch (view.getId()){
            case R.id.add_drink:
                ll = findViewById(R.id.order_layout);
                ll.setVisibility(View.INVISIBLE);
                v = findViewById(R.id.fragment_place);
                v.setVisibility(View.VISIBLE);
                fragment = new DrinksMenuFragment();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
                break;
            case R.id.add_food:
                ll = findViewById(R.id.order_layout);
                ll.setVisibility(View.INVISIBLE);
                v = findViewById(R.id.fragment_place);
                v.setVisibility(View.VISIBLE);
                fragment = new FoodMenuFragment();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
                break;
        }
    }

    public void billAlert(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage("Are you sure?")
                .setPositiveButton("Yes",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    public void billPaid(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage("Are you sure?")
                .setPositiveButton("Yes",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        tableButton.setTextColor(Color.parseColor("#000000"));
                        orders.remove(order);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    public void backToTables(View view){
        finish();
    }

    public void onOrderClicked(View view){
        View v = findViewById(R.id.fragment_place);
        v.setVisibility(View.GONE);
        LinearLayout ll = findViewById(R.id.order_layout);
        ll.setVisibility(View.VISIBLE);
        drinkList= findViewById(R.id.drinksList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(TableActivity.this, android.R.layout.simple_list_item_1,order.getDrinkOrder());
        drinkList.setAdapter(arrayAdapter);
        foodList = findViewById(R.id.foodList);
        ArrayAdapter<String> foodArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,order.getFoodOrder());
        foodList.setAdapter(foodArrayAdapter);
    }

    public static void addDrink(String drink){
        ArrayList<Order> orderArrayList = Handler.orders;
        Button tableButton = Handler.tableButton;
        Order order=null;
        int tableNumber = Integer.parseInt(tableButton.getText().toString());
        for(int i=0;i<orderArrayList.size();i++){
            if(orderArrayList.get(i).getTableNumber()==tableNumber){
                order=orderArrayList.get(i);
                break;
            }
        }
        order.addDrink(drink);
    }

    public static void addFood(String drink){
        ArrayList<Order> orderArrayList = Handler.orders;
        Button tableButton = Handler.tableButton;
        Order order=null;
        int tableNumber = Integer.parseInt(tableButton.getText().toString());
        for(int i=0;i<orderArrayList.size();i++){
            if(orderArrayList.get(i).getTableNumber()==tableNumber){
                order=orderArrayList.get(i);
                break;
            }
        }
        order.addFood(drink);
    }


}
