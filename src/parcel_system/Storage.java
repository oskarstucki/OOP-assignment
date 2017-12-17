package parcel_system;


import java.io.*;
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
        System.out.println("2nd class package containing " + parcel.getContent() + " was added to storage.");
    }


    /**
     * Writes the content of Storage to a file.
     * @param a array list of packages
     */
    public void saveStorageState(ArrayList<?> a){
        if (a.size() > 0) {
            try {
                String homeDir = System.getProperty("user.home");
                String path = homeDir + File.separator + "TIMO_savedData" + File.separator;
                FileOutputStream fos;
                switch (a.get(0).getClass().getName()) {
                    case "FirstClass":
                        fos = new FileOutputStream(path + "priority");
                        break;
                    case "SecondClass":
                        fos = new FileOutputStream(path + "standard");
                        break;
                    case "ThirdClass":
                        fos = new FileOutputStream(path +"economy");
                        break;
                    default:
                        throw new RuntimeException("Incorrect class.");
                }
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(a);
                oos.close();
                fos.close();
            }catch (IOException ioe) {
                ioe.printStackTrace();
            }
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
            switch (shippingClass) {
                case 1:
                    fis = new FileInputStream(path + "priority");
                    ois = new ObjectInputStream(fis);
                    priority = (ArrayList) ois.readObject();
                    System.out.println("Previous data was loaded for first class.");
                    break;
                case 2:
                    fis = new FileInputStream(path + "standard");
                    ois = new ObjectInputStream(fis);
                    standard = (ArrayList) ois.readObject();
                    System.out.println("Previous data was loaded for second class.");
                    break;
                case 3:
                    fis = new FileInputStream(path + "economy");
                    ois = new ObjectInputStream(fis);
                    economy = (ArrayList) ois.readObject();
                    System.out.println("Previous data was loaded for third class.");
                    break;
                default:
                    throw new RuntimeException("Incorrect class.");
            }
            ois.close();
            fis.close();
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

    /**
     *
     */
    public void SendPackage() {
        // TODO implement here
    }

}

