package com.example.therdsak.contectpp.DataBase;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.therdsak.contectpp.Model.Contact;
import com.example.therdsak.contectpp.DataBase.ContactBaseHelper.ContactTable;

import java.util.UUID;

/**
 * Created by Therdsak on 8/9/2016.
 */
public class ContactCursorWrapper extends CursorWrapper {

    /**
     *  It's poxy
     */
    public ContactCursorWrapper(Cursor cursor) {super(cursor);}


    public Contact getContact(){
        String uuidString = getString(getColumnIndex(ContactTable.Cols.UUID));
        String name = getString(getColumnIndex(ContactTable.Cols.NAME));
        String numberPhone = getString(getColumnIndex(ContactTable.Cols.NUMBER_PHONE));
        String email = getString(getColumnIndex(ContactTable.Cols.EMAIL));

        Contact contact = new Contact(UUID.fromString(uuidString));
        contact.setContactName(name);
        contact.setContactTelNumber(numberPhone);
        contact.setContactEmail(email);

        return contact;
    }

}
