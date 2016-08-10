package com.example.therdsak.contectpp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;


import com.example.therdsak.contectpp.DataBase.ContactBaseHelper;
import com.example.therdsak.contectpp.DataBase.ContactCursorWrapper;
import com.example.therdsak.contectpp.DataBase.ContactDbSchema.ContactTable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by Therdsak on 8/9/2016.
 */
public class ContactLab {
    private static ContactLab instance;

    //////////////////////////////////////////// STATIC ZONE ////////////////////////////////////////////////
    public static ContactLab getInstance(Context context){
        if(instance == null){
            instance = new ContactLab(context);
        }
        return instance;
    }

    public static ContentValues getContentValues(Contact contact){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactTable.Cols.UUID, contact.getContactId().toString());
        contentValues.put(ContactTable.Cols.NAME, contact.getContactName());
        contentValues.put(ContactTable.Cols.NUMBER_PHONE, contact.getContactTelNumber());
        contentValues.put(ContactTable.Cols.EMAIL, contact.getContactEmail());
        return contentValues;
    }

    //////////////////////////////////////////// ??? METHOD ??? ////////////////////////////////////////////////
    private Context context;
    private SQLiteDatabase database;

    private ContactLab(Context context){
        this.context = context.getApplicationContext();
        ContactBaseHelper crimeBaseHelper = new ContactBaseHelper(this.context);
        database = crimeBaseHelper.getWritableDatabase();
    }

    public ContactCursorWrapper queryContact(String whereClause, String[] whereArgs){
        Cursor cursor = database.query(ContactTable.NAMEDB, null, whereClause, whereArgs,null,
                null,null);
        return new ContactCursorWrapper(cursor);
    }


    public Contact getContactById(UUID uuid){
        ContactCursorWrapper cursor = queryContact(ContactTable.Cols.UUID + " = ? ", new String[] { uuid.toString()});
        try{
            if(cursor.getCount() == 0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getContact();
        }
        finally {
            cursor.close();
        }
    }

    public List<Contact> getContacts(){
        List<Contact> contacts = new ArrayList<>();
        ContactCursorWrapper cursor = queryContact(null, null);
        try{
            cursor.moveToFirst();
            while ((!cursor.isAfterLast())) {
                contacts.add(cursor.getContact());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return contacts;
    }

    public void addContact(Contact contact){
        ContentValues contentValues = getContentValues(contact);
        database.insert(ContactTable.NAMEDB, null, contentValues);
    }

    public  void deleteContact(UUID contactId){
        database.delete(ContactTable.NAMEDB, ContactTable.Cols.UUID + " = ? ",
                new String[]{contactId.toString()});
    }



    public void updateContact(Contact contact){
        String uuidStr = contact.getContactId().toString();
        ContentValues contentValues = getContentValues(contact);

        database.update(ContactTable.NAMEDB, contentValues, ContactTable.Cols.UUID + " = ? ", new String[]{ uuidStr });

    }

    public File getPhotoFile(Contact contact){
        File externalFileDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if(externalFileDir == null){
            return null;
        }
        return new File(externalFileDir, contact.getPhotoFileName());
    }


}
