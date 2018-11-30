package com.example.socratis.symbols;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

/*
    Written by Giorgos Harakis, Socratis Christodoulou
 */

public class ServiceActivity extends AppCompatActivity {

    ArrayList<Order> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        orders = Handler.orders;
    }

    public void manageTable(View view){
        Handler.tableButton = (Button) view;
        Handler.tableButton.setTextColor(Color.parseColor("#D50000"));
        Intent intent = new Intent(this, TableActivity.class);
        startActivity(intent);
    }

//    @Override
//    public void onBackPressed() {  }

}
