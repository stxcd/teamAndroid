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

    private PersonAdapter adapter;

    public static final String KEY_FIRSTNAME = "firstName";
    public static final String KEY_LASTNAME = "lastName";
    public static final String KEY_LOCATION = "location";
    public static final String KEY_FUNCTION = "function";
    public static final String KEY_ROLE = "role";
    public static final String KEY_AL = "al";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_EMAIL = "email";
    
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
