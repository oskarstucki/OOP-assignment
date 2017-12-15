package parcel_system;

import java.util.Random;

public class ThirdClass extends DeliveryClass {


    /**
     * Default constructor
     * Third class packages can be 60 cm x 185 cm x 120 cm and weight 50 kg.
     */
    public ThirdClass(double height, double length, double depth, double weight, int fragile) {
        super(height,length,depth,weight, fragile, 60, 185, 120, 50);
        this.didNonFragileBreak();
    }

    /**
     *  Maximum delivery distance 1500 (km)
     */
    private static final int MAX_DISTANCE = 1500;

    /**
     * All fragile packets will break.
     */
    private static final int WILL_BREAK = 1;


    /**
     * Some non-fragile packets will break too. Probability of breaking is 5%.
     */
    private void didNonFragileBreak(){
        Random rnd = new Random();
        int p = rnd.nextInt(100);
        if (p < 5) {
            this.broken = 1;
        } else {
            this.broken = 0;
        }
    }


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
