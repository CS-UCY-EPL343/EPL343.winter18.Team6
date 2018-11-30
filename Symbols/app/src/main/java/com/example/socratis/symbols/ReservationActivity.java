package com.example.socratis.symbols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ReservationActivity extends AppCompatActivity {

    Button reservationNumber;
    ArrayList<Reservation> reservations;
    Reservation reservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        reservations = Handler.reservations;
        reservationNumber = Handler.reservationNumber;
        TextView tv = findViewById(R.id.rTable);
        tv.setText(reservationNumber.getText());
        int tableNumber = Integer.parseInt(reservationNumber.getText().toString());
        if(reservations.isEmpty()){
            Reservation reservation = new Reservation(reservationNumber);
            reservations.add(reservation);
        }else{
            boolean flag = false;
            for(int i=0;i<reservations.size();i++){
                if(reservations.get(i).getrTableNumber()==tableNumber){
                    reservation=reservations.get(i);
                    flag = true;
                    tv = findViewById(R.id.rName);
                    tv.setText(reservation.getName());
                    tv = findViewById(R.id.rNumOfPeople);
                    String str = "" + reservation.getNumOfPeople();
                    tv.setText(str);
                    tv = findViewById(R.id.comments);
                    tv.setText(reservation.getComments());
                    tv = findViewById(R.id.availability);
                    tv.setText("RESERVED");
                    break;
                }
            }
            if(!flag){
                Reservation reservation = new Reservation(reservationNumber);
                reservations.add(reservation);
            }
        }
    }

    public void backToReservations(View view){
        finish();
    }
}
