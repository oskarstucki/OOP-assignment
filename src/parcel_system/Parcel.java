package parcel_system;


import java.io.Serializable;
import java.util.UUID;

public abstract class Parcel implements Serializable{

    /* Number of parcels created.*/
    private static int count = 0;

    /* Each parcel must be identifiable. */
    private final String ID;

    /* Is content fragile? */
    protected int fragile = 0;

    /* Is parcel broken? Default is no. */
    protected int broken = 0;

    /* Properties of parcels */
    private double height;
    private double length;
    private double depth;
    private double weight;

    /* String content */
    private final String content;

    /* Destination and source */
    private String destination;
    private String source;



    /**
     * Default constructor
     */
    public Parcel(double height, double length, double depth, double weight, int fragile, String content) {
        this.height = height;
        this.length = length;
        this.depth = depth;
        this.weight = weight;
        this.fragile = fragile;
        this.content = content;

        ID = createID();

    }

    private String createID(){
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public String getID(){
        return this.ID;
    }


    /**
     * @return height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @param height of the package
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
     * @param length of the package
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
     * @param depth of the package
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
     * @param weight of the package
     */
    public void setWeight(double weight) {
        this.weight = weight;
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

    /**
     *
     * @return content
     */
    public String getContent(){
        return this.content;
    }


    public void setDestination(String destination){
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setSource(String source){
        this.source = source;
    }

    public java.lang.String getSource() {
        return source;
    }


}

