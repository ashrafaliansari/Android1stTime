package com.example.ashraf.dayfive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ashraf on 18/3/17.
 */

public class FragmentB extends android.support.v4.app.Fragment {
    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_two,container,false);
        ListView list;
        MyAdapter adapter;
        ArrayList<MyList> values=new ArrayList<>();

            list=(ListView)view.findViewById(R.id.lv1);
            for (int i=1;i<5;i++)
            {
                MyList a=new MyList();
                a.setName("student"+i);
                a.setPlace("Vasco"+i);
                values.add(a);
            }
            adapter =new MyAdapter(this,values);
            list.setAdapter(adapter);
        return (view);
        }



    }



