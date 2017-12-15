package parcel_system;

public abstract class DeliveryClass extends Parcel {


    /**
     * Default constructor
     */
    public DeliveryClass(double height, double length, double depth, double weight) {
        super(height,length,depth,weight);

    }


    protected double weightLimit;
    protected double heightLimit;
    protected double depthLimit;
    protected double lengthLimit;

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
}
