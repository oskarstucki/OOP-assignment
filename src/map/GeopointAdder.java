package map;



public class GeopointAdder {

    private double[] coordinates = new double[2];


    /**
     * Default constructor
     */
    public GeopointAdder(double lat, double lng) {
        coordinates[0] = lat;
        coordinates[1] = lng;
    }

    public void setLatitude(float latitude){
        coordinates[0] = latitude;
    }

    public void setLongitude(float longitude){
        coordinates[1] = longitude;
    }

    public double getLatitude(){
        return coordinates[0];
    }
    public double getLongitude(){
        return coordinates[1];
    }

    public double[] getCoordinates() {
        return coordinates;
    }
}
