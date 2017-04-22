package com.example.bikramkoju.firebaseexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Bikramkoju on 4/6/2017.
 */

public class ViewFragment extends Fragment {
    RecyclerView mView;
    DatabaseReference mDatabaseReference;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.view_fragment,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mView=(RecyclerView)view.findViewById(R.id.myView);

        mDatabaseReference= FirebaseDatabase.getInstance().getReference().child("posts");
        mView.setLayoutManager(new LinearLayoutManager(getActivity()));
        FirebaseRecyclerAdapter<Module, PostViewHolder> firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<Module, PostViewHolder>(Module.class,R.layout.singleitem,
                        PostViewHolder.class, mDatabaseReference) {
                    @Override
                    protected void populateViewHolder(PostViewHolder viewHolder, final Module model, int position) {
                        viewHolder.setId(model.getID());
                       // Log.e("id",String.valueOf(model.getID()));
                        viewHolder.setName(model.getName());
                        viewHolder.setPhone(model.getPhone());



                    }
                };
                mView.setAdapter(firebaseRecyclerAdapter);
    }
    public static class PostViewHolder extends RecyclerView.ViewHolder{
        View v;
        String id,name,phone;

        public PostViewHolder(View itemView) {
            super(itemView);
            v=itemView;
        }

        public void setId(String id) {
            TextView showid=(TextView)v.findViewById(R.id.displayid);
            showid.setText("ID="+id);

        }

        public void setName(String name) {
            TextView showname=(TextView)v.findViewById(R.id.displayname);
            showname.setText("Name="+name);

        }

        public void setPhone(String phone) {
            TextView showphone=(TextView)v.findViewById(R.id.displayphone);
            showphone.setText("Phone="+phone);

        }
    }
}
