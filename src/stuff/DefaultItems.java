package stuff;

import java.util.ArrayList;

public class DefaultItems {

    private ArrayList<Item> items = new ArrayList<>();

    public DefaultItems(){
         createItems();
    }

    private void createItems(){
        Item dvd = new Item(1.5,19, 13.5,0.1, 0,"Autot 2 DVD");
        Item frisbee = new Item(3, 20, 20, 0.3, 0, "Frisbee");
        Item mug = new Item(7, 12, 7, 0.2, 1, "Iittala Taika-muki");
        Item fridge = new Item(60, 180, 67, 63, 0, "Electrolux jääkaappi");
        items.add(dvd);
        items.add(frisbee);
        items.add(mug);
        items.add(fridge);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
