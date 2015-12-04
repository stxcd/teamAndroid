package com.syfblp.sas.blpappv2.announcements;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.syfblp.sas.blpappv2.R;
import com.syfblp.sas.blpappv2.ServiceHandler;
import com.syfblp.sas.blpappv2.housing.HomeRecycleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class AnnouncementsFragment extends Fragment {
    private RecyclerView recyclerView;
    private HomeRecycleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Announcement> input = new ArrayList<>() ;

    //URL to get JSON Array
    private static String url = "https://uat.onlinecreditcenter6.com/cs/groups/cmswebsite/documents/websiteasset/newsfeed_android.json";

    //JSON Node Names
    private static final String NEWSFEED = "newsfeed";
    private static final String ID = "id";
    private static final String DESCRIPTION = "description";
    private static final String DATE = "date";

    JSONArray newsArray = null;

    public static AnnouncementsFragment newInstance() {
        AnnouncementsFragment fragment= new AnnouncementsFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup containter,Bundle savedInstanceState){
        View rootview = inflater.inflate(R.layout.fragment_main, containter, false);

        recyclerView = (RecyclerView) rootview.findViewById(R.id.my_recycler_view);
        mLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        new JSONParse().execute();


        return rootview;
    }

    /**
     * Created by 212464350 on 11/30/2015.
     */
    private class JSONParse extends AsyncTask<Void, Void, Void>  {

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

            mAdapter = new HomeRecycleAdapter(input);
            if (jsonStr != null) {
                try {
                    JSONObject json = new JSONObject(jsonStr);

                    // Getting JSON Array
                    newsArray = json.getJSONArray(NEWSFEED);
                    for (int i = 0; i < newsArray.length(); i++) {
                        JSONObject c = newsArray.getJSONObject(i);
                        // Storing  JSON item in a Variable
                        String id = c.getString(ID);
                        String description = c.getString(DESCRIPTION);
                        String date = c.getString(DATE);
                        Announcement announcement = new Announcement();
                        announcement.setId(Integer.parseInt(id));
                        announcement.setDescription(description);
                        announcement.setTime(date);
                        input.add(announcement);

                    }

                }catch (JSONException e) {
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

                 mAdapter = new HomeRecycleAdapter(input);

                 recyclerView.setAdapter(mAdapter);

            }

        }
    }


