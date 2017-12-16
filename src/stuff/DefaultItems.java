package stuff;

import java.util.ArrayList;

public class DefaultItems {

    public DefaultItems(){
        createItems();
    }

    private ArrayList<Item> createItems(){
        Item dvd = new Item(1.5,19, 13.5,0.1, 0,"Autot 2 DVD");
        Item frisbee = new Item(3, 20, 20, 0.3, 0, "Frisbee");
        Item mug = new Item(7, 12, 7, 0.2, 1, "Iittala Taika-muki");
        Item fridge = new Item(60, 180, 67, 63, 0, "Electrolux jääkaappi");
        ArrayList<Item> items = new ArrayList<>();
        items.add(dvd);
        items.add(frisbee);
        items.add(mug);
        items.add(fridge);
        return items;
    }

}
