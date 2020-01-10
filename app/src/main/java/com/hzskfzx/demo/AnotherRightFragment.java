package com.hzskfzx.demo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * @author Roy
 */
public class AnotherRightFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_another_right, container, false);
        View view=inflater.inflate(R.layout.fragment_another_right,container,false);
        return  view;
    }

}
