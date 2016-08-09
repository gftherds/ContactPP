package com.example.therdsak.contectpp.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.therdsak.contectpp.DataBase.ContactBaseHelper.ContactTable;

/**
 * Created by Therdsak on 8/9/2016.
 */
public class ContactDbSchema extends SQLiteOpenHelper{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME ="DatabaseContact";


    public ContactDbSchema(Context context) { super(context, DATABASE_NAME, null, VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + ContactTable.NAMEDB
                + "("
                + "_id integer primary key autoincrement, "
                + ContactTable.Cols.UUID + ","
                + ContactTable.Cols.NAME + ","
                + ContactTable.Cols.NUMBER_PHONE + ","
                + ContactTable.Cols.EMAIL + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //
    }
}
