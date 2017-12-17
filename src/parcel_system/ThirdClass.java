package parcel_system;

import java.io.Serializable;
import java.util.Random;
import java.time.LocalDate;

public class ThirdClass extends DeliveryClass implements Serializable{


    /**
     * Default constructor
     * Third class packages can be 60 cm x 185 cm x 120 cm and weight 50 kg.
     */
    public ThirdClass(double height, double length, double depth, double weight, int fragile, String content) {
        super(height,length,depth,weight, fragile,content, 60, 185, 120, 50);
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
     * Some non-fragile packets will break too. Probability of breaking during winter is 10%
     * and otherwise it is 5%.
     */
    private void didNonFragileBreak(){
        // Draw a random number between [0,100[
        Random rnd = new Random();
        int p = rnd.nextInt(100);

        // Get month
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();

        // During winter months parcels are more likely to break.
        if ((month < 4 && p < 10) || (month > 8 && p < 10)) {
            this.broken = 1;
        } else if (p < 5) {
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
