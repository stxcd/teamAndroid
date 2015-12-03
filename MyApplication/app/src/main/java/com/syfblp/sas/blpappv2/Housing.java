package com.syfblp.sas.blpappv2;

import java.io.Serializable;

/**
 * Created by 212464350 on 12/2/2015.
 */
public class Housing implements Serializable {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;
    String apartmentName;
    String apartmentAddress1;

    public String getApartmentAddress2() {
        return apartmentAddress2;
    }

    public void setApartmentAddress2(String apartmentAddress2) {
        this.apartmentAddress2 = apartmentAddress2;
    }

    String apartmentAddress2;
    String apartmentCity;
    String apartmentState;
    String apartmentCost;
    String apartmentDistance;

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    String workLocation;

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getApartmentDistance() {
        return apartmentDistance;
    }

    public void setApartmentDistance(String apartmentDistance) {
        this.apartmentDistance = apartmentDistance;
    }

    public String getApartmentAddress1() {
        return apartmentAddress1;
    }

    public void setApartmentAddress1(String apartmentAddress1) {
        this.apartmentAddress1 = apartmentAddress1;
    }

    public String getApartmentCost() {
        return apartmentCost;
    }

    public void setApartmentCost(String apartmentCost) {
        this.apartmentCost = apartmentCost;
    }

    public String getApartmentCity() {
        return apartmentCity;
    }

    public void setApartmentCity(String apartmentCity) {
        this.apartmentCity = apartmentCity;
    }

    public String getApartmentState() {
        return apartmentState;
    }

    public void setApartmentState(String apartmentState) {
        this.apartmentState = apartmentState;
    }
}

