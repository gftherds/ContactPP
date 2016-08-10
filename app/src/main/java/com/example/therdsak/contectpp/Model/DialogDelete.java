package com.example.therdsak.contectpp.Model;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.example.therdsak.contectpp.Activity.ContactListFragment;
import com.example.therdsak.contectpp.R;
import com.example.therdsak.contectpp.Activity.ContactEditFragment.Callback;

import java.util.UUID;

/**
 * Created by Therdsak on 8/9/2016.
 */
public class DialogDelete extends DialogFragment {
    private static final String REQUEST_DELETE = "ARG_DELETE" ;
    private Callback callback;
    private UUID uuid;

    public static DialogDelete newInstance(UUID uuid) {
        Bundle args = new Bundle();
        DialogDelete fragment = new DialogDelete();
        args.putSerializable(REQUEST_DELETE, uuid);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_delete, null);
        uuid = (UUID) getArguments().getSerializable(REQUEST_DELETE);
        callback = (Callback) getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);
        builder.setMessage("Write your message here.");
        builder.setCancelable(true);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ContactLab.getInstance(getActivity()).deleteContact(uuid);
                        callback.onContactDelete();
                        dialog.dismiss();
                    }
                });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();

    }


}
