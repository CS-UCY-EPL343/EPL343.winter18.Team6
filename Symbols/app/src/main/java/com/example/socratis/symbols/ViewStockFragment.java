package com.example.socratis.symbols;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ViewStockFragment extends Fragment {

    static ArrayList<String> stock;
    static ListView stockList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_view_stock, container, false);
        stock = new ArrayList<>();
        fillStock();
        stockList = v.findViewById(R.id.stockList);
        ArrayAdapter<String> ArrayAdapter = new ArrayAdapter<>(this.getActivity(),android.R.layout.simple_list_item_1,stock);
        stockList.setAdapter(ArrayAdapter);
        return v;
    }

    private void fillStock(){
        stock.add("20 Vodka Smirnof\t");
        stock.add("30 Wishkey Famous\t");
        stock.add("15 Tequila\t");
        stock.add("35 Bacardi\t");
    }
}
