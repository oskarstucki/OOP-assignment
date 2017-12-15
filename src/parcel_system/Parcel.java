package parcel_system;

public abstract class Parcel {

    /**
     * Default constructor
     */
    public Parcel(double height, double length, double depth, double weight) {
        this.height = height;
        this.length = length;
        this.depth = depth;
        this.weight = weight;
    }

    /**
     *
     */
    protected double height;

    /**
     *
     */
    protected double length;

    /**
     *
     */
    protected double depth;

    /**
     *
     */
    protected double weight;


    /**
     * @return
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @param height
     */

    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return
     */
    public double getLength() {
        return this.length;
    }

    /**
     * @param length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * @return
     */
    public double getDepth() {
        return this.depth;
    }

    /**
     * @param depth
     */
    public void setDepth(double depth) {
        this.depth = depth;
    }

    /**
     * @return
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

}
