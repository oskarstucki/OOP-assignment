package map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class DataBuilder {

    public ArrayList<SmartPost> smartPosts = new ArrayList<>();

    /**
     *  Default constructor
     */

    public DataBuilder() {
        int postCode;
        String city; String address; String available; String PostOffice;
        float latitude; float longitude;

        try {
            File inputFile = new File("fi_apt.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("place");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    postCode = Integer.parseInt(eElement.getElementsByTagName("code").item(0).getTextContent());
                    city = eElement.getElementsByTagName("city").item(0).getTextContent();
                    address = eElement.getElementsByTagName("address").item(0).getTextContent();
                    available = eElement.getElementsByTagName("availability").item(0).getTextContent();
                    PostOffice = eElement.getElementsByTagName("postoffice").item(0).getTextContent();
                    latitude = Float.parseFloat(eElement.getElementsByTagName("lat").item(0).getTextContent());
                    longitude = Float.parseFloat(eElement.getElementsByTagName("lng").item(0).getTextContent());
                    smartPosts.add(new SmartPost(postCode,city,address,available,PostOffice,latitude,longitude));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addSmartPost(int postCode, String city, String address, String available,
                             String postOffice, float latitude, float longitude){

        smartPosts.add(new SmartPost( postCode, city, address, available,
                 postOffice,  latitude,  longitude));

    }

    private ArrayList<String> listOfCities = new ArrayList<String>();

    public ArrayList<SmartPost> returnCities(){

       for(SmartPost post: smartPosts){
           listOfCities.add(post.getCity());

       }
       return smartPosts;

    }

    public SmartPost searchCity(String address, int postCode){

        for(SmartPost i: smartPosts){
            if(i.getAddress().equals(address) && i.getPostCode() == postCode){
                return i;
            }
        }
        return null;

    }
}
