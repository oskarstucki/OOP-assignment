package parcel_system;

public abstract class DeliveryClass extends Parcel {


    /**
     * Default constructor
     */
    public DeliveryClass(double height, double length, double depth, double weight, int fragile,
                         double heightLimit, double lengthLimit, double depthLimit, double weightLimit) {
        super(height,length,depth,weight,fragile);
        this.setHeightLimit(heightLimit);
        this.setLengthLimit(lengthLimit);
        this.setDepthLimit(depthLimit);
        this.setWeightLimit(weightLimit);
        if (this.getWillBreak() == 1 && this.fragile == 1 ) {
            this.broken = 1;
        }

    }



    protected double heightLimit; // cm
    protected double lengthLimit; // cm
    protected double depthLimit;  // cm
    protected double weightLimit; // KG

    public abstract int getMaxDistance();
    public abstract int getWillBreak();

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
