package com.apps.shreya.chatapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Shreya on 16/11/2018.
 */

public class HomeFragment extends Fragment {

    private RecyclerView mConvList;
    private DatabaseReference mConvDatabase;
    private DatabaseReference mMessageDatabase;
    private DatabaseReference mUsersDatabase;

    private FirebaseAuth mAuth;

    private String mCurrent_user_id;

    private View mMainView;

    public HomeFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_home, container, false);
/*
        mConvList = (RecyclerView) mMainView.findViewById(R.id.conv_list);
        mAuth = FirebaseAuth.getInstance();

        mCurrent_user_id = mAuth.getCurrentUser().getUid();

        mConvDatabase = FirebaseDatabase.getInstance().getReference().child("Chat").child(mCurrent_user_id);

        mConvDatabase.keepSynced(true);
        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        mMessageDatabase = FirebaseDatabase.getInstance().getReference().child("messages").child(mCurrent_user_id);
        mUsersDatabase.keepSynced(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);

        mConvList.setHasFixedSize(true);
        mConvList.setLayoutManager(linearLayoutManager);


        // Inflate the layout for this fragment
        return mMainView;

*/
        /* -------------------------------------------------------------------------*/

/*
        @Override
        public void onStart() {
            super.onStart();

            Query conversationQuery = mConvDatabase.orderByChild("timestamp");

            FirebaseRecyclerAdapter<Conv, ConvViewHolder> firebaseConvAdapter = new FirebaseRecyclerAdapter<Conv, ConvViewHolder>(
                    Conv.class,
                    R.layout.users_single_layout,
                    ConvViewHolder.class,
                    conversationQuery
            ) {
                @Override
                protected void populateViewHolder(final ConvViewHolder convViewHolder, final Conv conv, int i) {



                    final String list_user_id = getRef(i).getKey();

                    Query lastMessageQuery = mMessageDatabase.child(list_user_id).limitToLast(1);

                    lastMessageQuery.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                            String data = dataSnapshot.child("message").getValue().toString();
                            convViewHolder.setMessage(data, conv.isSeen());

                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                    mUsersDatabase.child(list_user_id).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            final String userName = dataSnapshot.child("name").getValue().toString();
                            String userThumb = dataSnapshot.child("thumb_image").getValue().toString();

                            if(dataSnapshot.hasChild("online")) {

                                String userOnline = dataSnapshot.child("online").getValue().toString();
                                convViewHolder.setUserOnline(userOnline);

                            }

                            convViewHolder.setName(userName);
                            convViewHolder.setUserImage(userThumb, getContext());

                            convViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {


                                    Intent chatIntent = new Intent(getContext(), UsersActivity.class);
                                    chatIntent.putExtra("user_id", list_user_id);
                                    chatIntent.putExtra("user_name", userName);
                                    startActivity(chatIntent);

                                }
                            });


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }
            };

            mConvList.setAdapter(firebaseConvAdapter);

        }

        public static class ConvViewHolder extends RecyclerView.ViewHolder {

            View mView;

            public ConvViewHolder(View itemView) {
                super(itemView);

                mView = itemView;

            }

            public void setMessage(String message, boolean isSeen){

                TextView userStatusView = (TextView) mView.findViewById(R.id.user_single_status);
                userStatusView.setText(message);

                if(!isSeen){
                    userStatusView.setTypeface(userStatusView.getTypeface(), Typeface.BOLD);
                } else {
                    userStatusView.setTypeface(userStatusView.getTypeface(), Typeface.NORMAL);
                }

            }

            public void setName(String name){

                TextView userNameView = (TextView) mView.findViewById(R.id.user_single_name);
                userNameView.setText(name);

            }

            public void setUserImage(String thumb_image, Context ctx){

                CircleImageView userImageView = (CircleImageView) mView.findViewById(R.id.user_single_image);
                Picasso.get().load(thumb_image).placeholder(R.drawable.default_avatar).into(userImageView);

            }

            public void setUserOnline(String online_status) {

                ImageView userOnlineView = (ImageView) mView.findViewById(R.id.user_single_online_icon);

                if(online_status.equals("true")){

                    userOnlineView.setVisibility(View.VISIBLE);

                } else {

                    userOnlineView.setVisibility(View.INVISIBLE);

                }

            }

        }





}
*/
/*
        public void onCreateOptionsMenu (Menu menu, MenuInflater inflater){
            inflater.inflate(R.menu.menu, menu);
            super.onCreateOptionsMenu(menu, inflater);
        }
        public boolean onOptionsItemSelected (MenuItem item){

            //TO OPEN NEW ACTIVITY ON MENU ITEM CLICK
            Intent intent = new Intent(getActivity(), TopicsActiviy.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.slide_up, R.anim.stay);

            //finish();
            //overridePendingTransition(R.anim.stay, R.anim.slide_down);
            return true;
            //return super.onOptionsItemSelected(item);
     */   }


}

