package com.syfblp.sas.testfortab.function;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.syfblp.sas.testfortab.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 212464350 on 12/9/2015.
 */
public class FunctionFilter extends Fragment {
    ListView listView;
    private Spinner spinner1;
    ArrayAdapter<String> adapter;
    //  private Spinner spinner2;
    public static FunctionFilter newInstance() {
        FunctionFilter fragment = new FunctionFilter();
        return fragment;
    }
List<String> peopleArray=new ArrayList<String>();

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle bundle){
        final View rootview= inflater.inflate(R.layout.function_layout, container, false);
        peopleArray.add("ramon");
        peopleArray.add("joanne");
        spinner1 = (Spinner) rootview.findViewById(R.id.spinner);
        spinner1.setOnItemSelectedListener(new FunctionSelector());

        List<String> list = new ArrayList<String>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(rootview.getContext(),android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
        return rootview;
    }

    private boolean checkUnique(String lvnames, ArrayList<String> location) {
        boolean unique=true;
        for (int i=0; 0<location.indexOf(lvnames);i++) {
            if (location.get(i).equals(lvnames)) {
                unique = false;
                break;
            }
        }

        for (int y=location.indexOf(lvnames)+1; y<location.size();y++){
            if (location.get(y).equals(lvnames)){
                unique=false;
                break;
            }
        }


        return unique;
    }
}
