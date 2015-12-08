package com.syfblp.sas.blpappv2.events;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.syfblp.sas.blpappv2.R;

import java.util.ArrayList;

public class EventActivity extends Activity {
	private RecyclerView erecyclerView;
	private EventAdapter eAdapter;
	private RecyclerView.LayoutManager eLayoutManager;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_activity_main);
		erecyclerView = (RecyclerView) findViewById(R.id.event_recycler_view);


		// use this setting to improve performance if you know that changes
		// in content do not change the layout size of the RecyclerView
		// recyclerView.setHasFixedSize(true);

		// use a linear layout manager
		eLayoutManager = new LinearLayoutManager(this);
		erecyclerView.setLayoutManager(eLayoutManager);
		// Use the default animator
		// recyclerView.setItemAnimator(new DefaultItemAnimator());
		// you could add item decorators
        //RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
		//recyclerView.addItemDecoration(itemDecoration);

		ArrayList<EventHandler> input = new ArrayList<>();
        EventHandler eventHandler= new EventHandler();
        eventHandler.setEventName("Christmas Eve");
        eventHandler.setStartDate("12/24/2015");
        eventHandler.setEndDate("12/24/2015");
        eventHandler.setDescription("Stamford Holiday");
        input.add(eventHandler);
        EventHandler eventHandler1= new EventHandler();
        eventHandler1.setEventName("Christmas Day");
        eventHandler1.setStartDate("12/25/2015");
        eventHandler1.setEndDate("12/25/2015");
        eventHandler1.setDescription("Stamford Holiday");
        input.add(eventHandler1);
        EventHandler eventHandler2= new EventHandler();
        eventHandler2.setEventName("New Year's Day");
        eventHandler2.setStartDate("1/1/2016");
        eventHandler2.setEndDate("1/1/2016");
        eventHandler2.setDescription("Stamford Holiday");
        input.add(eventHandler2);
        EventHandler eventHandler3= new EventHandler();
        eventHandler3.setEventName("Martin Luther King, Jr. Day");
        eventHandler3.setStartDate("1/18/2016");
        eventHandler3.setEndDate("1/18/2016");
        eventHandler3.setDescription("Stamford Holiday");
        input.add(eventHandler3);
        EventHandler eventHandler4= new EventHandler();
        eventHandler4.setEventName("Presidents Day");
        eventHandler4.setStartDate("2/15/2016");
        eventHandler4.setEndDate("2/15/2016");
        eventHandler4.setDescription("Stamford Holiday");
        input.add(eventHandler4);
        EventHandler eventHandler5= new EventHandler();
        eventHandler5.setEventName("Memorial Day");
        eventHandler5.setStartDate("6/30/2016");
        eventHandler5.setEndDate("6/30/2016");
        eventHandler5.setDescription("Stamford Holiday");
        input.add(eventHandler5);


		// specify an adapter (see also next example)
		eAdapter = new EventAdapter(input);
		erecyclerView.setAdapter(eAdapter);

    }
}