package com.example.socratis.symbols;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/*

    Written by Stelios Stephani, Saimon Kourra

 */

public class BarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        manageOrders();
    }

    private void manageOrders(){
        TextView tv = findViewById(R.id.barOrder1);
        tv.setText("2 Old Fashioned\n3 Vodka Shark\n2 Hugo");
        tv.setBackgroundColor(Color.parseColor("#B2FF59"));
        tv = findViewById(R.id.barOrder2);
        tv.setText("2 Strawberry Mojito\n1 Sex on the beach");
        tv.setBackgroundColor(Color.parseColor("#B2FF59"));
    }

    public void orderClick(View view){
        final TextView tv = (TextView) view;
        final PopupMenu popup = new PopupMenu(this,view);
        popup.inflate(R.menu.order_popup);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                tv.setBackgroundColor(0);
//                tv.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv.setText("Empty");
                popup.dismiss();
                return true;
            }
        });
        popup.show();
    }

    public void alertClick(View view){
        Toast toast= Toast.makeText(this,"Waiter Alerted", Toast.LENGTH_LONG);
        toast.show();
    }

//    @Override
//    public void onBackPressed() {  }
}
