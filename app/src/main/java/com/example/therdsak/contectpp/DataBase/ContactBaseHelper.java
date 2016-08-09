package com.example.therdsak.contectpp.DataBase;

import android.content.Context;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.therdsak.contectpp.DataBase.ContactDbSchema.ContactTable;
import com.example.therdsak.contectpp.Model.Contact;

/**
 * Created by Therdsak on 8/9/2016.
 */
public class ContactBaseHelper extends SQLiteOpenHelper{
    private static final int VERSION = 1;
    private static final  String DATABASE_NAME = "contactBase.db";
    private static final String TAG = "CrimeBaseHelper";

    public ContactBaseHelper(Context context) { super(context, DATABASE_NAME, null, VERSION);}


    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table " + CrimeDbSchema.CrimeTable.NAME); //Because I import CrimeDBSchema.
        Log.d(TAG, "CreateDateBase");
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
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //
    }

}
