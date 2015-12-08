package com.syfblp.sas.blpappv2.housing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.syfblp.sas.blpappv2.R;

import java.util.ArrayList;

public class HousingActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HousingRecycleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Housing_> tobedispayedList= new ArrayList<>();
    ArrayList<Housing_> input= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housing);

        Intent incomingIntent = this.getIntent();
        String nameToDisplay = (String)incomingIntent.getStringExtra("snails");
        input=(ArrayList<Housing_>)incomingIntent.getSerializableExtra("json");
        TextView tV = (TextView)findViewById(R.id.apartmentName);
        tV.setText(nameToDisplay);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);


        for(int i = 0;i<input.size();i++){
            Housing_ check= (Housing_) input.get(i);
            if(check.getSyfLocation().equals(nameToDisplay)){
                tobedispayedList.add(check);

            }

        }


        // specify an adapter (see also next example)
        mAdapter = new HousingRecycleAdapter(tobedispayedList);
        recyclerView.setAdapter(mAdapter);


    }
}
