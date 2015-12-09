package com.syfblp.sas.blpappv2.housing;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.syfblp.sas.blpappv2.R;
import com.syfblp.sas.blpappv2.ServiceHandler;
import com.syfblp.sas.blpappv2.directory.Person;

import java.util.ArrayList;

/**
 * Created by 212464350 on 11/24/2015.
 */
public class HousingFragment extends Fragment {
    ArrayList<Housing_> input = new ArrayList<>();
    ArrayList<String> alllocation = new ArrayList<>();


//    private static final String JSON = "survey" ;
//    private static final String ID = "id" ;
//    private static final String TYPE="type";
//    private static final String APARTMENT_NAME = "apartmentName" ;
//    private static final String ADDRESS1 = "address" ;
//    private static final String CITY = "City" ;
//    private static final String STATE = "State" ;
//    private static final String RENT= "rent";
//    private static final String PARKING="parking";
//    private static final String DISTANCE = "Commute" ;
//    private static final String WORKLOCAL = "workLocation" ;
//    private static final String COST="Monthly";
//    JSONArray houseArray = null;
    ListView listView;
    ArrayAdapter<String> adapter;

    private static String url = "https://uat.onlinecreditcenter6.com/cs/groups/cmswebsite/documents/websiteasset/housing_android.json" ;
    public static HousingFragment newInstance() {
        HousingFragment fragment = new HousingFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup containter, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_housing, containter, false);
        new JSONParse().execute();
//        int i;
//        final ArrayList<String> alllocation= new ArrayList<>();
//            for (i = 0; i < input.size(); i++) {
//                Housing housing = input.get(i);
//                String lvnames = housing.getWorkLocation();
//                alllocation.add(lvnames);
//            }

        adapter = new ArrayAdapter<>(rootview.getContext(), android.R.layout.simple_list_item_1, alllocation);
        listView = (ListView) rootview.findViewById(R.id.listView);

        android.widget.AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent openHousing = new Intent(parent.getContext(), HousingActivity.class);

                String clickedOnCity = alllocation.get(position);
                openHousing.putExtra("snails", clickedOnCity);
               openHousing.putExtra("json",input);


                startActivity(openHousing);


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
            Housing housing = new Gson().fromJson(jsonStr, Housing.class);
            input=housing.getHousing();

            if(housing== null) {
                Log.e("Err", "No events found!");

            }
            Log.d("Response: ", "> " + jsonStr);

//            if (jsonStr != null) {
//                try {
//                    JSONObject json = new JSONObject(jsonStr);
//
//                    // Getting JSON Array
//                    houseArray = json.getJSONArray(JSON);
//                    for (int i = 0; i < houseArray.length(); i++) {
//                        JSONObject c = houseArray.getJSONObject(i);
//                        // Storing  JSON item in a Variable
//                        String id = c.getString(ID);
//                        String addressname = c.getString(APARTMENT_NAME);
//                        String address1 = c.getString(ADDRESS1);
//                        String address2 = c.getString(ADDRESS2);
//                        String city = c.getString(CITY);
//                        String state = c.getString(STATE);
//                        String distance = c.getString(DISTANCE);
//                        String work = c.getString(WORKLOCAL);
//                        String cost = c.getString(COST);
//                        Housing housing = new Housing();
//                        housing.setId(Integer.parseInt(id));
//                        housing.setApartmentName(addressname);
//                        housing.setApartmentAddress1(address1);
//
//                        housing.setApartmentCity(city);
//                        housing.setApartmentState(state);
//                        housing.setApartmentDistance(distance);
//                        housing.setWorkLocation(work);
//                        housing.setApartmentCost(cost);
//                        input.add(housing);
//                        System.out.println(housing.getApartmentAddress1());
//
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                Log.e("ServiceHandler", "Couldn't get any data from the url");
//            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            int i;
            for (i = 0; i < input.size(); i++) {
                Housing_ housing = input.get(i);
                String lvnames = housing.getSyfLocation();
                if (checkUnique(lvnames,alllocation)) {
                    alllocation.add(lvnames);
                }
            }

            listView.setAdapter(adapter);
        }

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

    public static class Profile extends AppCompatActivity {
        ArrayList<Person> tobedispayedList = new ArrayList<>();
        ArrayList<Person> input = new ArrayList<>();
        String nameToDisplay;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);


            Intent incomingIntent = this.getIntent();
            nameToDisplay = (String) incomingIntent.getStringExtra("snails");
            input = (ArrayList<Person>) incomingIntent.getSerializableExtra("json");

            final Person person = getPeople(input);
            TextView firstLastNameTxt = (TextView) findViewById(R.id.txtFirstLastName);
            firstLastNameTxt.setText(person.getFirstName() + " " + person.getLastName());

            TextView FunctionLocationTxt = (TextView) findViewById(R.id.txtFunctionLocation);
            FunctionLocationTxt.setText(person.getFunction() + "  |  " + person.getLocation());

            TextView roleTxt = (TextView) findViewById(R.id.txtRole);
            roleTxt.setText(person.getRole());

            TextView alTxt = (TextView) findViewById(R.id.txtAL);
            alTxt.setText(person.getAl());

            TextView phoneTxt = (TextView) findViewById(R.id.txtPhone);
            phoneTxt.setText(person.getPhone());

            TextView emailTxt = (TextView) findViewById(R.id.txtEmail);
            emailTxt.setText(person.getEmail());

            TextView uniTxt= (TextView) findViewById(R.id.unitxt);
            uniTxt.setText(person.getUniversity());

            View buttonView = findViewById(R.id.btnCall);
            buttonView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + person.getPhone()));
                    startActivity(intent);
                }
            });
        }

        private Person getPeople(ArrayList<Person> input) {
            Person toBeReturned= null;
            for (int i = 0; i < input.size(); i++) {
                Person check = (Person) input.get(i);
                String check1 = check.getFirstName() + " " + check.getLastName() + "- " + check.getLocation();
                if (check1.equals(nameToDisplay)) {
                    toBeReturned=check;
                }
            }
            return toBeReturned;
        }
    }
}

