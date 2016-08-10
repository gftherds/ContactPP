package com.example.therdsak.contectpp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.therdsak.contectpp.Model.Contact;
import com.example.therdsak.contectpp.Model.ContactLab;
import com.example.therdsak.contectpp.Model.ContactPictureUnit;
import com.example.therdsak.contectpp.Model.DialogDelete;
import com.example.therdsak.contectpp.Model.ContactPictureUnit;
import com.example.therdsak.contectpp.R;

import java.io.File;
import java.util.UUID;

/**
 * Created by Therdsak on 8/9/2016.
 */
public class ContactEditFragment extends Fragment  {
    private static final String CONTACT_ID = "ContactEditFragment.CONTACT_ID";
    private static final String DIALOG_DELETE = "ContactEditFragment.DIALOG_DELETE";
    private static final int REQUEST_CAPTURE_PHOTO = 1234;
    private File photoFile;

    public ContactEditFragment() {

    }

    private EditText editText;
    private EditText editPhone;
    private EditText editEmail;
    private Button deleteButton;
    private ImageButton photoButton;
    private ImageView photoView;
    private String deletestring;
    protected Callback callback;
    protected Contact contact;


    public interface Callback{
        void onContactUpdate();
        void onContactDelete();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (Callback) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    public static ContactEditFragment newInstance(UUID contactId) {
        Bundle args = new Bundle();
        args.putSerializable(CONTACT_ID, contactId);
        ContactEditFragment contactEditFragment = new ContactEditFragment();
        contactEditFragment.setArguments(args);
        return contactEditFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ContactLab contactLab = ContactLab.getInstance(getActivity());
        UUID contactID = (UUID) getArguments().getSerializable(CONTACT_ID);
        contact = ContactLab.getInstance(getActivity()).getContactById(contactID);


        photoFile = ContactLab.getInstance(getActivity()).getPhotoFile(contact);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contact_edit_activity, container, false);

        editText = (EditText) v.findViewById(R.id.contact_name);
        editText.setText(contact.getContactName());
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                contact.setContactName(s.toString()); //TODO now
                updateContact();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editPhone = (EditText) v.findViewById(R.id.contact_phone);
        editPhone.setText(contact.getContactName());
        editPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                contact.setContactTelNumber(s.toString());
                updateContact();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editEmail = (EditText) v.findViewById(R.id.contact_e_mail);
        editEmail.setText(contact.getContactName());
        editEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                contact.setContactEmail(s.toString());
                updateContact();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        deleteButton = (Button) v.findViewById(R.id.contact_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactLab.getInstance(getActivity()).deleteContact(contact.getContactId());
                getActivity().finish();

                FragmentManager fm = getFragmentManager();
                DialogDelete dialogDelete = DialogDelete.newInstance(contact.getContactId());
                dialogDelete.show(fm, DIALOG_DELETE);

            }
        });

        //call camera intent
        final Intent captureImageIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        PackageManager packageManager = getActivity().getPackageManager();
        if (packageManager.resolveActivity(captureImageIntent, PackageManager.MATCH_DEFAULT_ONLY) == null) {

            photoButton.setEnabled(false);
        }


        // check if we can take photo
        boolean canTakePhoto = photoFile != null && captureImageIntent.resolveActivity(packageManager) != null;


        if (canTakePhoto) {


            Uri uri = Uri.fromFile(photoFile);
            captureImageIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

        }

        photoButton = (ImageButton) v.findViewById(R.id.contact_camera);
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityForResult(captureImageIntent, REQUEST_CAPTURE_PHOTO);
            }
        });

        photoView = (ImageView) v.findViewById(R.id.contact_photo);
        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        updatePhotoView();
        return v;
    }


    @Override
    public void onPause() {
        super.onPause();
        updateContact();
    }

    private void updateContact() {
        ContactLab.getInstance(getActivity()).updateContact(contact);

//        if(ContactEditFragment.this.isResumed())

    }

    private void updatePhotoView() {
        if (photoView == null || !photoFile.exists()) {
            photoView.setImageDrawable(null);
        } else {
            Bitmap bitmap = ContactPictureUnit.getScaleBitmap(photoFile.getPath(), getActivity());

            photoView.setImageBitmap(bitmap);
        }
    }

}
