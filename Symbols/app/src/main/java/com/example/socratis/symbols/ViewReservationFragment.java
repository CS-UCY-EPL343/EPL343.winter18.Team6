package com.example.socratis.symbols;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ViewReservationFragment extends Fragment {

    static ArrayList<String> reservations;
    static ListView reservationList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_reservation, container, false);
        reservations = new ArrayList<>();
        fillReservations();
        reservationList = v.findViewById(R.id.reservationList);
        ArrayAdapter<String> ArrayAdapter = new ArrayAdapter<>(this.getActivity(),android.R.layout.simple_list_item_1,reservations);
        reservationList.setAdapter(ArrayAdapter);
        return v;
    }

    private void fillReservations(){
        reservations.add("1 Socratis Christodoulou\t10");
        reservations.add("2 Neophytos Christou\t8");
        reservations.add("3 Elena Prigkipa\t6");
        reservations.add("4 Stelios Stephani\t12");
    }
}
