package com.epicodus.checkup.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.epicodus.checkup.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMedAdd extends Fragment {


    public FragmentMedAdd() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_med_add, container, false);
    }

}
