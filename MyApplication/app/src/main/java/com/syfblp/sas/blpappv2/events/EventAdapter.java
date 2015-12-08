package com.syfblp.sas.blpappv2.events;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.content.Intent;
import android.provider.CalendarContract;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.syfblp.sas.blpappv2.R;

import java.util.ArrayList;
import java.util.Date;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
	private ArrayList<Event> mDataset;
    private Activity mActivity;

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder

	public class ViewHolder extends RecyclerView.ViewHolder {
		// each data item is just a string in this case
		public TextView txtEvent;
		public TextView txtDate;
        public TextView txtDescr;
        public Button buttonOne;

		public ViewHolder(View v) {
			super(v);
			txtEvent = (TextView) v.findViewById(R.id.firstLine);
			txtDate = (TextView) v.findViewById(R.id.secondLine);
			txtDescr = (TextView) v.findViewById(R.id.thirdLine);
            buttonOne = (Button) v.findViewById(R.id.buttonOne);
	}}

	public void add(int position, Event item) {
        mDataset.add(position, item);
		notifyItemInserted(position);
	}

	public void remove(Event item) {
		int position = mDataset.indexOf(item);
		mDataset.remove(position);
		notifyItemRemoved(position);
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public EventAdapter(ArrayList<Event> myDataset, Activity activity) {
		mDataset = myDataset;
        mActivity = activity;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent,
			int viewType) {
		// create a new view
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventlayout, parent, false);
		// set the view's size, margins, paddings and layout parameters
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
		final Event name = mDataset.get(position);
		holder.txtEvent.setText(name.getEvent());
        holder.txtDate.setText( name.getStartdate() + " - " + name.getEnddate());
        holder.txtDescr.setText("Description: " + name.getDescription());
        holder.buttonOne.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String tmStart = name.getStarttime();
                SimpleDateFormat tmformat = new SimpleDateFormat("HH:mm:ss");
                Date startTime = null;
                try {
                    startTime = tmformat.parse(tmStart);
                    System.out.println("Start Time:" + startTime.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String tmEnd = name.getEndtime();
                Date edTime = null;
                try {
                    edTime = tmformat.parse(tmEnd);
                    System.out.println("End Time:" + edTime.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String dtStart = name.getStartdate();
                SimpleDateFormat stformat = new SimpleDateFormat("MM/dd/yyyy");
                Date startDate = null;
                   try {
                       startDate = stformat.parse(dtStart);
                       System.out.println("Date:" + startDate.toString());
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                String dtEnd = name.getEnddate();
                Date endDate = null;
                try {
                    endDate = stformat.parse(dtEnd);
                    System.out.println("Date:" + endDate.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(startDate.getYear(), startDate.getMonth(), startDate.getDay(),startTime.getHours(),startTime.getMinutes(), startTime.getSeconds());
                Calendar endTime = Calendar.getInstance();
                endTime.set(endDate.getYear(), endDate.getMonth(), endDate.getDay(), edTime.getHours(), edTime.getMinutes(), edTime.getSeconds());
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, name.getStarttime())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, name.getEndtime())
                        .putExtra(CalendarContract.Events.TITLE, name.getEvent())
                        .putExtra(CalendarContract.Events.DESCRIPTION, name.getDescription())
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, name.getLocation())
                        .putExtra(CalendarContract.Events.AVAILABILITY, name.getAvailability())
                        .setData(CalendarContract.Events.CONTENT_URI);
                        mActivity.startActivity(intent);
            }
        });

	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return mDataset.size();
	}

}