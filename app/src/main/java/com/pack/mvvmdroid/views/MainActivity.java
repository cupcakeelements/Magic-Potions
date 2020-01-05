package com.pack.mvvmdroid.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.pack.mvvmdroid.R;
import com.pack.mvvmdroid.adapters.RecyclerViewAdapter;
import com.pack.mvvmdroid.models.NicePlace;
import com.pack.mvvmdroid.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();
        mainActivityViewModel.getmNicePlaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
                    recyclerViewAdapter.notifyDataSetChanged();
            }
        });

        recyclerView =findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, (ArrayList<NicePlace>) mainActivityViewModel.getmNicePlaces().getValue());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }



}
