package com.example.ashraf.loginday6;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by ashraf on 20/3/17.
 */

public class UserSession {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int pm=0;
    private static final String prefername="appuser";
    private static final String isuserlogin="isuserlogin";
    private static final String keyname="email";
    private static final String keypass="pass";
    public UserSession(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(prefername, pm);
        // editor=pref.edit();
        editor = pref.edit();
    }
     public void createUserLoginSession(String uname,String pass)
    {
        editor.putBoolean(isuserlogin,true);
        editor.putString(keyname,uname);
        editor.putString(keypass,pass);
        editor.commit();

    }
    public HashMap<String,String>
    getUserDetails(){
        HashMap<String ,String>
                user=new HashMap<>();
        user.put(keyname,pref.getString(keyname,null));
        user.put(keypass,pref.getString(keypass,null));
        return user;
    }
    public boolean checklogin(){
        if (!this.isuserlogin()) {
            return  true;
        }
        else
            return false;
        }
        public boolean isuserlogin(){
            return pref.getBoolean(isuserlogin,false);
        }
        public void logoutuser(){
            editor.clear();
            editor.commit();
        }
    }





