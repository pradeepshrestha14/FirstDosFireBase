package com.example.bikramkoju.firebaseexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Bikramkoju on 4/6/2017.
 */


public class AddFragment extends Fragment {
    EditText id,name,phone;
    Button submit;
    DatabaseReference mDatabaseReference;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.add_fragment,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDatabaseReference= FirebaseDatabase.getInstance().getReference().child("posts");

        id=(EditText)view.findViewById(R.id.iid);
        name=(EditText)view.findViewById(R.id.name);
        phone=(EditText)view.findViewById(R.id.phone);
        submit=(Button)view.findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mid=id.getText().toString();
                String mname=name.getText().toString();
                String mphone=phone.getText().toString();

                DatabaseReference newpost=mDatabaseReference.push();
                newpost.child("ID").setValue(mid);
                newpost.child("Name").setValue(mname);
                newpost.child("Phone").setValue(mphone);

            }
        });


    }
}
