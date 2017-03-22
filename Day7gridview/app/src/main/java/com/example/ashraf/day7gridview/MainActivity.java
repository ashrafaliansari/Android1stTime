package com.example.ashraf.day7gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv1=(GridView)findViewById(R.id.gv);
        gv1.setAdapter(new ImageAdapter(this));

    }
}
