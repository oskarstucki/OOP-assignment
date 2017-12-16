package parcel_system;

public class FirstClass extends DeliveryClass {

    /**
     * Default constructor
     * First class packages can be 10 cm x 30 cm x 20 cm and weight 3 kg.
     */
    public FirstClass(double height, double length, double depth, double weight, int fragile, String content) {
        super(height,length,depth,weight,fragile,content,10,30, 20, 3);
    }

    /**
     *  Maximum delivery distance 150 (km)
     */
    private static final int MAX_DISTANCE = 150;

    /**
     * @return MAX_DISTANCE
     */
    @Override
    public int getMaxDistance(){
        return MAX_DISTANCE;
    }


    /**
     * All fragile packets will break.
     */
    private static final int WILL_BREAK = 1;

    /**
     * @return WILL_BREAK
     */
    @Override
    public int getWillBreak(){
        return WILL_BREAK;
    }






}
