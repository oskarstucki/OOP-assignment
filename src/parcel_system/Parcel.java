package parcel_system;

public abstract class Parcel {

    /* Number of parcels created.*/
    private static int count = 0;

    /* Each parcel must be identifiable. */
    protected int id;

    /* Is content fragile? */
    protected int fragile = 0;

    /* Is parcel broken? Default is no. */
    protected int broken = 0;

    /* Properties of parcels */
    protected double height;
    protected double length;
    protected double depth;
    protected double weight;

    /**
     * Default constructor
     */
    public Parcel(double height, double length, double depth, double weight, int fragile) {
        this.height = height;
        this.length = length;
        this.depth = depth;
        this.weight = weight;
        this.id = ++count;
        this.fragile = fragile;

    }

    /**
     * @return height
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
     * @return length
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
     * @return depth
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
     * @return weight
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

    public int getId() {
        return this.id;
    }

    /**
     * @return fragile
     */
    public int isFragile() {
        return fragile;
    }


    /**
     * @return broken
     */
    public int isBroken(){
        return this.broken;
    }


}

