package stuff;

public class Item {

    /* Properties of parcels */
    private double height;
    private double length;
    private double depth;
    private double weight;

    /* Is content fragile? */
    private int fragile = 0;

    /* String content */
    private final String content;

    /**
     *
     * @param height cm
     * @param length cm
     * @param depth cm
     * @param weight cm
     * @param fragile cm
     * @param content cm
     */
    public Item(double height, double length, double depth, double weight, int fragile, String content){
        this.height = height;
        this.length = length;
        this.depth = depth;
        this.weight = weight;
        this.fragile = fragile;
        this.content = content;

    }

    /**
     * @return height
     */
    public double getHeight() {
        return this.height;
    }


    /**
     * @return length
     */
    public double getLength() {
        return this.length;
    }


    /**
     * @return depth
     */
    public double getDepth() {
        return this.depth;
    }


    /**
     * @return weight
     */
    public double getWeight() {
        return this.weight;
    }


    /**
     * @return fragile
     */
    public int isFragile() {
        return fragile;
    }


    /**
     *
     * @return content
     */
    public String getContent(){
        return this.content;
    }


}
