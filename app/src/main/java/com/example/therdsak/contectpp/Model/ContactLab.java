package com.example.therdsak.contectpp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.therdsak.contectpp.DataBase.ContactDbSchema;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Therdsak on 8/9/2016.
 */
public class ContactLab {

    private static ContactLab instance;

    public static ContactLab getInstance(Context context){
        if(instance == null){
            instance = new ContactLab(context);
        }
        return instance;
    }

    public static ContentValues getContentValues(Contact contact){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Conta);
    }

    private Context context;
    private SQLiteDatabase database;

    private ContactLab(Context context){
        this.context = context.getApplicationContext();
    }

    public ContactDbSchema queryCrimes(String whereClause, String[] whereArgs){
        Cursor cursor = database.query(null, null, whereClause, whereArgs,null,
                null,null);
        return new ContactDbSchema();
    }

    public List<Contact> getContacts(){
        List<Contact> contacts = new ArrayList<>();
        ContactDbSchema cursor = queryCrimes(null, null);

        try{

        }finally {

        }
        return contacts;
    }

    public void addCrime(Contact contact){
        ContentValues contentValues = getConten
    }
}
