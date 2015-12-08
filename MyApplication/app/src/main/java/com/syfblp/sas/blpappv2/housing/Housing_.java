package com.syfblp.sas.blpappv2.housing;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;


public class Housing_ {

    @SerializedName("id")
    @Expose
    private Integer id;
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
    private Integer rent;
    @SerializedName("parking")
    @Expose
    private String parking;
    @SerializedName("commute")
    @Expose
    private String commute;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("syfLocation")
    @Expose
    private String syfLocation;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("numReviews")
    @Expose
    private Integer numReviews;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
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
    public Integer getRent() {
        return rent;
    }

    /**
     *
     * @param rent
     * The rent
     */
    public void setRent(Integer rent) {
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
    public Double getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     * The rating
     */
    public void setRating(Double rating) {
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
    public Integer getNumReviews() {
        return numReviews;
    }

    /**
     *
     * @param numReviews
     * The numReviews
     */
    public void setNumReviews(Integer numReviews) {
        this.numReviews = numReviews;
    }

}
