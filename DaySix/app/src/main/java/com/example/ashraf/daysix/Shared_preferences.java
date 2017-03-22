package com.example.ashraf.daysix;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Shared_preferences extends AppCompatActivity {
    Button btn1,btn2;
    EditText et1,et2;
    SharedPreferences preferences;
    String fname,fdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        btn1=(Button)findViewById(R.id.button5);
        btn2=(Button)findViewById(R.id.button6);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        preferences= PreferenceManager.getDefaultSharedPreferences(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 fname=et1.getText().toString();
                 fdata=et2.getText().toString();
                if(!fname.isEmpty())
                {
                    preferences.edit().putString("data",fname).apply();
                }
                Toast.makeText(Shared_preferences.this,"Saved",Toast.LENGTH_SHORT).show();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=preferences.getString("data","nothing found");
                et2.setText(text);
                Toast.makeText(Shared_preferences.this,"Reading",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
