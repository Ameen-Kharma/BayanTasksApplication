package com.tasks.android.bayantasksapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Controller.TasksCall;
import Models.Task;

/**
 * Created by Ameen_Kharma on 9/13/2019.
 */

public class MyTasksFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, TasksCall.TaskCallBackListner {

    private View v;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    private FloatingActionButton floatingButton;
    private Tasks tasks;
    private List<Task> tasksList;
    private   MyAdapter myAdapter;
    private String sessionKey;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private boolean pullToRefreshFlag =false;
    private boolean canScroll = true;
    private FrameLayout noDataLayout;
    ProgressBar progressBar;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.activity_tasks_list, container, false);
        recyclerView =  (RecyclerView) v.findViewById(R.id.tasks_recycler_view);
        floatingButton = (FloatingActionButton ) v.findViewById(R.id.add_task_fab);
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);

        recyclerViewLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.pull_to_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(MyTasksFragment.this);
        TasksCall tasksCall = new TasksCall(sessionKey="", MyTasksFragment.this);
        tasks = tasksCall.getTasks(31);
        tasksList = new ArrayList<Task>();
        myAdapter = new MyAdapter(tasksList);
        recyclerView.setAdapter(myAdapter);


        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddTaskFragment();
            }
        });
        return v;
    }


    @Override
    public void onRefresh() {
        Toast.makeText(getActivity().getApplicationContext(),"Refrishing...", Toast.LENGTH_SHORT).show();

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

    private void openAddTaskFragment(){
        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        AddTaskFragment fragment = new AddTaskFragment();
        fragment.show(fragmentTransaction,"add_task_fragment");
//            fragmentTransaction.replace(R.id.add_task_layout, fragment, "add_task_fragment");
//            fragmentTransaction.addToBackStack("add_task_fragment");
//            fragmentTransaction.commit();
    }
}

