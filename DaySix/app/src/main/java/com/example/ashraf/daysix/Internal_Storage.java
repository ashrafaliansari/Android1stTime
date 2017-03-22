package com.example.ashraf.daysix;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Internal_Storage extends AppCompatActivity {
    Button btn1,btn2;
    EditText et1,et2;
    String fname,fdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal__storage);
        btn1=(Button)findViewById(R.id.button5);
        btn2=(Button)findViewById(R.id.button6);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 fname=et1.getText().toString();
                 fdata=et2.getText().toString();
                try{
                    FileOutputStream fos;
                    fos=openFileOutput(fname, Context.MODE_PRIVATE);
                    fos.write(fdata.getBytes());
                    fos.close();
                    Toast.makeText(Internal_Storage.this,fname+"  saved",Toast.LENGTH_SHORT).show();
                }catch (IOException ignore){
                    ignore.printStackTrace();
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname =et1.getText().toString();
                StringBuffer buffer=new StringBuffer();
                try
                {
                    BufferedReader br=new BufferedReader(new InputStreamReader(openFileInput(fname)));
                    String inputstr;
                    while((inputstr=br.readLine())!=null) {
                        buffer.append(inputstr+"\n");

                    }
                        Toast.makeText(Internal_Storage.this  , buffer.toString()+"great app" , Toast.LENGTH_SHORT).show();

                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        });
    }
}
