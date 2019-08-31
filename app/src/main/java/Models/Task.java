package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ameen_Kharma on 8/27/2019.
 */

public class Task {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("tittle")
    @Expose
    private String tittle;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("target")
    @Expose
    private String target;
    @SerializedName("from")
    @Expose
    private String from;


    public Task() {
        this.status = "SUCCESS";



    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
