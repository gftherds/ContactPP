package com.example.therdsak.contectpp.Model;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Therdsak on 8/9/2016.
 */
public class DialogDelete extends DialogFragment {

    public static DialogDelete newInstance(String string) {


        Bundle args = new Bundle();
        DialogDelete fragment = new DialogDelete();
        args.putSerializable("ARG_DELETE", string);
        fragment.setArguments(args);
        return fragment;

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_delete, null);
        builder.setMessage("Write your message here.");
        builder.setCancelable(true);

        builder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        builder.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();

    }


}
