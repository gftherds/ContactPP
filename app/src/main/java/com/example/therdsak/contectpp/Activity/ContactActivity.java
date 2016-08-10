package com.example.therdsak.contectpp.Activity;


import android.support.v4.app.Fragment;


/**
 * Created by Therdsak on 8/9/2016.
 */
public class ContactActivity extends SingleFragmentActivity implements ContactEditFragment.Callback {

    @Override
    protected Fragment onCreateFragment() {
        return new ContactEditFragment();
    }


    @Override
    public void onContactUpdate() {
        //TODO I will do when I want.
    }

    @Override
    public void onContactDelete() {
        finish();
    }
}
