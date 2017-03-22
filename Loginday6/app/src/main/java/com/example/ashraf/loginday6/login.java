package com.example.ashraf.loginday6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText et1,et2;
    Button btn1,btn2;
    UserSession session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn1=(Button)findViewById(R.id.login);
        btn2=(Button)findViewById(R.id.button);
        et1=(EditText) findViewById(R.id.editText);
        et2=(EditText) findViewById(R.id.editText2);
        session=new UserSession(getApplicationContext());
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=et1.getText().toString();
                String password=et2.getText().toString();
                if(username.equals("arup")&&password.equals("ashraf")) {
                    session.createUserLoginSession("arup","ashraf");

                    Intent i = new Intent(login.this, MainActivity.class);
                    startActivity(i);

                    Toast.makeText(login.this,"Log-in Success",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(login.this,"Wrong Id Or Password",Toast.LENGTH_SHORT).show();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(login.this,Register.class);
                startActivity(i);


            }
        });
    }

}
