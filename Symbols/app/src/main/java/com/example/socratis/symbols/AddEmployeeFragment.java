package com.example.socratis.symbols;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class AddEmployeeFragment extends Fragment {

    static View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_add_employee, container, false);
        return v;
    }

    public void addEmployee(View view){
        EditText id = v.findViewById(R.id.id);
        EditText name = v.findViewById(R.id.name);
        EditText tel = v.findViewById(R.id.telephone);

        int idInt = Integer.parseInt(id.getText().toString());
        int telInt = Integer.parseInt(tel.getText().toString());
        Employee e =new Employee(idInt, name.getText().toString(), telInt);
        EmployeesFragment.employees.add(e.toString());
//        ArrayAdapter<String> ArrayAdapter = new ArrayAdapter<>(this.getActivity(),android.R.layout.simple_list_item_1,EmployeesFragment.employees);
//        EmployeesFragment.employeesList.setAdapter(ArrayAdapter);
    }
}
