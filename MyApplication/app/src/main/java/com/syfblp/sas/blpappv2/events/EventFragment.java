package com.syfblp.sas.blpappv2.events;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.syfblp.sas.blpappv2.R;
import com.syfblp.sas.blpappv2.ServiceHandler;

import org.json.JSONArray;

import java.util.ArrayList;


public class EventFragment extends Fragment {
    private RecyclerView erecyclerView;
    private EventAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Event> input = new ArrayList<>() ;

    //URL to get JSON Array
    private static String url = "https://uat.onlinecreditcenter6.com/cs/groups/cmswebsite/documents/websiteasset/calendar_android.json";

    //JSON Node Names
//    private static final String CALENDAR = "event";
//    private static final String ID = "id";
//    private static final String STARTDATE = "startdate";
//    private static final String STARTTIME = "starttime";
//    private static final String ENDDATE = "enddate";
//    private static final String ENDTIME = "endtime";
//    private static final String EVENT = "event";
//    private static final String DESCRIPTION = "description";
//    private static final String AVAILABILITY = "availability";
//    private static final String LOCATION = "location";

    JSONArray eventArray = null;

    public static EventFragment newInstance(){
        EventFragment fragment= new EventFragment();
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater,ViewGroup containter,Bundle savedInstanceState){
        View rootview= inflater.inflate(R.layout.event_fragment,containter,false);
        erecyclerView = (RecyclerView) rootview.findViewById(R.id.event_recycler_view);
        mLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        erecyclerView.setLayoutManager(mLayoutManager);
        new JSONParse().execute();

        return rootview;
    }

    private class JSONParse extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Events events = new Gson().fromJson(jsonStr, Events.class);
            input=events.getEvent();

            if(events == null) {
                Log.e("Err", "No events found!");

            }

            Log.d("Response: ", "> " + jsonStr);

            mAdapter = new EventAdapter(input, getActivity());
            return null;
//            if (jsonStr != null) {
//                try {
//                    JSONObject json = new JSONObject(jsonStr);
//
//                    // Getting JSON Array
//                    eventArray = json.getJSONArray(CALENDAR);
//                    for (int i = 0; i < eventArray.length(); i++) {
//                        JSONObject c = eventArray.getJSONObject(i);
//                        // Storing  JSON item in a Variable
//                        String id = c.getString(ID);
//                        String description = c.getString(STARTDATE);
//                        String date = c.getString(STARTTIME);
//                        Announcement announcement = new Announcement();
//                        announcement.setId(Integer.parseInt(id));
//                        announcement.setDescription(description);
//                        announcement.setTime(date);
//                        input.add(announcement);
//
//                    }
//
//                }catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                Log.e("ServiceHandler", "Couldn't get any data from the url");
//            }
//
//            return null;
}
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            mAdapter = new EventAdapter(input,  getActivity());

            erecyclerView.setAdapter(mAdapter);
        }

    }
}
