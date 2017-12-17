package parcel_system;

import java.io.Serializable;

public class SecondClass extends DeliveryClass implements Serializable {

    /**
     * Default constructor
     * Second class packages can be 5 cm x 30 cm x 20 cm and weight 2 kg.
     */
    public SecondClass(double height, double length, double depth, double weight, int fragile, String content) {
        super(height,length,depth,weight, fragile, content,5, 30, 20, 2);
        setDeliveryClass("2");
    }

    /**
     *  Maximum delivery distance 1500 (km)
     */
    private static final int MAX_DISTANCE = 1500;

    private String DELIVERY_CLASS = "2";

    /**
     * All fragile packets will not break.
     */
    private static final int WILL_BREAK = 0;


    /**
     * @return MAX_DISTANCE
     */
    @Override
    public int getMaxDistance(){
        return MAX_DISTANCE;
    }

    /**
     * @return WILL_BREAK
     */
    @Override
    public int getWillBreak(){
        return WILL_BREAK;
    }

}
