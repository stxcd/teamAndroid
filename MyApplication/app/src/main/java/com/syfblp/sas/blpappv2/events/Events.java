package com.syfblp.sas.blpappv2.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Events {
    @SerializedName("event")
    @Expose
    private ArrayList<Event> event = new ArrayList<Event>();

    /**
     *
     * @return
     * The event
     */
    public ArrayList<Event> getEvent() {
        return event;
    }

    /**
     *
     * @param event
     * The event
     */
    public void setEvent(ArrayList<Event> event) {
        this.event = event;
    }


}

