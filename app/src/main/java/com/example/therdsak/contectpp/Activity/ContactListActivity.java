package com.example.therdsak.contectpp.Activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.therdsak.contectpp.Model.Contact;
import com.example.therdsak.contectpp.Model.ContactLab;
import com.example.therdsak.contectpp.R;

import java.util.List;

/**
 * Created by Therdsak on 8/9/2016.
 */
public class ContactListActivity extends SingleFragmentActivity implements ContactListFragment.Callback,ContactEditFragment.Callback{
    @Override
    protected Fragment onCreateFragment() {
        return new ContactListFragment();
    }

    @Override
    public void onContactSelect(Contact contact) {
        //
    }


    @Override
    public void onContactUpdate() {
        //Update List
        ContactListFragment listFragment = (ContactListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }

    @Override
    public void onContactDelete() {
        //Delete List
//        List<Contact> contacts = ContactLab.getInstance(this).getContacts();
        ContactListFragment listFragment = (ContactListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container);

        ContactEditFragment editFragment =(ContactEditFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contact_delete);

        getSupportFragmentManager().beginTransaction().detach(editFragment).commit();
        listFragment.updateUI();

    }
}
