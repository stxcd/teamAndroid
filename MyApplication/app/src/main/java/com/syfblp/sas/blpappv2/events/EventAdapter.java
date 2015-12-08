package com.syfblp.sas.blpappv2.events;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.syfblp.sas.blpappv2.R;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
	private ArrayList<Event> mDataset;

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
	public EventAdapter(ArrayList<Event> myDataset) {
		mDataset = myDataset;
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
        holder.txtDate.setText("Dates: " + name.getStartdate() + " - " + name.getEnddate());
        holder.txtDescr.setText("Description: " + name.getDescription());
//        holder.buttonOne.setOnClickListener(new Button.OnClickListener() {
//                public void onClick(View v){Calendar beginTime = Calendar.getInstance();
//                     beginTime.set(2015, 12, 12);
//                     Calendar endTime = Calendar.getInstance();
//                     endTime.set(2015, 12, 12);
//                     Intent intent = new Intent(Intent.ACTION_INSERT)
//                             .setData(CalendarContract.Events.CONTENT_URI)
//                             .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, name.getStartTime())
//                             .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, name.getEndTime())
//                             .putExtra(CalendarContract.Events.TITLE, name.getEventName())
//                             .putExtra(CalendarContract.Events.DESCRIPTION, name.getDescription())
//                             .putExtra(CalendarContract.Events.EVENT_LOCATION, name.getEventLocation())
//                             .putExtra(CalendarContract.Events.AVAILABILITY, name.getAvailability());
//                 ;}
//            });

	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return mDataset.size();
	}

}