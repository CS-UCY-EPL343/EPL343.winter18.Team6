package com.example.socratis.symbols;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ViewReservationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reservation);
        Button btn = findViewById(R.id.viewReservation);
        btn.setClickable(false);
    }

    public void changeFragment(View view){
        Fragment fragment;
        FragmentManager fm;
        FragmentTransaction ft;
        LinearLayout ll;
        Button btn;

        switch (view.getId()){
            case R.id.addReservation:
                btn = findViewById(R.id.addReservation);
                btn.setClickable(false);
                btn = findViewById(R.id.viewReservation);
                btn.setClickable(true);
                ll = findViewById(R.id.reservationLayout);
                ll.setVisibility(View.INVISIBLE);
                fragment = new AddReservationFragment();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
                break;
            case R.id.viewReservation:
                btn = findViewById(R.id.viewReservation);
                btn.setClickable(false);
                btn = findViewById(R.id.addReservation);
                btn.setClickable(true);
                ll = findViewById(R.id.addReservationLayout);
                ll.setVisibility(View.INVISIBLE);
                fragment = new ViewReservationFragment();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
                break;
        }
    }

}
