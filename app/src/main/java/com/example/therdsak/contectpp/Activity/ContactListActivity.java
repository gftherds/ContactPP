package com.example.therdsak.contectpp.Activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.therdsak.contectpp.Model.Contact;

/**
 * Created by Therdsak on 8/9/2016.
 */
public class ContactListActivity extends SingleFragmentActivity implements ContactListFragment.Callback{
    @Override
    protected Fragment onCreateFragment() {
        return new ContactListFragment();
    }

    @Override
    public void onContactSelect(Contact contact) {
        //
    }


}
