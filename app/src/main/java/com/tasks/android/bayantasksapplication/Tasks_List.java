package com.tasks.android.bayantasksapplication;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Tasks_List extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private View v;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    private List<Task> tasks;
    private   MyAdapter myAdapter;
    private String sessionKey;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private boolean pullToRefreshFlag =false;
    private boolean canScroll = true;
    private FrameLayout noDataLayout;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_list);
            recyclerView =  (RecyclerView) findViewById(R.id.tasks_recycler_view);
            progressBar = (ProgressBar) findViewById(R.id.progressBar);

            recyclerViewLayoutManager = new LinearLayoutManager(Tasks_List.this);
            recyclerView.setLayoutManager(recyclerViewLayoutManager);

            mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.pull_to_refresh);
            mSwipeRefreshLayout.setOnRefreshListener(this);
            tasks = new ArrayList<Task>();
            for (int i=0;i<10;i++)
            {
                Task task = new Task();
                task.title = "task_title"+i;
                tasks.add(task);

            }
            myAdapter = new MyAdapter(tasks);
            recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onRefresh() {
        Toast.makeText(this,"Refrishing...", Toast.LENGTH_SHORT).show();

    }
}
