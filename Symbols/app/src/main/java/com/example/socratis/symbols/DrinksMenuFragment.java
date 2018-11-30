package com.example.socratis.symbols;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class DrinksMenuFragment extends Fragment  {

    private Spinner spinner;
    private static final String[] contity = {"1", "2", "3", "4", "5"};
    static String drink=null;
    static String con=null;
    ListView listView;
    String[] drinkMenu = {"Old Fashioned", "Margarita", "Mojito", "Cuba Libre", "Hugo"};
    static View staticView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_drinks_menu, container, false);
        staticView = v;
        manageButtonListener(v);
        manageSpinnerListener(v);
        manageListListener(v);
        return v;
    }

    private void manageButtonListener(View v){
        v.findViewById(R.id.addDrinkToOrder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.addDrinkToOrder:
                        buttonPressed();
                        break;
                }
            }
        });
    }

    private void manageSpinnerListener(View v){
        spinner = v.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(),android.R.layout.simple_spinner_item,contity);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        con="1";
                        break;
                    case 1:
                        con="2";
                        break;
                    case 2:
                        con="3";
                        break;
                    case 3:
                        con="4";
                        break;
                    case 4:
                        con="5";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void manageListListener(View v){
        listView = v.findViewById(R.id.drinkMenuList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,drinkMenu);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        selectedItem(adapterView,position);
                        drink=drinkMenu[0];
                        break;
                    case 1:
                        selectedItem(adapterView,position);
                        drink=drinkMenu[1];
                        break;
                    case 2:
                        selectedItem(adapterView,position);
                        drink=drinkMenu[2];
                        break;
                    case 3:
                        selectedItem(adapterView,position);
                        drink=drinkMenu[3];
                        break;
                    case 4:
                        selectedItem(adapterView,position);
                        drink=drinkMenu[4];
                        break;
                }
            }
        });
    }

    public void buttonPressed(){
        TableActivity.addDrink(con + " " + drink);
        listView = staticView.findViewById(R.id.drinkMenuList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,drinkMenu);
        listView.setAdapter(arrayAdapter);
        spinner = staticView.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(),android.R.layout.simple_spinner_item,contity);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void selectedItem(AdapterView adapterView,int position){
        for(int i=0;i<drinkMenu.length;i++){
            if(i==position){
                adapterView.getChildAt(position).setBackgroundColor(Color.parseColor("#B3E5FC"));
            }else{
                adapterView.getChildAt(i).setBackgroundColor(0);
            }
        }

    }

}
