package com.syfblp.sas.blpappv2.directory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.syfblp.sas.blpappv2.R;

import java.util.ArrayList;

/**
 * Created by 212404526 on 11/26/2015.
 */
public class PersonAdapter extends ArrayAdapter<Person> {
    public PersonAdapter(Context context, ArrayList<Person> people) {
        super(context, 0, people);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data item for this position
        Person person = getItem(position);
        //Check of an existing row is being reused, otherwise inflate the view
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.content_person, parent, false);
        }
        //lookup view for data population
        TextView blpName = (TextView) convertView.findViewById(R.id.blpName);
        TextView blpLocation = (TextView) convertView.findViewById(R.id.blpLocation);
        //Populate the data into the template view using the data object
        blpName.setText(person.firstName + " " + person.lastName);
        blpLocation.setText(person.location);
        //Return the view to render on screen
        return convertView;
    }


}
