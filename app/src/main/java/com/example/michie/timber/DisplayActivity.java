package com.example.michie.timber;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.michie.timber.domain.Profile;
import com.example.michie.timber.domain.TinderCard;
import com.mindorks.placeholderview.PlaceHolderView;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {
    private PlaceHolderView mListView;
    private Context mContext;

    ArrayList<Profile> accepted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        accepted = getIntent().getParcelableArrayListExtra("accepted");
        mContext = getApplicationContext();



        mListView = (PlaceHolderView) findViewById(R.id.list);


        for(Profile profile : accepted){
            mListView.addView(new TinderCard(mContext, profile, null, null));
        }
    }
}
