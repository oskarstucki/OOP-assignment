package parcel_system;

import org.omg.CORBA.Object;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    }
    public void AddPackage(SecondClass parcel) {
        standard.add(parcel);
    }
    public void AddPackage(ThirdClass parcel) {
        economy.add(parcel);
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


    public void getStoredData(){
        //TODO
    }



    /**
     *
     */
    public void SendPackage() {
        // TODO implement here
    }

}

