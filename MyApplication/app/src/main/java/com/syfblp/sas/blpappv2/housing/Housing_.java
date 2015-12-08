package com.syfblp.sas.blpappv2.housing;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

        import java.io.Serializable;


public class Housing_ implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("apartmentName")
    @Expose
    private String apartmentName;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("City")
    @Expose
    private String City;
    @SerializedName("State")
    @Expose
    private String State;
    @SerializedName("rent")
    @Expose
    private String rent;
    @SerializedName("parking")
    @Expose
    private String parking;
    @SerializedName("commute")
    @Expose
    private String commute;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("syfLocation")
    @Expose
    private String syfLocation;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("numReviews")
    @Expose
    private String numReviews;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The apartmentName
     */
    public String getApartmentName() {
        return apartmentName;
    }

    /**
     *
     * @param apartmentName
     * The apartmentName
     */
    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The City
     */
    public String getCity() {
        return City;
    }

    /**
     *
     * @param City
     * The City
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     *
     * @return
     * The State
     */
    public String getState() {
        return State;
    }

    /**
     *
     * @param State
     * The State
     */
    public void setState(String State) {
        this.State = State;
    }

    /**
     *
     * @return
     * The rent
     */
    public String getRent() {
        return rent;
    }

    /**
     *
     * @param rent
     * The rent
     */
    public void setRent(String rent) {
        this.rent = rent;
    }

    /**
     *
     * @return
     * The parking
     */
    public String getParking() {
        return parking;
    }

    /**
     *
     * @param parking
     * The parking
     */
    public void setParking(String parking) {
        this.parking = parking;
    }

    /**
     *
     * @return
     * The commute
     */
    public String getCommute() {
        return commute;
    }

    /**
     *
     * @param commute
     * The commute
     */
    public void setCommute(String commute) {
        this.commute = commute;
    }

    /**
     *
     * @return
     * The rating
     */
    public String getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     * The rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     * The syfLocation
     */
    public String getSyfLocation() {
        return syfLocation;
    }

    /**
     *
     * @param syfLocation
     * The syfLocation
     */
    public void setSyfLocation(String syfLocation) {
        this.syfLocation = syfLocation;
    }

    /**
     *
     * @return
     * The contact
     */
    public String getContact() {
        return contact;
    }

    /**
     *
     * @param contact
     * The contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     *
     * @return
     * The numReviews
     */
    public String getNumReviews() {
        return numReviews;
    }

    /**
     *
     * @param numReviews
     * The numReviews
     */
    public void setNumReviews(String numReviews) {
        this.numReviews = numReviews;
    }

}
