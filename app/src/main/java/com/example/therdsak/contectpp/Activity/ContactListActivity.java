package com.example.therdsak.contectpp.Activity;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.therdsak.contectpp.Model.Contact;

/**
 * Created by Therdsak on 8/9/2016.
 */
public class ContactListActivity extends Fragment {
    private CallBack callBack;


    protected interface CallBack{
        void onContactSelect(Contact contact);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callBack = (CallBack) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callBack = null ;
    }



    
}
