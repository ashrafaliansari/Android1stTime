package com.example.ashraf.dayfive;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    Fragment fr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
         btn1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 fr=new FragmentA();
                 changeFragment(fr);
             }
         });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fr=new FragmentB();
                changeFragment(fr);
            }
        });
    }

    public void changeFragment(Fragment fr) {
        FragmentManager frm=getSupportFragmentManager();
        FragmentTransaction trans=frm.beginTransaction();
        trans.replace(R.id.fr,fr);
        trans.commit();


    }
}
