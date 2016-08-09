package com.example.therdsak.contectpp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.example.therdsak.contectpp.DataBase.ContactBaseHelper;
import com.example.therdsak.contectpp.DataBase.ContactCursorWrapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.therdsak.contectpp.DataBase.ContactBaseHelper.ContactTable;

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
        contentValues.put(ContactTable.Cols.UUID, contact.getContactId().toString());
        contentValues.put(ContactTable.Cols.NAME, contact.getContactName());
        contentValues.put(ContactTable.Cols.NUMBER_PHONE, contact.getContactTelNumber());
        contentValues.put(ContactTable.Cols.EMAIL, contact.getContactEmail());
        return contentValues;
    }

    private Context context;
    private SQLiteDatabase database;

    private ContactLab(Context context){
        this.context = context.getApplicationContext();
    }

    public ContactCursorWrapper queryCrimes(String whereClause, String[] whereArgs){
        Cursor cursor = database.query(null, null, whereClause, whereArgs,null,
                null,null);
        return new ContactCursorWrapper(cursor);
    }

    public List<Contact> getContacts(){
        List<Contact> contacts = new ArrayList<>();
        ContactCursorWrapper cursor = queryCrimes(null, null);

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
        String contactIdString = contact.getContactId().toString();
        ContentValues contentValues = getContentValues(contact);
        database.update(ContactTable.NAMEDB, contentValues, ContactTable.Cols.UUID + " = ? ",
                new String[] { contactIdString});
    }

    public File getPhotoFile(Contact contact){
        File externalFileDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if(externalFileDir == null){
            return null;
        }
        return new File(externalFileDir, contact.getPhotoFileName());
    }
}
