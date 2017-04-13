package com.chethan.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initialise();
    }

    private void initialise() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_home_play_list);

        TextView textViewTitle = (TextView) findViewById(R.id.cp_action_bar_title);
        textViewTitle.setText("Title");

        this.arrayList = new ArrayList<>();

        for(int index = 0; index < 10; index++) {
            this.arrayList.add("Item: " + index);
        }

        setupRecyclerView();
        handleUserInteraction();
    }

    private void handleUserInteraction() {
        findViewById(R.id.cp_action_bar_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setupRecyclerView() {
        StaggeredGridLayoutManager mStaggeredLayoutManager =
                new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);


        PlaylistRecyclerAdapter mAdapter = new PlaylistRecyclerAdapter(this, arrayList);
        recyclerView.setAdapter(mAdapter);

        PlaylistRecyclerAdapter.OnItemClickListener onItemClickListener = new PlaylistRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                String itemTitle = arrayList.get(position);

                Toast.makeText(MainActivity.this, itemTitle, Toast.LENGTH_SHORT).show();
            }
        };

        mAdapter.setOnItemClickListener(onItemClickListener);
    }
}
