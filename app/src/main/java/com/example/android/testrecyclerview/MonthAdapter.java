package com.example.android.testrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.MonthViewHolder>{
       //Declaring Global variables
        private List<Months> data;
        private Context context;

        //Constructor for the Adapter
    public MonthAdapter(Context context, List<Months> data){
        this.context = context;
        this.data= data;
    }

    /*
        Overriding onCreateViewHolder with return type ViewHolder
        Param parent - The root object reference of list_row layout(here LinearLayout)


     */
    @Override
    public MonthViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        //inflating the list_row and storing to reference view
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent, false);
        //Passing this view to viewHolder
        MonthViewHolder monthVH = new MonthViewHolder(view);
        return monthVH;
    }

    /*
        Override onBindViewHolder
        Param  position - position of data item in data set

     */
    @Override
    public void onBindViewHolder(MonthViewHolder holder, int position) {
        //getting data in the Months reference
       Months current  = data.get(position);
       //storing name and resource id from the current object
       String monthName = current.getmMonthName();
       int iconId = current.getmIcon();
       //Setting data to the viewHolder object
        holder.monthName.setText(monthName);
        holder.icon.setImageResource(iconId);
    }

    //Gives the count of data set to the layoutManager
    @Override
    public int getItemCount() {

        return data.size();
    }

    //deletes an entry from the inflated list items from the given position
    public void delete(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

    // extending the RecyclerView.ViewHolder and implementing onClickListener
    public class MonthViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView monthName;
        ImageView icon;
        //Creating constructor which is invoked in onCreateViewHolder passing a view parameter to it
        public MonthViewHolder( View itemView) {

            super(itemView);
            //getting reference of the list row objects

            monthName= itemView.findViewById(R.id.tv_name);
            icon= itemView.findViewById(R.id.iv_icon);
            //Calling setOnClickListener
            monthName.setOnClickListener(this);
        }


        //Implementing actions which will occur on clicking the list items
        @Override
        public void onClick(View view) {
            delete(getPosition());
        }
    }
}
