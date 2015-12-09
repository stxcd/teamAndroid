package com.syfblp.sas.blpappv2.directory;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.syfblp.sas.blpappv2.R;
import com.syfblp.sas.blpappv2.ServiceHandler;
import com.syfblp.sas.blpappv2.housing.HousingFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by 212464350 on 11/24/2015.
 */
public class DirectoryFragment extends Fragment {
    ArrayList<Person> input = new ArrayList<>();
    ArrayList<String> peopleArray = new ArrayList<>();
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
    JSONArray personArray = null;
    ListView listView;
    ArrayAdapter<String> adapter;
    private static String url = "https://uat.onlinecreditcenter6.com/cs/groups/cmswebsite/documents/websiteasset/directory_android.json" ;


    public static DirectoryFragment newInstance() {
        DirectoryFragment fragment = new DirectoryFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup containter, Bundle savedInstanceState) {
        final View rootview = inflater.inflate(R.layout.content_blpdirectory, containter, false);
        new JSONParse().execute();

        adapter = new ArrayAdapter<>(rootview.getContext(), android.R.layout.simple_list_item_1, peopleArray);
        listView = (ListView) rootview.findViewById(R.id.BLPDirectorylistView);



        android.widget.AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {


                Intent intent = new Intent(parent.getContext(), HousingFragment.Profile.class);
                String clickedOnCity = peopleArray.get(position);
                intent.putExtra("snails", clickedOnCity);
                intent.putExtra("json", input);

                startActivity(intent);
            }


        };
        listView.setOnItemClickListener(mMessageClickedHandler);

        return rootview;
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

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            for (int i = 0; i < input.size(); i++) {
                Person housing = input.get(i);
                String lvnames = housing.getFirstName() + " " + housing.getLastName() + "- " + housing.getLocation();
                peopleArray.add(lvnames);

            }
            listView.setAdapter(adapter);

        }
    }
}