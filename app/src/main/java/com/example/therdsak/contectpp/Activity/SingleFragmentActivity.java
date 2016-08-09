package com.example.therdsak.contectpp.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.therdsak.contectpp.R;

/**
 * Created by Nutdanai on 8/9/2016.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list_activity);

        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.fragment_container);
        if(f == null){
            f = onCreateFragment();
            fm.beginTransaction().add(R.id.fragment_container,f).commit();
            //
        }else{
            //
        }
    }
    protected abstract Fragment onCreateFragment();
}
