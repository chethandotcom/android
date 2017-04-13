package com.chethan.navigationdrawerexample.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chethan.navigationdrawerexample.R;

public class GalleryFragment extends Fragment {

    public GalleryFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.text_view);
        textView.setText(getResources().getText(R.string.gallery));

        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}