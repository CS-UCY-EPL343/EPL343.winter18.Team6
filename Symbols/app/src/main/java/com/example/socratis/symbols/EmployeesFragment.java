package com.example.socratis.symbols;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class EmployeesFragment extends Fragment {

    static ArrayList<String> employees;
    static ListView employeesList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_employees, container, false);
        employees = new ArrayList<>();
        fillEmployees();
        employeesList = v.findViewById(R.id.employeesList);
        ArrayAdapter<String> ArrayAdapter = new ArrayAdapter<>(this.getActivity(),android.R.layout.simple_list_item_1,employees);
        employeesList.setAdapter(ArrayAdapter);
        return v;
    }

    private void fillEmployees(){
        Employee e = new Employee(1, "Socratis Christodoulou\t", 12345678);
        employees.add(e.toString());
        e = new Employee(2, "Neophytos Christou\t", 123456);
        employees.add(e.toString());
    }


}
