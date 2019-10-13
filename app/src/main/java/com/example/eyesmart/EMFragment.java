package com.example.eyesmart;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eyesmart.entity.Employee;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint({"ValidFragment"})
public class EMFragment extends Fragment  {
    private View view;
    private SwitchCompat sc_sex;
    public ImageView iv_face_photo;
    public TextView tv_name;
    public TextView tv_empno;
    public TextView tv_idcard;

    public Employee emp;
    public EMFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TextView textView = new TextView(getActivity());
        //textView.setText(R.string.hello_blank_fragment);
        view = inflater.inflate(R.layout.fragment_em,container,false);
        return view;
    }

}
