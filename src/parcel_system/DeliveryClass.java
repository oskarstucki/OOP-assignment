package parcel_system;

import javafx.scene.control.Alert;

import java.io.Serializable;

public abstract class DeliveryClass extends Parcel implements Serializable {

    private String deliveryClass;


    /**
     * Default constructor
     */
    public DeliveryClass(double height, double length, double depth, double weight, int fragile, String content,
                         double heightLimit, double lengthLimit, double depthLimit, double weightLimit) {
        super(height,length,depth,weight,fragile,content);
        this.setHeightLimit(heightLimit);
        this.setLengthLimit(lengthLimit);
        this.setDepthLimit(depthLimit);
        this.setWeightLimit(weightLimit);
        if (this.getWillBreak() == 1 && this.fragile == 1 ) {
            this.broken = 1;
        }

    }



    private double heightLimit; // cm
    private double lengthLimit; // cm
    private double depthLimit;  // cm
    private double weightLimit; // KG

    public abstract int getMaxDistance();
    public abstract int getWillBreak();

    private double distance;


    /**
     * @param weightLimit
     */
    public void setWeightLimit(double weightLimit) {
        this.weightLimit = weightLimit;
    }

    /**
     *
     */
    public double getWeightLimit(){
        return this.weightLimit;
    }

    /**
     * @param heightLimit
     */
    public void setHeightLimit(double heightLimit) {
        this.heightLimit = heightLimit;
    }

    /**
     *
     */
    public double getHeightLimit() {
        return this.heightLimit;
    }

    /**
     * @param depthLimit
     */
    public void setDepthLimit(double depthLimit) {
        this.depthLimit = depthLimit;
    }

    /**
     *
     */
    public double getDepthLimit() {
        return this.depthLimit;
    }

    /**
     *
     * @param lengthLimit
     */
    public void setLengthLimit(double lengthLimit) {
        this.lengthLimit = lengthLimit;
    }

    /**
     *
      * @return
     */
    public double getLengthLimit() {
        return this.lengthLimit;
    }


    /**
     * allerts if the distance for chosen postclass is too large
     * @param distance
     */
    public void setDistance(double distance){
        if (distance < this.getMaxDistance()) {
            this.distance = distance;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Varoitus!");
            alert.setHeaderText("Väärä pakettiluokka");
            alert.setContentText("Pakettiautomaattien välinen matka on liian suuri valitulle pakettiluokalle");
            alert.showAndWait();
        }
    }

    public double getDistance() {
        return distance;
    }

    protected void setDeliveryClass(String deliveryClass){
        this.deliveryClass = deliveryClass;
    }

    public String getDeliveryClass() {
        return deliveryClass;
    }
}
