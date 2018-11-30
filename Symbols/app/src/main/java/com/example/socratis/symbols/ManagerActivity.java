package com.example.socratis.symbols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
    }

    public void viewEmployees(View view){
        Intent intent = new Intent(this, ViewEmployeesActivity.class);
        startActivity(intent);
    }

    public void viewStock(View view){
        Intent intent = new Intent(this, ViewStockActivity.class);
        startActivity(intent);
    }

    public void viewReservation(View view){
        Intent intent = new Intent(this, ViewReservationActivity.class);
        startActivity(intent);
    }

//    @Override
//    public void onBackPressed() {  }
}
