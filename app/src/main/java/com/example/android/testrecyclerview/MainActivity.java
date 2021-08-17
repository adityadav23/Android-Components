package com.example.android.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Declaring variables
    public RecyclerView mRecyclerView;
    public MonthAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            getting reference of RecyclerView.
            Initializing adapter using Adapter constructor
         */
        mRecyclerView = findViewById(R.id.rv_myRecycler);
        mAdapter = new MonthAdapter(this , getData());
        //setting adapter on the recyclerView
        mRecyclerView.setAdapter(mAdapter);

        //Setting LayoutManger on RecyclerView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /*
     This function returns the data set to the adapter
     */
    public List<Months> getData(){

        List<Months> data = new ArrayList<>();
        String[]  monthNames = new String[]{ "jan","Feb" , "Mar", "July"} ;
        int[] icons= new int[]{R.mipmap.ic_launcher,R.mipmap.ic_launcher_round,
                     R.mipmap.ic_launcher,R.mipmap.ic_launcher_round} ;

        for(int i=0;i<100 ; i++ ){
            Months current = new Months();
            current.setmIcon(icons[i%(icons.length)]);
            current.setmMonthName(monthNames[i%monthNames.length]);
            data.add(current);
        }
        return data;
    }
}