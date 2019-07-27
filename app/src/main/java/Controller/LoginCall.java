package Controller;


import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tasks.android.bayantasksapplication.APIInterface;
import com.tasks.android.bayantasksapplication.UserInfo;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asus on 1/7/2019.
 */

public class LoginCall {

    private  LoginCallBackListner mListner;
    String userName,password;
    Gson gson;

    Retrofit retrofit;
    APIInterface apiInterface;
    private UserInfo userInfo = new UserInfo();
    private String sessionKey;
    public LoginCall(String userName, String password, LoginCallBackListner listner) {
        mListner = listner;
        this.userName = userName;
        this.password = password;

        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://patient-api-dev.medsolace.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiInterface = retrofit.create(APIInterface.class);
    }

    public UserInfo doLogin()
    {
// todo handle login
//        Call<UserInfo> loginCall = apiInterface.doLogin(userName,password);
//        loginCall.enqueue(new Callback<UserInfo>() {
//            @Override
//            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
//                if(response.code()==200)
//                {
//                    userInfo = response.body();
//                    Headers headers = response.headers();
//                    Log.d("hedar","header is:"+headers);
//                    sessionKey = headers.get("Set-Cookie");
//                    Log.d("session", "sessionkey:"+sessionKey);
//                    final String[] setCookie=sessionKey.split(";");
//                    sessionKey=setCookie[0];
//
//                    mListner.onFetchComplete(userInfo,sessionKey);
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<UserInfo> call, Throwable t)
//            {
//
//                Log.d("errror0!!",t.getMessage());
//            }
//        });

        userInfo = new UserInfo();
        sessionKey = "";
        mListner.onFetchComplete(userInfo, sessionKey);
        return userInfo;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public interface LoginCallBackListner
    {

        void onFetchComplete(UserInfo user, String sessionKey);

    }
}
