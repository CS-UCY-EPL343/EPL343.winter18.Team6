package com.example.socratis.symbols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.widget.Toast;

/*

    Written by Neophytos Christou, Elena Prigkipa

 */

public class UserActivity extends AppCompatActivity {

    private static String [][] users = new String[][]{{"schris25","cashier"},{"nchris23","manager"},
    {"eprigk01","host"},{"ssteph02","bar"},{"gharak01","service"},{"skourr01","kitchen"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }

    /** Called when the user taps the Log in button */
    public void logIn(View view) {
        EditText editTextUser = findViewById(R.id.username);
        EditText editTextPass = findViewById(R.id.password);
        if(logInAccepted(editTextUser.getText().toString(), editTextPass.getText().toString())){
            Intent intent = new Intent(this, UseOptionActivity.class);
            intent.putExtra("password", editTextPass.getText().toString());
            startActivity(intent);
        }else {
            Toast toast = Toast.makeText(getApplicationContext(), "Sign in failed",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private boolean logInAccepted(String username, String password){
        for(int i=0;i<users.length;i++){
            if(username.equals(users[i][0])){
                if(password.equals(users[i][1])){
                    return true;
                }
            }
        }
        return false;
    }
}
