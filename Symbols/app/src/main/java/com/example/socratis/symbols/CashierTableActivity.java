package com.example.socratis.symbols;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CashierTableActivity extends AppCompatActivity {

    ArrayList<Order> orders;
    Button tableButton;
    Order order;
    ListView drinkList;
    ListView foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier_table);
        orders=Handler.orders;
        tableButton = Handler.tableButton;
        TextView tv = findViewById(R.id.tableNumber);
        tv.setText(tableButton.getText());
        int tableNumber = Integer.parseInt(tableButton.getText().toString());
        for(int i=0;i<orders.size();i++){
            if(orders.get(i).getTableNumber()==tableNumber){
                order=orders.get(i);
                break;
            }
        }
        drinkList = findViewById(R.id.drinksList);
        ArrayAdapter<String> drinkArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,order.getDrinkOrder());
        drinkList.setAdapter(drinkArrayAdapter);
        foodList = findViewById(R.id.foodList);
        ArrayAdapter<String> foodArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,order.getFoodOrder());
        foodList.setAdapter(foodArrayAdapter);
    }

    public void printBill(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage("Are you sure?")
                .setPositiveButton("Yes",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        tableButton.setTextColor(Color.parseColor("#00C853"));
                        tableButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                tableButton.setTextColor(Color.parseColor("#000000"));
                                orders.remove(order);
                                tableButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast toast = Toast.makeText(getApplicationContext(), "There isn't any order on that table!", Toast.LENGTH_LONG);
                                        toast.show();
                                    }
                                });
                            }
                        });
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

    public void clearTable(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage("Are you sure?")
                .setPositiveButton("Yes",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        tableButton.setTextColor(Color.parseColor("#000000"));
                        orders.remove(order);
                        tableButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast toast = Toast.makeText(getApplicationContext(), "There isn't any order on that table!", Toast.LENGTH_LONG);
                                toast.show();
                            }
                        });
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

    public void backToCashierTables(View view){
        finish();
    }
}
