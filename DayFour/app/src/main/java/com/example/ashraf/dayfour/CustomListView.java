package com.example.ashraf.dayfour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListView extends AppCompatActivity {
ListView list;
    MyAdapter adapter;
    public ArrayList<MyList> values=new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        list=(ListView)findViewById(R.id.lv1);
        for (int i=1;i<5;i++)
        {
            MyList a=new MyList();
            a.setName("student"+i);
            a.setPlace("Vasco"+i);
            values.add(a);
        }
        adapter =new MyAdapter(this,values);
        list.setAdapter(adapter);
    }
}
