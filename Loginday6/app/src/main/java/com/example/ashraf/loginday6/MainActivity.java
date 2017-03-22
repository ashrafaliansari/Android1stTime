package com.example.ashraf.loginday6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    UserSession session;
    Button btn1;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button4);
        tv=(TextView)findViewById(R.id.tv1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Register.class);
                startActivity(i);
            }
        });
        session=new UserSession(getApplicationContext());
        if (session.checklogin())
        {
            Intent i=new Intent(getApplicationContext(),login.class);
            startActivity(i);
            finish();
        }
        else {
            tv.setText("hello!! user");
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutuser();
                Intent i=new Intent(getApplicationContext(),login.class);
                startActivity(i);
            }
        });


    }
}
