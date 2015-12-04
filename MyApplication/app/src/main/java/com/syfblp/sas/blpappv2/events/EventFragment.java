package com.syfblp.sas.blpappv2.events;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.syfblp.sas.blpappv2.R;


public class EventFragment extends Fragment {

    public static EventFragment newInstance(){
        EventFragment fragment= new EventFragment();
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater,ViewGroup containter,Bundle savedInstanceState){
        View rootview= inflater.inflate(R.layout.fragment_event,containter,false);
        // write code here before return
        //remember to use rootview.findViewById for any design you want to link
        return rootview;
    }

}
