package map;

import java.lang.reflect.Array;

public class SmartPost {



    /**
     * Default constructor
     */
    private int postCode;



    private String city, address, available, postOffice;
    private Float latitude, longitude;

    public SmartPost(int postCode, String city, String address, String available,
                     String postOffice, float latitude, float longitude){
        this.postCode = postCode;
        this.city = city;
        this.address = address;
        this.available = available;
        this.postOffice = postOffice;
        this.latitude = latitude;
        this.longitude = longitude;


    }

    public int getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getAvailable() {
        return available;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    @Override
    public String toString(){
        String tempInfo = this.postOffice.substring(19);

        return this.city + " (" + tempInfo+")";
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }
}
