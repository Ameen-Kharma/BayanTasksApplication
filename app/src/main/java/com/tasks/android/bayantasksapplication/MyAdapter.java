package com.tasks.android.bayantasksapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import Models.Task;

/**
 * Created by Ameen_Kharma on 7/27/2019.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemsViewHolder> {
    private View v;
    List<Task> adapterTasks;

    public MyAdapter(List<Task> tasks) {
        this.adapterTasks = tasks;
    }

    public List<Task> getAdapterTasks() {
        return adapterTasks;
    }

    public void setAdapterTasks(List<Task> adapterTasks) {
        this.adapterTasks = adapterTasks;
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder {
        public TextView taskTitle,taskDescription,taskDate,taskStatus,taskFrom;
        public ImageView star,senderImage,attatchment;
        public ItemsViewHolder(View itemView) {
            super(itemView);
            taskTitle = itemView.findViewById(R.id.task_title);
            taskDescription = itemView.findViewById(R.id.message_brief);
            taskDate = itemView.findViewById(R.id.message_date);
            taskStatus = itemView.findViewById(R.id.status_text);
            taskFrom = itemView.findViewById(R.id.message_from);
        }
    }
        @NonNull
    @Override
    public MyAdapter.ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_cell, parent, false);
            return new ItemsViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {
        holder.taskTitle.setText(adapterTasks.get(position).getTittle());
        holder.taskDescription.setText(adapterTasks.get(position).getDescription());
       // holder.taskDate.setText(adapterTasks.get(position).getId());
        holder.taskStatus.setText(adapterTasks.get(position).getStatus());
        holder.taskFrom.setText(adapterTasks.get(position).getFrom());
    }



    @Override
    public int getItemCount() {
        return adapterTasks.size();
    }
}
