package com.tasks.android.bayantasksapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import Models.TaskData;

/**
 * Created by Ameen_Kharma on 7/27/2019.
 */

public class Tasks {
    @SerializedName("status_code")
    @Expose
    private int statusCode;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<TaskData> data;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<TaskData> getData() {
        return data;
    }

    public void setData(List<TaskData> data) {
        this.data = data;
    }
}



