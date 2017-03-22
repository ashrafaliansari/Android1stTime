package com.example.ashraf.dialer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EmailActivity extends AppCompatActivity {
    Button btn1;
    EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        btn1=(Button)findViewById(R.id.button5);
        et1=(EditText)findViewById(R.id.editText4);
        et2=(EditText)findViewById(R.id.editText5);
        et3=(EditText)findViewById(R.id.editText6);
      //  final String emailid=et1.getText().toString();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailid=et1.getText().toString();
                String sub=et2.getText().toString();
                String con=et3.getText().toString();

                Intent mail=new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL,new String[]{emailid});
                mail.putExtra(Intent.EXTRA_SUBJECT,sub);
                mail.putExtra(Intent.EXTRA_TEXT,con);
                mail.setType("message/rfc822");
                startActivity(mail);
            }
        });
    }
}
