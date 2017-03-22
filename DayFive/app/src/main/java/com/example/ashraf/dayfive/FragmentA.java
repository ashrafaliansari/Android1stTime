package com.example.ashraf.dayfive;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by ashraf on 18/3/17.
 */

public class FragmentA extends android.support.v4.app.Fragment {
    ListView lv1;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_one,container,false);
        lv1=(ListView)view.findViewById(R.id.lv1);

        String[] cars=new String[]{"alto","swift","baleno","brezza","i10","i20"};

        ArrayAdapter adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,cars);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item= (String) lv1.getItemAtPosition(position);
                Toast.makeText(getActivity(),item,Toast.LENGTH_SHORT).show();

            }
        });

        return (view);
    }
}
