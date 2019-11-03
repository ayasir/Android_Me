/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.yasir.androidme.ui;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.yasir.androidme.R;
import com.yasir.androidme.data.AndroidImageAssets;


// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        int headImgIndex = bundle.getInt("headImgIndex");
        int bodyImgIndex = bundle.getInt("bodyImgIndex");
        int legImgIndex = bundle.getInt("legImgIndex");

        if(savedInstanceState == null) {
            HeadPartFragment headFragment = new HeadPartFragment();
            BodyPartFragment bodyFragment = new BodyPartFragment();
            LegPartFragment legFragment = new LegPartFragment();

            headFragment.setmImageIds(AndroidImageAssets.getHeads());
//            headFragment.setmListIndex(1);
//
            bodyFragment.setmImageIds(AndroidImageAssets.getBodies());
//            bodyFragment.setmListIndex(1);
//
            legFragment.setmImageIds(AndroidImageAssets.getLegs());
//            legFragment.setmListIndex(1);
            headFragment.setmListIndex(headImgIndex);
            bodyFragment.setmListIndex(bodyImgIndex);
            legFragment.setmListIndex(legImgIndex);

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



    }
}
