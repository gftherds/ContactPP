package com.example.therdsak.contectpp.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.therdsak.contectpp.Model.Contact;
import com.example.therdsak.contectpp.Model.ContactLab;
import com.example.therdsak.contectpp.R;

import java.io.File;
import java.util.List;

/**
 * Created by Therdsak on 8/9/2016.
 */
public class ContactListFragment extends Fragment {

    private RecyclerView _contactRecyclerView;
    private ContactAdapter _adapter;

    private Callback callback;

    public interface Callback{
        void  onContactSelect(Contact contact);
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

    private File photoFile;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contact_fragment_list, container, false);

        _contactRecyclerView = (RecyclerView) v.findViewById(R.id.contact_recycler_view);
        _contactRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        updateUI();
        return v;
    }

    public void updateUI(){
        ContactLab contactLab = ContactLab.getInstance(getActivity());
        List<Contact> contacts = contactLab.getContacts();
        if(_adapter == null){
            _adapter = new ContactAdapter(contacts, this);
            _contactRecyclerView.setAdapter(_adapter);
        }else{
            _adapter.setContacts(contactLab.getContacts());
            _adapter.notifyDataSetChanged();
        }
    }

    private class ContactHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        public ImageView _imageView;
        public TextView _nameTextView;

        Contact _contact;
        int _position;

        public ContactHolder(View itemView) {
            super(itemView);
            _imageView = (ImageView) itemView.findViewById(R.id.image_list_view);
            _nameTextView = (TextView) itemView.findViewById(R.id.list_item_btn);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(Contact contact, int _position){
            _contact = contact;
            photoFile = ContactLab.getInstance(getActivity()).getPhotoFile(_contact);

//            _imageView.setImageBitmap();

            _nameTextView.setText(_contact.getContactName());
            _position = _position;
        }

        @Override
        public void onClick(View view) {
            //function Call contact
        }

        @Override
        public boolean onLongClick(View view){
            return true;
        }
    }

    private class ContactAdapter extends RecyclerView.Adapter<ContactHolder>{
        private List<Contact> _contact;
        private int viewCreatingCount;
        private Fragment _f;

        public ContactAdapter(List<Contact> contacts, Fragment f){
            _contact = contacts;
            _f = f;
        }

        public void setContacts(List<Contact> contacts){
            _contact = contacts;
        }

        @Override
        public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            viewCreatingCount++;
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater.inflate(R.layout.contact_list_item, parent, false);

            return new ContactHolder(v);

        }

        @Override
        public void onBindViewHolder(ContactHolder holder, int position) {
            Contact contact = _contact.get(position);
            holder.bind(contact, position);
        }

        @Override
        public int getItemCount() {
            return _contact.size();
        }
    }
}
