package com.syfblp.sas.blpappv2.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Events {
    @SerializedName("event")
    @Expose
    private List<Event> event = new ArrayList<Event>();

    /**
     *
     * @return
     * The event
     */
    public List<Event> getEvent() {
        return event;
    }

    /**
     *
     * @param event
     * The event
     */
    public void setEvent(List<Event> event) {
        this.event = event;
    }

}

