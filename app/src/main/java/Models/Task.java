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
    @SerializedName("description")
    @Expose
    private String description;
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
        if(status != null)
            return status;
        else
            return "Completed";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTittle() {
        if(tittle != null)
           return tittle;
        else
            return "dummy title";
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getTarget() {
        if(target != null)
            return target;
        else
            return "fuck";
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getFrom() {
        if(from != null)
            return from;
        else
            return "Ameen";
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDescription() {
        if (description!=null)
            return description;
        else
            return "baka ya ru ! baka ya ru ! baka ya ru ! baka ya ru ! baka ya ru ! baka ya ru ! baka ya ru ! baka ya ru ! baka ya ru ! baka ya ru ! baka ya ru ! baka ya ru ! baka ya ru ! baka ya ru ! baka ya ru ! baka ya ru ! baka ya ru !";
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
