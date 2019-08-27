package Controller;

import android.util.Log;

import com.tasks.android.bayantasksapplication.APIClient;
import com.tasks.android.bayantasksapplication.APIInterface;
import com.tasks.android.bayantasksapplication.Tasks;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ameen_Kharma on 8/27/2019.
 */

public class TasksCall {
    private final TaskCallBackListner mListner;
    private APIClient apiClient;
    private APIInterface apiInterface;
    private String sessionKey;
    private Tasks tasks;


    public TasksCall(String sessionKey, TaskCallBackListner listner) {
        mListner = listner;
        this.sessionKey = sessionKey;
        apiClient = new APIClient(sessionKey);
        apiInterface= apiClient.getRetrofit().create(APIInterface.class);

    }

    public Tasks getTasks(int user_id) {

        doCallTasks(user_id);
        return tasks;
    }

    public void doCallTasks(int userId){
        Call<Tasks> tasksListCall = apiInterface.getUserTasksList(userId);
        tasksListCall.enqueue(new Callback<Tasks>() {
            @Override
            public void onResponse(Call<Tasks> call, Response<Tasks> response) {
                if (response.code()==200)
                {
                    tasks = response.body();
                    mListner.onFetchComplete(tasks);
                }
            }

            @Override
            public void onFailure(Call<Tasks> call, Throwable t) {
                Log.d("error calltask 0!!! ", t.getMessage());

            }
        });

    }

    public interface TaskCallBackListner
    {

        void onFetchComplete(Tasks task);

    }
}
