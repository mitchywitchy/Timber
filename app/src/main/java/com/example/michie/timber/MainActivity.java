package com.example.michie.timber;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.michie.timber.R;
import com.example.michie.timber.Utils;
import com.example.michie.timber.domain.Profile;
import com.example.michie.timber.domain.TinderCard;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;
    private ArrayList<Profile> accepted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accepted = new ArrayList<>();

        mSwipeView = (SwipePlaceHolderView)findViewById(R.id.swipeView);
        mContext = getApplicationContext();

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));


        for(Profile profile : Utils.loadProfiles(this.getApplicationContext())){
            mSwipeView.addView(new TinderCard(mContext, profile, mSwipeView, accepted));
        }

        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(false);
            }
        });

        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(true);
            }
        });
        //what happens when you click the buttons, Menu button
        findViewById(R.id.menuBtn).setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick (View v){
                    Intent displayIntent = new Intent(mContext, DisplayActivity.class);
                    displayIntent.putParcelableArrayListExtra("accepted", accepted);
                    startActivity(displayIntent);
            }
        });
    }
}