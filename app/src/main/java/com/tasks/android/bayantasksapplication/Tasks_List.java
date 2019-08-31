package com.tasks.android.bayantasksapplication;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Controller.TasksCall;
import Models.Task;
import Models.TaskData;

public class Tasks_List extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, TasksCall.TaskCallBackListner {

    private View v;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    private Tasks tasks;
    private List<Task> tasksList;
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
            TasksCall tasksCall = new TasksCall(sessionKey="", Tasks_List.this);
            tasks = tasksCall.getTasks(31);
            tasksList = new ArrayList<Task>();
            myAdapter = new MyAdapter(tasksList);
            recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onRefresh() {
        Toast.makeText(this,"Refrishing...", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFetchComplete(Tasks task) {

        if(task.getStatusCode()==200){
            tasksList = task.getData();
            myAdapter.setAdapterTasks(tasksList);
            myAdapter.notifyDataSetChanged();
        }

//        tasksList = data.get(0).getTasks();
//        myAdapter.setAdapterTasks(tasksList);
//        myAdapter.notifyDataSetChanged();
    }
}
