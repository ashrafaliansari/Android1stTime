package com.example.ashraf.dialer;

import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse("tel:9775217761"));
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings=new Intent(Settings.ACTION_SETTINGS);
                //dial.setData(Uri.parse("tel:9804621017"));
                startActivity(settings);
                Toast.makeText(MainActivity.this,"Careful!!!",Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,EmailActivity.class);
                startActivity(i);
              //  Intent mail=new Intent(Intent.ACTION_SEND);

                //mail.setType("message/rfc822");
              //  startActivity(mail);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri=Uri.parse("smsto:");
                Intent sms=new Intent(Intent.ACTION_SENDTO,uri);
                startActivity(sms);
            }
        });
    }

}
