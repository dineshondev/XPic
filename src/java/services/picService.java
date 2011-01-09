/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import bean.picBean;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author dinesh
 */
@WebService()
public class picService {
    @EJB
    private picBean ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getflickrImages")
    public ArrayList<String> getflickrImages(@WebParam(name = "location")
    String location) {
        System.out.println(location);
        return ejbRef.getflickrImages(location);
    }

    @WebMethod(operationName = "getflickrImagesForCoordinates")
    public ArrayList<String> getflickrImagesForCoordinates(@WebParam(name = "latitude")
    String latitude, @WebParam(name = "longitude")
    String longitude) {
        return ejbRef.getflickrImagesForCoordinates(latitude, longitude);
    }

    @WebMethod(operationName = "getTweetedImages")
    public ArrayList<String> getTweetedImages() {
        return ejbRef.getTweetedImages();
    }

    @WebMethod(operationName = "tweetImage")
    public String tweetImage(@WebParam(name = "name")
    String name, @WebParam(name = "link")
    String link, @WebParam(name = "comment")
    String comment) {
        return ejbRef.tweetImage(name, link, comment);
    }

}
