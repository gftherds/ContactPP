package com.example.therdsak.contectpp.Activity;


import android.support.v4.app.Fragment;

import com.example.therdsak.contectpp.Model.Contact;

/**
 * Created by Therdsak on 8/9/2016.
 */
public class ContactActivity extends SingleFragmentActivity implements ContactListActivity.CallBack {
    @Override
    protected Fragment onCreateFragment() {
        return new ContactListFragment();
    }

    @Override
    public void onContactSelect(Contact contact) {
        //
    }
}
