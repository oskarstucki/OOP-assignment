package stuff;

import java.util.ArrayList;

public class DefaultItems {

    private ArrayList<Item> items = new ArrayList<>();

    public DefaultItems(){
        createItems();
    }

    /**
     * Creates a couple default items for the user to choose from
     * @return
     */

    private ArrayList<Item> createItems(){
        Item dvd = new Item(1.5,19, 13.5,0.1, 0,"Autot 2 DVD");
        Item frisbee = new Item(3, 20, 20, 0.3, 0, "Frisbee");
        Item mug = new Item(7, 12, 7, 0.2, 1, "Iittala Taika-muki");
        Item fridge = new Item(60, 180, 67, 63, 1,"Electrolux jääkaappi");
        Item jellyjortikka = new Item(19.5, 5,5,0.2,0,"Jellyjortikka");
        Item boardgame = new Item(25,35, 3.5, 0.3, 0, "Afrikantähti");
        Item ps4 = new Item(47,38,12,4.96,0,"Playstation 4 Pro");
        Item videocard = new Item(45,30,14,2.38,1,"GeForce GTX 1080 Ti");
        Item dogtoy = new Item(35,5,7,0.3,0,"Star Wars Chewbacca -koiranlelu");

        items.add(dvd);
        items.add(frisbee);
        items.add(mug);
        items.add(fridge);
        items.add(jellyjortikka);
        items.add(boardgame);
        items.add(ps4);
        items.add(videocard);
        items.add(dogtoy);
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

    /**
     * Possible to add a new item for which is randomly decided weather it is fragile or not
     *
     * @param height
     * @param length
     * @param depth
     * @param weight
     * @param content
     */
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
