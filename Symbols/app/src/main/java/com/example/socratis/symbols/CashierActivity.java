package com.example.socratis.symbols;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CashierActivity extends AppCompatActivity {

    ArrayList<Order> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier);
        randomOrders();
    }

    public void manageOrder(View view){
        Handler.tableButton = (Button) view;
        orders = Handler.orders;
        int tableNumber=Integer.parseInt(Handler.tableButton.getText().toString());
        if(orders.isEmpty()){
            Toast toast = Toast.makeText(getApplicationContext(), "There isn't any order on that table!", Toast.LENGTH_LONG);
            toast.show();
        }else{
            boolean flag = false;
            for(int i=0;i<orders.size();i++){
                if(orders.get(i).getTableNumber()==tableNumber){
                    Intent intent = new Intent(this, CashierTableActivity.class);
                    startActivity(intent);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                Toast toast = Toast.makeText(getApplicationContext(), "There isn't any order on that table!", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    public void calculateChange(View view){
        EditText billAmount = findViewById(R.id.billAmount);
        EditText givenMoney = findViewById(R.id.money);
        double amount = Double.parseDouble(billAmount.getText().toString());
        double money = Double.parseDouble(givenMoney.getText().toString());
        double change = money - amount;
        TextView tv = findViewById(R.id.change);
        tv.setText("" + change);
    }

    private void randomOrders(){
        orders=Handler.orders;
        Button btn = findViewById(R.id.t2);
        btn.setTextColor(Color.parseColor("#D50000"));
        Order order1 = new Order(2);
        order1.getDrinkOrder().add("2 Mojito");
        order1.getDrinkOrder().add("1 Hugo");
        order1.getFoodOrder().add("1 Chicken Burger");
        orders.add(order1);
        btn = findViewById(R.id.t4);
        btn.setTextColor(Color.parseColor("#D50000"));
        order1 = new Order(4);
        order1.getDrinkOrder().add("2 Margarita");
        order1.getFoodOrder().add("2 Chicken Burger");
        order1.getFoodOrder().add("3pulled Pork");
        orders.add(order1);
        btn = findViewById(R.id.t7);
        btn.setTextColor(Color.parseColor("#D50000"));
        order1 = new Order(7);
        order1.getDrinkOrder().add("3 Old Fashioned");
        order1.getDrinkOrder().add("2 Cuba Libre");
        order1.getFoodOrder().add("1 Pizza");
        orders.add(order1);
    }

//    @Override
//    public void onBackPressed() {  }
}
