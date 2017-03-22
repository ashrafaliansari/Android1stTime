package com.example.ashraf.secondday;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;
//import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int REQUEST_VALUE_ACTIVITY=1;
    int CAMERA_REQUEST=2;
    int SELECT_PHOTO=3,GALLERY_REQUEST=4;
    //instantiation of button
     Button btn1,btn2,btn3;
     ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("CurrentState","OnCreate");
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.cam);
        btn3=(Button)findViewById(R.id.gal);
        iv=(ImageView)findViewById(R.id.imgview);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Checking for Clicks.
                Log.v("Clicked","Yes");
                //example of explicit intent
                //Launch Activity B from A
               // Intent i=new Intent(MainActivity.this,Main2Activity.class);
               // startActivity(i);
                //exxample to request some data from Activity B
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(i,REQUEST_VALUE_ACTIVITY);
            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //example to call a camera
                Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,CAMERA_REQUEST);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gallery=new Intent(Intent.ACTION_PICK);
                gallery.setType("image/*");
                startActivityForResult(gallery,GALLERY_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode,  resultCode,  data);
        if(requestCode==1){
            String msg=data.getStringExtra("message");
            Log.v("response",msg);
        }
        else if(requestCode==CAMERA_REQUEST){
            if(resultCode== Activity.RESULT_OK){
                Bitmap photo=(Bitmap) data.getExtras().get("data");
                iv.setImageBitmap(photo);
            }
        }   else if(requestCode==GALLERY_REQUEST){
            if(resultCode==Activity.RESULT_OK){
                try{
                    final Uri imageuri=data.getData();

                    final InputStream imageStream = getContentResolver().openInputStream(imageuri);
                    final Bitmap selectedImage= BitmapFactory.decodeStream(imageStream);
                    iv.setImageBitmap(selectedImage);
                } catch(FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("CurrentState","OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("CurrentState","OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("CurrentState","OnPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("CurrentState","OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("CurrentState","OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("CurrentState","OnDestroy");
    }
}

