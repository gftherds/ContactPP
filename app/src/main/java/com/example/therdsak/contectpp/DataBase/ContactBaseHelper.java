package com.example.therdsak.contectpp.DataBase;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.therdsak.contectpp.Model.Contact;
import com.example.therdsak.contectpp.DataBase.ContactDbSchema.ContactTable;

import java.util.UUID;

/**
 * Created by Therdsak on 8/9/2016.
 */
public class ContactBaseHelper extends CursorWrapper {

    /**
     *  It's poxy
     */
    public ContactBaseHelper(Cursor cursor) {super(cursor);}


    public Contact getContact(){
        String uuidString = getString(getColumnIndex(ContactTable.Cols.UUID));
        String name = getString(getColumnIndex(ContactTable.Cols.NAME));
        int numberphone = getInt(getColumnIndex(ContactTable.Cols.NUMBER_PHONE));
        String email = getString(getColumnIndex(ContactTable.Cols.EMAIL));

        Contact contact = new Contact(UUID.fromString(uuidString));
        contact.setContactName(name);
        contact.setContactTelNumber(numberphone);
        contact.setContactEmail(email);

        return contact;
    }

}
