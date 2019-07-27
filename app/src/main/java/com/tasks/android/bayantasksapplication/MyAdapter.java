package com.tasks.android.bayantasksapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ameen_Kharma on 7/27/2019.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private View v;
    List<Task> adapterTasks;

    public MyAdapter(List<Task> tasks) {
        this.adapterTasks = tasks;
    }


    public class ItemsViewHolder extends RecyclerView.ViewHolder {
        public TextView taskTitle,descripton,taskDate,status;
        public ImageView star,senderImage,attatchment;
        public ItemsViewHolder(View itemView) {
            super(itemView);
        }
    }
        @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_cell, parent, false);
            return new ItemsViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return adapterTasks.size();
    }
}
