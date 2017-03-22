package com.example.ashraf.daysix;

/**
 * Created by ashraf on 21/3/17.
 */

public class SQLcontact {
    int id;
    String name;
    String phno;
    public SQLcontact()
    {

    }

    public SQLcontact(int id, String name, String phno) {
        this.id=id;
        this.name=name;
        this.phno=phno;
    }

    public SQLcontact(String name, String phno) {
        this.name=name;
        this.phno=phno;
    }

    public SQLcontact(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    
    
    
}
