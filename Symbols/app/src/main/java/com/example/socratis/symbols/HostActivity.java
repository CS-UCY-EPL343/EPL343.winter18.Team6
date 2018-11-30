package com.example.socratis.symbols;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class HostActivity extends AppCompatActivity {

    ArrayList<Reservation> reservations;
    static ArrayList<Button> buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
        reservations = Handler.reservations;
        fillButtons();
        fillReservations();
        for(int i=0;i<reservations.size();i++){
            reservations.get(i).getTableButton().setTextColor(Color.parseColor("#D50000"));
        }
    }

    public void manageReservation(View view){
        Handler.reservationNumber = (Button) view;
        Intent intent = new Intent(this, ReservationActivity.class);
        startActivity(intent);
    }

    private void fillReservations(){
        Button btn;
        btn = findViewById(R.id.r1);
        Reservation reservation = new Reservation(1, "Socratis Christodoulou", 8, btn);
        reservations.add(reservation);
        btn = findViewById(R.id.r4);
        reservation = new Reservation(4, "Neophytos Christou", 10, btn);
        reservations.add(reservation);
        btn = findViewById(R.id.r7);
        reservation = new Reservation(7, "Elena Prigkipa", 6, btn);
        reservations.add(reservation);
        btn = findViewById(R.id.r12);
        reservation = new Reservation(12, "Giorgos Haraki", 7, btn);
        reservations.add(reservation);
    }

    private void fillButtons(){
        buttons.add((Button)findViewById(R.id.r1));
        buttons.add((Button)findViewById(R.id.r2));
        buttons.add((Button)findViewById(R.id.r3));
        buttons.add((Button)findViewById(R.id.r4));
        buttons.add((Button)findViewById(R.id.r5));
        buttons.add((Button)findViewById(R.id.r6));
        buttons.add((Button)findViewById(R.id.r7));
        buttons.add((Button)findViewById(R.id.r8));
        buttons.add((Button)findViewById(R.id.r9));
        buttons.add((Button)findViewById(R.id.r10));
        buttons.add((Button)findViewById(R.id.r11));
        buttons.add((Button)findViewById(R.id.r12));
        buttons.add((Button)findViewById(R.id.r13));
        buttons.add((Button)findViewById(R.id.r14));
        buttons.add((Button)findViewById(R.id.r15));
        buttons.add((Button)findViewById(R.id.r16));
    }

    public void changeTable(View view){
        Button change = (Button) view;
        EditText fromTable = findViewById(R.id.fromTable);
        EditText toTable = findViewById(R.id.toTable);
        if(fromTable.getText().toString().isEmpty()||toTable.getText().toString().isEmpty()){
            Toast toast = Toast.makeText(getApplicationContext(), "Fill the required fields!", Toast.LENGTH_LONG);
            toast.show();
        }else{
            int from = Integer.parseInt(fromTable.getText().toString());
            int to = Integer.parseInt(toTable.getText().toString());
            Button fromButton=null;
            Button toButton=null;
            for(int i=0;i<buttons.size();i++){
                if(i+1==from)
                    fromButton = buttons.get(i);
                if(i+1==to)
                    toButton = buttons.get(i);
            }
            Reservation fromReservation=null;
            Reservation toReservation=null;
            boolean fromFlag=false;
            boolean toFlag=false;
            for(int i=0;i<reservations.size();i++){
                if(reservations.get(i).getrTableNumber()==from){
                    fromReservation=reservations.get(i);
                    fromFlag=true;
                }
                if(reservations.get(i).getrTableNumber()==to) {
                    toReservation = reservations.get(i);
                    toFlag=true;
                }
            }
            if(fromFlag&&!toFlag){
                fromReservation.setTableButton(toButton);
                fromReservation.setrTableNumber(to);
                Reservation reservation = new Reservation(fromReservation);
                reservations.remove(fromReservation);
                reservations.add(reservation);
            }else if(!fromFlag&&toFlag){
                toReservation.setTableButton(fromButton);
                toReservation.setrTableNumber(from);
                Reservation reservation = new Reservation(toReservation);
                reservations.remove(toReservation);
                reservations.add(reservation);
            }else if(fromFlag&&toFlag){
                fromReservation.setrTableNumber(to);
                fromReservation.setTableButton(toButton);
                toReservation.setrTableNumber(from);
                toReservation.setTableButton(fromButton);
            }
            change.setTextColor(toButton.getTextColors());
            toButton.setTextColor(fromButton.getTextColors());
            fromButton.setTextColor(change.getTextColors());
            change.setTextColor(Color.parseColor("#000000"));
            fromTable.setText("");
            toTable.setText("");

        }
    }

    public void addReservation(View view){
        Intent intent = new Intent(this, ReservationFormActivity.class);
        startActivity(intent);
    }

    public void clearReservations(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage("Are you sure?")
                .setPositiveButton("Yes",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        for(int i=0;i<reservations.size();i++){
                            reservations.get(i).getTableButton().setTextColor(Color.parseColor("#000000"));
                        }
                        reservations.clear();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    public void clearReservation(View view){
        EditText clearTable = findViewById(R.id.clearTable);
        if(clearTable.getText().toString().isEmpty()){
            Toast toast = Toast.makeText(getApplicationContext(), "Fill the required field!", Toast.LENGTH_LONG);
            toast.show();
        }else{
            int cTableNum = Integer.parseInt(clearTable.getText().toString());
            if(cTableNum>16){
                Toast toast = Toast.makeText(getApplicationContext(), "The table number you provided is not valid!", Toast.LENGTH_LONG);
                toast.show();
            }else{
                boolean flag = false;
                for(int i=0;i<reservations.size();i++){
                    if(reservations.get(i).getrTableNumber()==cTableNum){
                        reservations.remove(reservations.get(i));

                        flag = true;
                    }
                }
                if(!flag){
                    Toast toast = Toast.makeText(getApplicationContext(), "There isn't a reservation on the table you provided!", Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    clearTable.setText("");
                    Toast toast = Toast.makeText(getApplicationContext(), "Reservation cleared!", Toast.LENGTH_LONG);
                    toast.show();
                }
                for(int i=0;i<buttons.size();i++){
                    if(i+1==cTableNum)
                        buttons.get(i).setTextColor(Color.parseColor("#000000"));
                }
            }
        }
    }

//    @Override
//    public void onBackPressed() {  }
}
