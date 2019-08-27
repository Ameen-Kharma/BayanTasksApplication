package Models;

import java.util.List;

/**
 * Created by Ameen_Kharma on 8/27/2019.
 */

public class TaskData {

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    private List<Task> tasks = null;

}
