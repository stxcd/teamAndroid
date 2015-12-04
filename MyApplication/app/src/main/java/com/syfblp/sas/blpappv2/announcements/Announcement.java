package com.syfblp.sas.blpappv2.announcements;

/**
 * Created by 212464350 on 11/24/2015.
 */
public class Announcement {
    int Id;
    String description;
    String time;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}