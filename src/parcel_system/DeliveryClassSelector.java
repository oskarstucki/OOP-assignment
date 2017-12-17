package parcel_system;

import javafx.scene.control.Alert;
import stuff.Item;

import java.util.Arrays;


public class DeliveryClassSelector {

    public DeliveryClassSelector(){

    }

    /**
     * Tests if delivery class is suitable.
     * @param i item
     * @param d delivery class
     * @return boolean value, false = not suitable
     */
    public boolean testDeliveryClass(Item i, DeliveryClass d){
        double w, wLimit;
        double[] size = new double[3];
        boolean suitableDeliveryClass = true;
        size[0] = i.getDepth();
        size[1] = i.getHeight();
        size[2] = i.getLength();
        Arrays.sort(size);
        double[] sizeLimit = new double[3];
        sizeLimit[0] = d.getDepthLimit();
        sizeLimit[1] = d.getHeightLimit();
        sizeLimit[2] = d.getLengthLimit();
        Arrays.sort(sizeLimit);

        w = i.getWeight();
        wLimit = d.getWeightLimit();

        if (w > wLimit) { // Packet is too heavy.
            suitableDeliveryClass = false;
        } else {
            for (int ind = 0; ind < 3; ind++) {
                if (sizeLimit[ind] < size[ind]) {
                    suitableDeliveryClass = false;
                    break;
                }
            }
        }

        if (suitableDeliveryClass == false) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Varoitus!");
            alert.setHeaderText("Väärä pakettiluokka");
            alert.setContentText("Paketti on liian suuri kyseiseen pakettiluokkaan.");
            alert.showAndWait();
        }

        return suitableDeliveryClass;
    }





}

