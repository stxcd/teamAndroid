package com.syfblp.sas.testfortab.function;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.syfblp.sas.testfortab.R;
import com.syfblp.sas.testfortab.ServiceHandler;
import com.syfblp.sas.testfortab.directory.Person;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 212464350 on 11/4/2015.
 */
public class FunctionSelector implements android.widget.AdapterView.OnItemSelectedListener {
    private static final String JSON = "directory" ;
    private static final String FIRST_NAME = "firstName" ;
    private static final String ID = "id" ;
    private static final String LAST_NAME = "lastName" ;
    private static final String PHONE = "phone" ;
    private static final String FUNCTION = "function" ;
    private static final String EMAIL = "email" ;
    private static final String ROTATION = "role" ;
    private static final String LOCAL = "location" ;
    private static final String ASSILEAD = "al" ;
    private static final String UNIVERSITY="university";
    private static String url = "https://uat.onlinecreditcenter6.com/cs/groups/cmswebsite/documents/websiteasset/directory_android.json" ;
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        ListView listView=(ListView) parent.getRootView().findViewById(R.id.listView);
        String check= parent.getItemAtPosition(position).toString();
        if(check.equals("list 1")){

            ArrayAdapter<String> adapter = new ArrayAdapter<>(parent.getContext(), android.R.layout.simple_list_item_1, peopleArray);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    private class JSONParse extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject json = new JSONObject(jsonStr);

                    // Getting JSON Array
                    personArray = json.getJSONArray(JSON);
                    for (int i = 0; i < personArray.length(); i++) {
                        JSONObject c = personArray.getJSONObject(i);
                        // Storing  JSON item in a Variable
                        String id = c.getString(ID);
                        String fName = c.getString(FIRST_NAME);
                        String lName = c.getString(LAST_NAME);
                        String phone = c.getString(PHONE);
                        String function = c.getString(FUNCTION);
                        String email = c.getString(EMAIL);
                        String rotation = c.getString(ROTATION);
                        String local = c.getString(LOCAL);
                        String assilead = c.getString(ASSILEAD);
                        String university=c.getString(UNIVERSITY);
                        Person housing = new Person(id, fName, lName, local, function, rotation, assilead, email, phone,university);
                        input.add(housing);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }


    }