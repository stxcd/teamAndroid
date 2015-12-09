package com.syfblp.sas.testfortab.location;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by 212464350 on 11/4/2015.
 */
public class LocationSelector implements android.widget.AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}