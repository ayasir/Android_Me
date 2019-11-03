package com.yasir.androidme.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.yasir.androidme.R;
import com.yasir.androidme.data.AndroidImageAssets;

public class MasterListActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{
    private int headImgIndex, bodyImgIndex, legImgIndex;
    private boolean mTwoPane;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_list);

        if(findViewById(R.id.android_me_linear_layout) != null){
            mTwoPane = true;
            if(savedInstanceState == null) {
                // hide next button in case of two pane screeen
                Button nextButton = findViewById(R.id.next_button);
                nextButton.setVisibility(View.GONE);

                GridView gridView = findViewById(R.id.master_fragment_list_grid_view);
                gridView.setNumColumns(2);

                HeadPartFragment headFragment = new HeadPartFragment();
                BodyPartFragment bodyFragment = new BodyPartFragment();
                LegPartFragment legFragment = new LegPartFragment();

                headFragment.setmImageIds(AndroidImageAssets.getHeads());

                bodyFragment.setmImageIds(AndroidImageAssets.getBodies());

                legFragment.setmImageIds(AndroidImageAssets.getLegs());

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .add(R.id.head_container, headFragment)
                        .commit();

                fragmentManager.beginTransaction()
                        .add(R.id.body_container, bodyFragment)
                        .commit();

                fragmentManager.beginTransaction()
                        .add(R.id.leg_container, legFragment)
                        .commit();

            }
        }else{
            mTwoPane = false;
        }

    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(MasterListActivity.this,"image position: "+position,
                Toast.LENGTH_LONG)
                .show();

int bodyPartNumber = position/2;
int listIndex = position -12*bodyPartNumber;

if(mTwoPane){
    // handle two pane case
    HeadPartFragment headPartFragment = new HeadPartFragment();
    BodyPartFragment bodyPartFragment = new BodyPartFragment();
    LegPartFragment legPartFragment = new LegPartFragment();


    switch(bodyPartNumber){
        case 0:
            headPartFragment.setmImageIds(AndroidImageAssets.getHeads());
            headPartFragment.setmListIndex(listIndex);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.head_container,headPartFragment)
                    .commit();
            break;
        case 1:
            bodyPartFragment.setmImageIds(AndroidImageAssets.getHeads());
            bodyPartFragment.setmListIndex(listIndex);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.body_container,bodyPartFragment)
                    .commit();
            break;
        case 2:
            legPartFragment.setmImageIds(AndroidImageAssets.getHeads());
            legPartFragment.setmListIndex(listIndex);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.leg_container,legPartFragment)
                    .commit();
            break;


    }
}else {


    switch (bodyPartNumber) {
        case 0:
            headImgIndex = listIndex;
            break;
        case 1:
            bodyImgIndex = listIndex;
            break;
        case 2:
            legImgIndex = listIndex;
            break;
    }
}


        final Intent intent = new Intent(MasterListActivity.this,MainActivity.class);
        intent.putExtra("headImgIndex",headImgIndex);
        intent.putExtra("bodyImgIndex",bodyImgIndex);
        intent.putExtra("legImgIndex",legImgIndex);

        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
                finish();
            }
        });


    }
}
