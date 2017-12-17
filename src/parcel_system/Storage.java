package parcel_system;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Singleton class, only one storage can be created.
 */
public class Storage {

    /**
     * Holds packages.
     */
    private static ArrayList<FirstClass> priority = new ArrayList<>();
    private static ArrayList<SecondClass> standard = new ArrayList<>();
    private static ArrayList<ThirdClass> economy = new ArrayList<>();

    /**
     * Private constructor for singleton
     */
    private Storage(){

    }

    /**
     * Bill Pugh inner static helper class for implementing singleton.
     */
    private static class SingletonStorageHelper{
        private static final Storage STORAGE = new Storage();
    }

    /**
     * Public access point to singleton Storage.
     * @return STORAGE
     */
    public static Storage getStorage(){
        return SingletonStorageHelper.STORAGE;
    }


    /**
     * Number of packages in storage. Default gets number of all packages.
     * @return number of packages
     */
    protected static int getNumberOfPackages(){
        return priority.size() + standard.size() + economy.size();
    }

    protected static int getNumberOfPackages(int classNumber){
        switch (classNumber) {
            case 1:
                return priority.size();
            case 2:
                return standard.size();
            case 3:
                return economy.size();
            default:
                throw new RuntimeException("Incorrect delivery class.");

        }
    }


    /**
     * Adds package to storage, overload to create a switch type structure.
     * @param parcel
     */
    public void AddPackage(FirstClass parcel) {
        priority.add(parcel);
        System.out.println("1st class package containing " + parcel.getContent() + " was added to storage.");
    }
    public void AddPackage(SecondClass parcel) {
        standard.add(parcel);
        System.out.println("2nd class package containing " + parcel.getContent() + " was added to storage.");
    }
    public void AddPackage(ThirdClass parcel) {
        economy.add(parcel);
        System.out.println("3rd class package containing " + parcel.getContent() + " was added to storage.");
    }


    /**
     * Writes the content of Storage to a file.
     * @param shippingClass int of shipping class
     */
    public void saveStorageState(int shippingClass){
            try {
                Path p;
                FileOutputStream fos;
                ObjectOutputStream oos;
                File dir = new File(Paths.get(System.getProperty("user.home"),
                        "TIMO_savedStorageData").toString());
                if (!dir.exists()){
                    System.out.println("Creating new directory: " + dir.getName());
                    try {
                        dir.mkdir();
                    }catch (SecurityException se){
                        se.printStackTrace();
                        System.out.println("Was not able to create new directory.");
                    }
                }
                switch (shippingClass) {
                    case 1:
                        p = Paths.get(System.getProperty("user.home"),"TIMO_savedStorageData", "priority");
                        fos = new FileOutputStream(p.toString());
                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(priority);
                        break;
                    case 2:
                        p = Paths.get(System.getProperty("user.home"),"TIMO_savedStorageData", "standard");
                        fos = new FileOutputStream(p.toString());
                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(standard);
                        break;
                    case 3:
                        p = Paths.get(System.getProperty("user.home"),"TIMO_savedStorageData", "economy");
                        fos = new FileOutputStream(p.toString());
                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(economy);
                        break;
                    default:
                        throw new RuntimeException("Incorrect class.");
                }
                System.out.println(p.toString());
                oos.close();
                fos.close();
            }catch (IOException ioe) {
                ioe.printStackTrace();
            }
    }


    /**
     * Reads data from saved file.
     * @param shippingClass 1st, 2nd or 3rd
     */
    public void getStoredData(int shippingClass){
        try {
            String homeDir = System.getProperty("user.home");
            String path = homeDir + File.separator + "TIMO_savedData" + File.separator;
            FileInputStream fis;
            ObjectInputStream ois;
            Path p;

            switch (shippingClass) {
                case 1:{
                    p =  Paths.get(System.getProperty("user.home"),"TIMO_savedStorageData", "priority");
                    fis = new FileInputStream(p.toString());
                    ois = new ObjectInputStream(fis);
                    priority = (ArrayList) ois.readObject();
                    System.out.println("Previous data was loaded for first class.");
                    ois.close();
                    fis.close();
                    break;}
                case 2:{
                    p = Paths.get(System.getProperty("user.home"),"TIMO_savedStorageData", "standard");
                    fis = new FileInputStream(p.toString());
                    ois = new ObjectInputStream(fis);
                    standard = (ArrayList) ois.readObject();
                    System.out.println("Previous data was loaded for second class.");
                    ois.close();
                    fis.close();
                    break;}
                case 3:{
                    p = Paths.get(System.getProperty("user.home"),"TIMO_savedStorageData", "economy");
                    fis = new FileInputStream(p.toString());
                    ois = new ObjectInputStream(fis);
                    economy = (ArrayList) ois.readObject();
                    System.out.println("Previous data was loaded for third class.");
                    ois.close();
                    fis.close();
                    break;}
                default:
                    //throw new RuntimeException("Incorrect class.");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnf) {
            System.out.println("Class not found.");
            cnf.printStackTrace();
        }
    }


    public static ArrayList<FirstClass> getPriority() {
        return priority;
    }

    public static ArrayList<SecondClass> getStandard() {
        return standard;
    }

    public static ArrayList<ThirdClass> getEconomy() {
        return economy;
    }

    public void printPackages(){
        for (FirstClass parcel: priority) {
            System.out.println(parcel.getID() + " : " + parcel.getContent());
        }
        for (SecondClass parcel: standard) {
            System.out.println(parcel.getID() + " : " + parcel.getContent());
        }
        for (ThirdClass parcel: economy) {
            System.out.println(parcel.getID() + " : " + parcel.getContent());
        }
    }

    public ArrayList<DeliveryClass> extractPackages(){
        ArrayList<DeliveryClass> al = new ArrayList<>();
        for (FirstClass parcel: priority) {
            al.add(parcel);
        }
        for (SecondClass parcel: standard) {
            al.add(parcel);
        }
        for (ThirdClass parcel: economy) {
            al.add(parcel);
        }

        return al;
    }


    /**
     *
     */
    public void SendPackage() {
        // TODO implement here
    }

}

