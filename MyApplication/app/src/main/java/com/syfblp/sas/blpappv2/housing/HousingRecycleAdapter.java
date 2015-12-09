package com.syfblp.sas.blpappv2.housing;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.syfblp.sas.blpappv2.R;

import java.util.ArrayList;

public class HousingRecycleAdapter extends RecyclerView.Adapter<HousingRecycleAdapter.ViewHolder> {
    private ArrayList<Housing_> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtFirstLine;
        public TextView txtSecondLine;
        public TextView txtApartmentBuilding;
        public TextView txtDistance;
        public TextView txtCityState;
        public TextView txtCost;

        public ViewHolder(View v) {
            super(v);
            //txtFirstLine = (TextView) v.findViewById(R.id.firstLine);
            txtSecondLine = (TextView) v.findViewById(R.id.secondLine);
            txtApartmentBuilding = (TextView) v.findViewById(R.id.firstLine);
            txtDistance = (TextView) v.findViewById(R.id.distance);
            txtCityState = (TextView) v.findViewById(R.id.thirdLine);
            txtCost = (TextView) v.findViewById(R.id.cost);
        }
    }

    public void add(int position, Housing_ item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(Housing item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public HousingRecycleAdapter(ArrayList<Housing_> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HousingRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.housingrowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Housing_ name = mDataset.get(position);
        //holder.txtFirstLine.setText(mDataset.get(position));
       /* holder.txtFirstLine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               System.out.println("clicked!");

                //remove(name);
            }
        });
*/      if (name.getApartmentName().equals("Null")){
            holder.txtApartmentBuilding.setText("");
            }
        else{
            holder.txtApartmentBuilding.setText(name.getApartmentName());}

            holder.txtSecondLine.setText(name.getAddress());

        holder.txtDistance.setText(name.getCommute());
        holder.txtCityState.setText(" " + name.getCity() + ", "+ name.getState() +" ");
        holder.txtCost.setText("Monthly: $"+name.getRent());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}