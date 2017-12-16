package parcel_system;

import java.util.ArrayList;

/**
 * Singleton class, only one storage can be created.
 */
public class Storage {

    /**
     * Holds packages.
     */
    private static ArrayList<Parcel> parcels = new ArrayList<>();


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
     * Number of packages in storage.
     * @return number of packages
     */
    protected static int getNumberOfPackages(){
        return parcels.size();
    }


    /**
     * Adds package to storage
     * @param parcel
     */
    public void AddPackage(Parcel parcel) {
        parcels.add(parcel);
    }

    /**
     *
     */
    public void SendPackage() {
        // TODO implement here
    }

}

