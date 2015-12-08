package com.syfblp.sas.blpappv2.housing;

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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

    public String getNumpeople() {
        return numpeople;
    }

    public void setNumpeople(String numpeople) {
        this.numpeople = numpeople;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    String fname;
    String lname;
    String type;
    String apartmentName;
    String apartmentAddress1;
    String apartmentCity;
    String apartmentState;
    String zipCode;
    String bedroom;
    String bathroom;
    String numpeople;
    String apartmentCost;
    String parking;
    String apartmentDistance;
    String workLocation;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }



    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }



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

