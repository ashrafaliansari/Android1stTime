package com.example.ashraf.daysix;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashraf on 21/3/17.
 */

class SQLDatabaseHandler extends SQLiteOpenHelper{
    private  static  final int databaseversion=1;
    private static final String datbasename="contactsmanager";
    private static final String tablecontacts="contacts";
    private static final String keyid="id";
    private static final String keyname="name";
    private static final String keyphonenumber="phonenumber";

   public SQLDatabaseHandler(Context context){
       super(context,datbasename,null,databaseversion);

   }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String createcontexttable= "CREATE TABLE "
                + tablecontacts + "("
                + keyid + " INTEGER PRIMARY KEY,"
                + keyname + " TEXT,"
                + keyphonenumber + " TEXT" + ")";
        db.execSQL(createcontexttable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tablecontacts);
        onCreate(db);


    }
    /* ALL CRUD OPERATIONS */
    void addContacts(SQLcontact contact){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(keyname,contact.getName());
        values.put(keyphonenumber,contact.getPhno());
        db.insert(tablecontacts,null,values);
        db.close();
    }
    //getting single contacts
    SQLcontact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(tablecontacts, new String[]{keyid, keyname, keyphonenumber},
                keyid + " = ?",
                new String[]{String.valueOf(id)},
                null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        SQLcontact contacts=new SQLcontact(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2));

        return (contacts);
    }
    public List<SQLcontact> getAllContacts() {
        List<SQLcontact>
                contactlist = new ArrayList<>();
        String selectquery = "SELECT * FROM " + tablecontacts;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectquery, null);
        if (cursor.moveToFirst()) {
            do {
                SQLcontact contact = new SQLcontact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhno(cursor.getString(2));
                contactlist.add(contact);

            } while (cursor.moveToNext());
        }return contactlist;
    }
    public int updatecontact(SQLcontact contact){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(keyname,contact.getName());
        values.put(keyphonenumber,contact.getPhno());

        return db.update(tablecontacts,values,keyid+" = ?",new String[]{String.valueOf(contact.getId())});

    }
    public  void deletecontact(SQLcontact contact){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(tablecontacts,keyid+" = ?",new String[]{String.valueOf(contact.getId())});
        db.close();

    }
    public int getcontactscount(){
        String countquery="SELECT * FROM " + tablecontacts;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(countquery,null);
        cursor.close();
        return (cursor.getCount());
    }

}
