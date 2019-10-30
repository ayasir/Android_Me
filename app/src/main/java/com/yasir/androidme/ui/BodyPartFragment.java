package com.yasir.androidme.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yasir.androidme.R;
import com.yasir.androidme.data.AndroidImageAssets;

public class BodyPartFragment extends Fragment {

    public BodyPartFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_body_part,container,false);
        ImageView imageView = view.findViewById(R.id.body_part_image_view);

        imageView.setImageResource(AndroidImageAssets.getBodies().get(0));

        return view;
    }
}
