package com.yasir.androidme.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yasir.androidme.R;
import com.yasir.androidme.data.AndroidImageAssets;


public class MasterListFragment extends Fragment {

    private MasterListAdapter masterListAdapter;

    private Context context;

    private OnImageClickListener mCallback;
    public MasterListFragment(){}

    public MasterListFragment(Context context){
        this.context = context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_master_list,container,false);

        GridView gridView = view.findViewById(R.id.master_fragment_list_grid_view);
        masterListAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        gridView.setAdapter(masterListAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCallback.onImageSelected(i);
            }
        });
        return view;
    }


    public interface OnImageClickListener {
        public void onImageSelected(int position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            mCallback = (OnImageClickListener) context;

        }catch (ClassCastException exception){
            throw  new ClassCastException(context.toString()
            +"must implement OnImageClickListener");
        }
    }
}
