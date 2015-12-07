package com.syfblp.sas.blpappv2.directory;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.syfblp.sas.blpappv2.R;


/**
 * Created by 212464350 on 11/24/2015.
 */
public class DirectoryFragment extends Fragment {

    public static DirectoryFragment newInstance(){
        DirectoryFragment fragment=new DirectoryFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater,ViewGroup containter,Bundle savedInstanceState){
        View rootview= inflater.inflate(R.layout.fragment_import,containter,false);
        // write code here before return
        //remember to use rootview.findViewById for any design you want to link
        return rootview;
    }
}
