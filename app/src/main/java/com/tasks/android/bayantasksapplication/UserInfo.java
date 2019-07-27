package com.tasks.android.bayantasksapplication;

/**
 * Created by Ameen_Kharma on 7/27/2019.
 */

import Models.UserData;

public class UserInfo {
    private String status;
    private int statusCode;
    private UserData data;

    public UserInfo() {
        this.status = "SUCCESS";
        this.statusCode = 200;
        this.data = new UserData();

    }

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

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }
}
