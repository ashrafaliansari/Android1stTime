package com.example.ashraf.daysix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class External_stroage extends AppCompatActivity {
    Button btn1,btn2;
    EditText et1,et2;
    String fname,fdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_stroage);
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
                    File myfile=new File("/sdcard/"+fname);
                    myfile.createNewFile();
                    FileOutputStream fout=new FileOutputStream(myfile);
                    OutputStreamWriter writer=new OutputStreamWriter(fout);
                    writer.append(fdata);
                    writer.close();
                    fout.close();
                    Toast.makeText(External_stroage.this,fname+"  saved",Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname=et1.getText().toString();
                String adatarow="",adatabuffer="";
                try
                {
                    File myfile=new File("/sdcard/"+fname);
                    FileInputStream fio=new FileInputStream(myfile);
                    BufferedReader br=new BufferedReader(new InputStreamReader(fio));
                    while((adatarow=br.readLine())!=null) {
                        adatabuffer = adatabuffer+adatarow+"\n";


                }
                    br.close();
                    Toast.makeText(External_stroage.this, adatabuffer,Toast.LENGTH_SHORT).show();
                }
                catch (IOException e){
                    e.printStackTrace();
                }


            }
        });
    }
}
