package com.prayforme.shmuel.prayforme.controller;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.prayforme.shmuel.prayforme.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //layout
    ScrollView scrollView;
    TextView numberOfPerakimReadTextView;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    AdapterTehilim adapterTehilim;
    ArrayList tehilimList;
    ArrayList perekNumList;
    LinearLayout readLinearLayout;
    Random random=new Random();
    int read=150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SnapHelper snapHelper=new LinearSnapHelper();

        //get perakim arrays from resource
        tehilimList=new ArrayList<>(Arrays.asList( getResources().getStringArray(R.array.tehilim)));
        perekNumList=new ArrayList<>(Arrays.asList( getResources().getStringArray(R.array.pereknum)));

        //find views
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        scrollView=(ScrollView)findViewById(R.id.scrollView);
        numberOfPerakimReadTextView=(TextView)findViewById(R.id.numberOfPerakimRead);
        readLinearLayout=(LinearLayout)findViewById(R.id.readLayout);

        readLinearLayout.setVisibility(View.GONE);
        snapHelper.attachToRecyclerView(recyclerView);

        //set up recycler view
        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterTehilim=new AdapterTehilim(this,tehilimList,perekNumList);
        recyclerView.setAdapter(adapterTehilim);

    }

    /**
     * the function is called whe user wants to read a different perek of tehilim
     * it goes to a random perek in the list and scrolls to the top
     * @param view
     */
    public void findAnotherPerek(View view) {

        linearLayoutManager.scrollToPosition(random.nextInt(tehilimList.size()));
        scrollView.fullScroll(ScrollView.FOCUS_UP);
    }

    /**
     * function is called when user finishes a perek
     * the perek is removed from the list
     * if the number of perakim left to finish a sefer is 10 or less then a text appears ontop showing how many are left
     * if there aer no more perakim left then lists are reinitialized
     * @param view
     */
    public void finishedPerek(View view) {
        int position=linearLayoutManager.findFirstVisibleItemPosition();
        tehilimList.remove(position);
        perekNumList.remove(position);
        read--;
        if(tehilimList.size()<=10)
        {
            readLinearLayout.setVisibility(View.VISIBLE);
            numberOfPerakimReadTextView.setText(""+read);
        }
        if(tehilimList.size()==0)
        {
            tehilimList=new ArrayList<>(Arrays.asList( getResources().getStringArray(R.array.tehilim)));
            perekNumList=new ArrayList<>(Arrays.asList( getResources().getStringArray(R.array.pereknum)));
            adapterTehilim=new AdapterTehilim(this,tehilimList,perekNumList);
            recyclerView.setAdapter(adapterTehilim);
            read=150;
            readLinearLayout.setVisibility(View.GONE);
        }
        else {
            adapterTehilim=new AdapterTehilim(this,tehilimList,perekNumList);
            recyclerView.setAdapter(adapterTehilim);
            linearLayoutManager.scrollToPosition(position);
            scrollView.fullScroll(ScrollView.FOCUS_UP);
        }
    }
}
