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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class DirectoryFragment extends Fragment {

    JSONArray personArray = null;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<Person> input = new ArrayList<>();
    ArrayList<String> allperson = new ArrayList<>();
    private static String url = "https://uat.onlinecreditcenter6.com/cs/groups/cmswebsite/documents/websiteasset/directory_android.json" ;
    private static final String JSON = "directory" ;
    private static final String ID = "id" ;
    private static final String FIRSTNAME = "firstName" ;
    private static final String LASTNAME = "lastName" ;
    private static final String LOCATION = "location" ;
    private static final String FUNCTION = "function" ;
    private static final String UNIVERSITY = "university" ;
    private static final String EMAIL = "email" ;
    private static final String PHONE = "phone" ;
    private static final String ROLE = "role" ;
    private static final String AL = "al" ;


    public static DirectoryFragment newInstance(){
        DirectoryFragment fragment=new DirectoryFragment();

        return fragment;
    }

    public View onCreateView(LayoutInflater inflater,ViewGroup containter,Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.content_blpdirectory, containter, false);

        new JSONParse().execute();
        adapter = new ArrayAdapter<>(rootview.getContext(), android.R.layout.simple_list_item_1, allperson);
        listView = (ListView) rootview.findViewById(R.id.BLPDirectorylistView);

        android.widget.AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(parent.getContext(), Profile.class);
                String clickedOnPerson = allperson.get(position);
                intent.putExtra("lookingfor",clickedOnPerson);
                intent.putExtra("json",input);

                startActivity(intent);
            }
        };

        listView.setOnItemClickListener(mMessageClickedHandler);


        return rootview;
    }

private class JSONParse extends AsyncTask<Void,Void,Void> {



    @Override
    protected Void doInBackground(Void... params) {

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
                        String firsname=c.getString(FIRSTNAME);
                        String lastname=c.getString(LASTNAME);
                        String location= c.getString(LOCATION);
                        String function = c.getString(FUNCTION);
                        String university = c.getString(UNIVERSITY);
                        String email = c.getString(EMAIL);
                        String phone = c.getString(PHONE);
                        String role= c.getString(ROLE);
                        String al= c.getString(AL);
                        Person housing = new Person(id,firsname,lastname,location,function,role,al,email,phone,university);
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
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        int i;
        for (i = 0; i < input.size(); i++) {
            Person housing = input.get(i);
            String lvnames = housing.getFirstName()+" "+housing.getLastName()+" "+housing.getLocation();

            allperson.add(lvnames);
            }

        listView.setAdapter(adapter);
    }
    }
}


