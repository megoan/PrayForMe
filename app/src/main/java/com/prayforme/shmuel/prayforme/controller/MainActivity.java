package com.prayforme.shmuel.prayforme.controller;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.ScrollView;

import com.prayforme.shmuel.prayforme.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdapterTehilim adapterTehilim;
    String[] tehilim;
    String[] pereknum;
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SnapHelper snapHelper=new LinearSnapHelper();
        tehilim= getResources().getStringArray(R.array.tehilim);
        pereknum=getResources().getStringArray(R.array.pereknum);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        scrollView=(ScrollView)findViewById(R.id.scrollView);
        snapHelper.attachToRecyclerView(recyclerView);
        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new AdapterTehilim(this,tehilim,pereknum));

    }

    public void findAnotherPerek(View view) {
        Random r=new Random();
        linearLayoutManager.scrollToPosition(r.nextInt(150));
        scrollView.fullScroll(ScrollView.FOCUS_UP);
    }
}
