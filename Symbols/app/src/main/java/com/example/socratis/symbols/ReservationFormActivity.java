package com.example.socratis.symbols;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ReservationFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_form);
    }

    public void addDetailedReservation(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage("Are you sure?")
                .setPositiveButton("Yes",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        add();
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

    private void add(){
        EditText editTextTable = findViewById(R.id.rTable);
        EditText editTextName = findViewById(R.id.rName);
        EditText editTextNum = findViewById(R.id.rNumOfPeople);
        EditText editTextComment = findViewById(R.id.rComments);
        if(editTextTable.getText().toString().isEmpty()||editTextName.getText().toString().isEmpty()||editTextNum.getText().toString().isEmpty()){
            Toast toast = Toast.makeText(getApplicationContext(),"You have to fill all the fields!",Toast.LENGTH_SHORT);
            toast.show();
        }else{
            int rTableNum = Integer.parseInt(editTextTable.getText().toString());
            if(rTableNum>16){
                Toast toast = Toast.makeText(getApplicationContext(),"The table number you provided is not valid!",Toast.LENGTH_SHORT);
                toast.show();
            }else{
                String rName = editTextName.getText().toString();
                int rNumOfPeople = Integer.parseInt(editTextNum.getText().toString());
                ArrayList<Button> buttons = HostActivity.buttons;
                Button rButton=null;
                for(int i=0;i<buttons.size();i++){
                    if(i+1==rTableNum){
                        rButton=buttons.get(i);
                    }
                }

                Reservation reservation = new Reservation(rTableNum,rName, rNumOfPeople, rButton);
                reservation.setComments(editTextComment.getText().toString());
                Handler.reservations.add(reservation);
                rButton.setTextColor(Color.parseColor("#D50000"));
                finish();
            }
        }
    }
}
