package com.example.ashraf.dayfour;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    CheckBox ch1,ch2;
    Button btn1,btn2,btn4;
    ToggleButton btn3;
    RadioGroup radgrp;
    RadioButton rb1;
    RatingBar rate;
    Switch sw;
    SeekBar sb;
    TextView tv;
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ch1=(CheckBox)findViewById(R.id.checkBox);
        ch2=(CheckBox)findViewById(R.id.checkBox2);
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(ToggleButton) findViewById(R.id.button3);
        btn4=(Button) findViewById(R.id.button4);

        radgrp=(RadioGroup)findViewById(R.id.radioGroup);
        tv=(TextView)findViewById(R.id.textView7);
        rate=(RatingBar)findViewById(R.id.ratingBar);
        sw=(Switch)findViewById(R.id.switch1);
        sb=(SeekBar)findViewById(R.id.seekBar);
        wv=(WebView)findViewById(R.id.webView);
        wv.setWebViewClient(new MyBrowser());
        wv.loadUrl("http://www.google.com");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result=new StringBuffer();
                if(ch1.isChecked()&&ch2.isChecked()){
                    Toast.makeText(MainActivity.this,"You like both",Toast.LENGTH_SHORT).show();
                }
                else if (ch1.isChecked()) {
                    result.append("Like Cars!!! ");//.append(ch1.isChecked());
                    Toast.makeText(MainActivity.this,result.toString(),Toast.LENGTH_SHORT).show();
                }
                else if(ch2.isChecked()) {
                    result.append("\nLike Bikes!!! ");//.append(ch2.isChecked());
                    Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
                }

                else
                    Toast.makeText(MainActivity.this,"Are you a fool!!",Toast.LENGTH_SHORT).show();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int si=radgrp.getCheckedRadioButtonId();
                rb1= (RadioButton)findViewById(si);
                Toast.makeText(MainActivity.this,rb1.getText(),Toast.LENGTH_SHORT).show();

            }
        });

        btn3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,ListActivity.class);
                startActivity(i);
            }
        });
        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                Toast.makeText(MainActivity.this,String.valueOf(ratingBar.getRating()),Toast.LENGTH_SHORT).show();

            }
        });
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Toast.makeText(MainActivity.this,"I am ON!!",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"I am OFF!!",Toast.LENGTH_SHORT).show();

            }
        });
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText(String.valueOf(sb.getProgress()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
