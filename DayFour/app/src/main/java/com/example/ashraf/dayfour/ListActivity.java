package com.example.ashraf.dayfour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {
ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lv1=(ListView)findViewById(R.id.lv1);
       // String[] cars=getResources().getStringArray(R.array.cars);
        String[] cars=new String[]{"alto","swift","baleno","brezza","i10","i20"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,cars);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent go = new Intent(ListActivity.this,CustomListView.class);
                    startActivity(go);
                }
                String item= (String) lv1.getItemAtPosition(position);
                Toast.makeText(ListActivity.this,item,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
