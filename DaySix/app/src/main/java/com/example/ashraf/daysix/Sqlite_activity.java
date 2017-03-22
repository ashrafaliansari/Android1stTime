package com.example.ashraf.daysix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Sqlite_activity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5;
    //TextView tv;
    EditText et1,et2,et3,et4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_activity);
        final SQLDatabaseHandler db=new SQLDatabaseHandler(this);
        btn1=(Button)findViewById(R.id.ac);
        btn2=(Button)findViewById(R.id.uc);
        btn3=(Button)findViewById(R.id.da);
        btn4=(Button)findViewById(R.id.dp);
        btn5=(Button)findViewById(R.id.del);
        et1=(EditText)findViewById(R.id.id);
        et2=(EditText) findViewById(R.id.name);
        et3=(EditText)findViewById(R.id.pno);
        et4=(EditText)findViewById(R.id.editText);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addContacts(new SQLcontact(et2.getText().toString(),et3.getText().toString()));
                et2.setText("");
                et3.setText("");
                Log.v("Added ",et2.getText().toString());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            db.updatecontact(new SQLcontact(
                    Integer.parseInt(et1.getText().toString()),
                    et2.getText().toString(),
                    et3.getText().toString()));
                et1.setText("");
                et2.setText("");
                et3.setText("");


            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<SQLcontact> contacts=db.getAllContacts();
               // Toast.makeText(Sqlite_activity.this,"out the for",Toast.LENGTH_SHORT).show();

                for (SQLcontact cn:contacts)
                {
                //    Toast.makeText(Sqlite_activity.this,"in the for",Toast.LENGTH_SHORT).show();
                    String log= "Id: "+cn.getId()+" ,Name: "+ cn.getName()+" ,phonenumber"+cn.getPhno();
                    et4.setText(log);
                    Log.v("name",log);
                   // et4.setText(log.toString()+"\n");


                }
                //Toast.makeText(Sqlite_activity.this,"working",Toast.LENGTH_SHORT).show();

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLcontact cn=db.getContact(Integer.parseInt(et1.getText().toString()));
                String log="id:"+cn.getId()+" ,name: "+ cn.getName()+" ,phonenumber"+cn.getPhno();
                et4.setText(log);
                Log.v("name",log);

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deletecontact(new SQLcontact(Integer.parseInt(et1.getText().toString())));
                et1.setText("");

            }
        });
    }
}
