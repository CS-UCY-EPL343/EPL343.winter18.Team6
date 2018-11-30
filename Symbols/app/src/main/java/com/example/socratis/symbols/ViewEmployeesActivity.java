package com.example.socratis.symbols;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ViewEmployeesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employees);
        Button btn = findViewById(R.id.viewEmployees);
        btn.setClickable(false);
    }

    public void changeFragment(View view){
        Fragment fragment;
        FragmentManager fm;
        FragmentTransaction ft;
        LinearLayout ll;
        Button btn;

        switch (view.getId()){
            case R.id.addEmployee:
                btn = findViewById(R.id.addEmployee);
                btn.setClickable(false);
                btn = findViewById(R.id.viewEmployees);
                btn.setClickable(true);
                ll = findViewById(R.id.employeesLayout);
                ll.setVisibility(View.INVISIBLE);
                fragment = new AddEmployeeFragment();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
                break;
            case R.id.viewEmployees:
                btn = findViewById(R.id.viewEmployees);
                btn.setClickable(false);
                btn = findViewById(R.id.addEmployee);
                btn.setClickable(true);
                ll = findViewById(R.id.addEmployeeLayout);
                ll.setVisibility(View.INVISIBLE);
                fragment = new EmployeesFragment();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
                break;
        }
    }
}
