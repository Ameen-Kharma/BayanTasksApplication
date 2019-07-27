package Controller;

import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tasks.android.bayantasksapplication.APIInterface;
import com.tasks.android.bayantasksapplication.UserInfo;
import com.tasks.android.bayantasksapplication.RetrofitAPIClient;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Ameen_Kharma on 7/27/2019.
 */


public class RegistrationCall {
    private RegistrationCallBackListner mListner;
    String userName,password,userEmail;
    APIInterface apiInterface;
    RetrofitAPIClient retrofitAPIClient;
    Retrofit retrofit;


    private UserInfo userInfo = new UserInfo();
    private String sessionKey;

    public RegistrationCall (String userEmail, String userName, String password, RegistrationCallBackListner listner) {
        this.mListner = listner;
        this.userName = userName;
        this.password = password;
        this.userEmail = userEmail;
        retrofitAPIClient = new RetrofitAPIClient();
        retrofit = retrofitAPIClient.getRetrofit();
        apiInterface = retrofit.create(APIInterface.class);

    }

    public void doRegistration()
    {

//            Call<UserInfo> registrationCall = apiInterface.doRegistration(userEmail, userName, password);
//            registrationCall.enqueue(new Callback<UserInfo>() {
//                @Override
//                public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
//                    if (response.code() == 200) {
//                        userInfo = response.body();
//                        Headers headers = response.headers();
//                        Log.d("hedar", "header is:" + headers);
//                        sessionKey = headers.get("Set-Cookie");
//                        Log.d("session", "sessionkey:" + sessionKey);
//                        final String[] setCookie = sessionKey.split(";");
//                        sessionKey = setCookie[0];
//
//                        mListner.onFetchComplete(userInfo, sessionKey);
//
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<UserInfo> call, Throwable t) {
//
//                    Log.d("errror0!! regstration", t.getMessage());
//                }
//            });
        userInfo = new UserInfo();
        sessionKey = "";
        mListner.onFetchComplete(userInfo, sessionKey);


    }

    public interface RegistrationCallBackListner
    {

        void onFetchComplete(UserInfo user, String sessionKey);

    }
}
