package com.yasir.androidme.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yasir.androidme.R;


import java.util.ArrayList;
import java.util.List;

public class LegPartFragment extends Fragment {

    private static final String TAG = "Leg Fragment";
    private static final String IMAGE_ID_LIST = "Image Ids";
    private static final String LIST_INDEX = "List Index";

    private List<Integer> mImageIds;
    private int mListIndex;

    public LegPartFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }
        View view = inflater.inflate(R.layout.fragment_leg_part,container,false);

        final ImageView imageView = view.findViewById(R.id.leg_part_image_view);

        if(mImageIds != null){

            imageView.setImageResource(mImageIds.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(mListIndex < mImageIds.size() - 1){
                        mListIndex++;

                    }else{
                        mListIndex =0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        }else{
            Log.d(TAG, "This fragment has null list of ids");
        }
        return view;
    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(IMAGE_ID_LIST,(ArrayList<Integer>)mImageIds);
        outState.putInt(LIST_INDEX,mListIndex);
    }
}
