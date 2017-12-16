package stuff;

import java.util.ArrayList;

public class DefaultItems {

    private ArrayList<Item> items = new ArrayList<>();

    public DefaultItems(){
        createItems();
    }

    private ArrayList<Item> createItems(){
        Item dvd = new Item(1.5,19, 13.5,0.1, 0,"Autot 2 DVD");
        Item frisbee = new Item(3, 20, 20, 0.3, 0, "Frisbee");
        Item mug = new Item(7, 12, 7, 0.2, 1, "Iittala Taika-muki");
        Item fridge = new Item(60, 180, 67, 63, 1,"Electrolux jääkaappi");

        items.add(dvd);
        items.add(frisbee);
        items.add(mug);
        items.add(fridge);
        return items;
    }

    public ArrayList<Item> getDefaultItems() {
        return items;
    }

    public ArrayList<String> getNames(){
        ArrayList<String> contents = new ArrayList<>();
        for (Item i:items) {
            contents.add(i.getContent());
        }
        return contents;
    }

    public void AddnewItem(double height, double length, double depth, double weight, String content){
        double fragile = Math.random();
        if (fragile > 0.49){
            fragile = 1;

        }else{
            fragile = 0;
        }
        int intValue = (int) fragile;
        items.add(new Item(height, length, depth, weight,intValue, content));
    }
}
