package com.example.socratis.symbols;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/*

    Written by Neophytos Christou, Elena Prigkipa

 */

public class UseOptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_option);
        Intent intent = getIntent();
        String pass = intent.getStringExtra("password");
        manageUses(pass);
    }

    /** Called when the user taps the Log in button */
    public void defineActivity(View view) {
        if(view.getId()==findViewById(R.id.service).getId()){
            Intent intent = new Intent(this, ServiceActivity.class);
            startActivity(intent);
        }else if(view.getId()==findViewById(R.id.host).getId()){
            Intent intent = new Intent(this, HostActivity.class);
            startActivity(intent);
        }else if(view.getId()==findViewById(R.id.kitchen).getId()){
            Intent intent = new Intent(this, KitchenActivity.class);
            startActivity(intent);
        }else if(view.getId()==findViewById(R.id.bar).getId()){
            Intent intent = new Intent(this, BarActivity.class);
            startActivity(intent);
        }else if(view.getId()==findViewById(R.id.cashier).getId()){
            Intent intent = new Intent(this, CashierActivity.class);
            startActivity(intent);
        }else if(view.getId()==findViewById(R.id.kitchen).getId()){
            Intent intent = new Intent(this, ManagerActivity.class);
            startActivity(intent);
        }else if(view.getId()==findViewById(R.id.manager).getId()){
            Intent intent = new Intent(this, ManagerActivity.class);
            startActivity(intent);
        }
    }

    private void manageUses(String pass){
        Button service = findViewById(R.id.service);
        service.setClickable(false);
        Button host = findViewById(R.id.host);
        host.setClickable(false);
        Button kitchen = findViewById(R.id.kitchen);
        kitchen.setClickable(false);
        Button bar = findViewById(R.id.bar);
        bar.setClickable(false);
        Button cashier = findViewById(R.id.cashier);
        cashier.setClickable(false);
        Button manager = findViewById(R.id.manager);
        manager.setClickable(false);
        switch (pass){
            case "service":
                service.setClickable(true);
                service.setTextColor(Color.parseColor("#000000"));
                break;
            case "host":
                host.setClickable(true);
                host.setTextColor(Color.parseColor("#000000"));
                break;
            case "kitchen":
                kitchen.setClickable(true);
                kitchen.setTextColor(Color.parseColor("#000000"));
                break;
            case "bar":
                bar.setClickable(true);
                bar.setTextColor(Color.parseColor("#000000"));
                break;
            case "cashier":
                cashier.setClickable(true);
                cashier.setTextColor(Color.parseColor("#000000"));
                break;
            case "manager":
                service.setClickable(true);
                service.setTextColor(Color.parseColor("#000000"));
                host.setClickable(true);
                host.setTextColor(Color.parseColor("#000000"));
                kitchen.setClickable(true);
                kitchen.setTextColor(Color.parseColor("#000000"));
                bar.setClickable(true);
                bar.setTextColor(Color.parseColor("#000000"));
                cashier.setClickable(true);
                cashier.setTextColor(Color.parseColor("#000000"));
                manager.setClickable(true);
                manager.setTextColor(Color.parseColor("#000000"));
                break;
        }
    }

//    @Override
//    public void onBackPressed() {  }
}
