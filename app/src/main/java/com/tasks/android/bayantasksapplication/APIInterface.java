package com.tasks.android.bayantasksapplication;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Ameen_Kharma on 7/20/2019.
 */

public interface APIInterface {

    String loginUrl = "login";
    String registrationUrl =  "register";
    String taskUrl = "users/{user_id}/tasks";

    String threadsURL = "api/v1/inbox/threads";
    String deleteThreadURL = "api/v1/inbox/threads/delete";
    String markThreadStarURL = "api/v1/inbox/threads/threads_starring";
    String markThreadUnStarURL = "api/v1/inbox/threads/threads_unstarring";

    String markUnreadURL = "api/v1/inbox/threads/threads_unread_marking";
    String markReadURL = "api/v1/inbox/threads/threads_read_marking";

    @FormUrlEncoded
    @POST(loginUrl)
    Call<UserInfo> doLogin(@Field("email") String user, @Field("password") String password);

    @FormUrlEncoded
    @POST(registrationUrl)
    Call<UserInfo> doRegistration(@Field("email") String user_email,@Field("username") String user_name, @Field("password") String password);

    @GET(taskUrl)
    Call<Tasks> getUserTasksList(@Path("user_id") int user_id);


}