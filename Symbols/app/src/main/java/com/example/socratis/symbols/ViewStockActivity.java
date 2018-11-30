package com.example.socratis.symbols;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ViewStockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stock);
        Button btn = findViewById(R.id.viewStock);
        btn.setClickable(false);
    }

    public void changeFragment(View view){
        Fragment fragment;
        FragmentManager fm;
        FragmentTransaction ft;
        LinearLayout ll;
        Button btn;

        switch (view.getId()){
            case R.id.addStock:
                btn = findViewById(R.id.addStock);
                btn.setClickable(false);
                btn = findViewById(R.id.viewStock);
                btn.setClickable(true);
                ll = findViewById(R.id.stockLayout);
                ll.setVisibility(View.INVISIBLE);
                fragment = new AddStockFragment();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
                break;
            case R.id.viewStock:
                btn = findViewById(R.id.viewStock);
                btn.setClickable(false);
                btn = findViewById(R.id.addStock);
                btn.setClickable(true);
                ll = findViewById(R.id.addStockLayout);
                ll.setVisibility(View.INVISIBLE);
                fragment = new ViewStockFragment();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
                break;
        }
    }
}
