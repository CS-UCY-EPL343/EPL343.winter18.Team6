package com.example.socratis.symbols;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

/*

    Written by Stelios Stephani, Saimon Kourra

 */

public class KitchenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        manageOrders();
    }

    private void manageOrders(){
        TextView tv = findViewById(R.id.kitchenOrder1);
        tv.setText("2 Chicken Burger\n1 Pork Chop");
        tv.setBackgroundColor(Color.parseColor("#B2FF59"));
        tv=findViewById(R.id.kitchenOrder2);
        tv.setText("1 Pizza\n3 Pulled Pork");
        tv.setBackgroundColor(Color.parseColor("#B2FF59"));
    }

    public void orderClick(View view){
        final TextView tv = (TextView) view;
        if(!tv.getText().toString().isEmpty()){
            final PopupMenu popup = new PopupMenu(this,view);
            popup.inflate(R.menu.order_popup);
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem item) {
                    tv.setBackgroundColor(0);
//                tv.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    tv.setText("");
                    popup.dismiss();
                    return true;
                }
            });
            popup.show();
        }
    }

    public void alertClick(View view){
        Toast toast= Toast.makeText(this,"Waiter Alerted", Toast.LENGTH_LONG);
        toast.show();
    }

//    @Override
//    public void onBackPressed() {  }
}
