package com.syfblp.sas.blpappv2.housing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;


public class Housing implements Serializable {

    @SerializedName("housing")
    @Expose
    private ArrayList<Housing_> housing = new ArrayList<>();

    /**
     *
     * @return
     * The housing
     */
    public ArrayList<Housing_> getHousing() {
        return housing;
    }

    /**
     *
     * @param housing
     * The housing
     */
    public void setHousing(ArrayList<Housing_> housing) {
        this.housing = housing;
    }

}