package com.example.ashraf.loginday6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    Button btn1,btn2;
    EditText et1,et2,et3;
    UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        session=new UserSession(getApplicationContext());
        btn1=(Button)findViewById(R.id.button2);
        btn2=(Button)findViewById(R.id.button3);
        et1=(EditText)findViewById(R.id.username);
        et2=(EditText)findViewById(R.id.email);
        et3=(EditText)findViewById(R.id.password);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  uname=et1.getText().toString();
                String pass=et3.getText().toString();
                session.createUserLoginSession(uname,pass);
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Register.this,login.class);
                startActivity(i);
            }
        });
    }
}
