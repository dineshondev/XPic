/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import flickr.FlickrBrowser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.json.JSONException;
import twitter.TweetPoster;

/**
 *
 * @author dinesh
 */
@Stateless
public class picBean {

    @PersistenceUnit
    EntityManagerFactory emf;


    /**
     * gets the flicker images based on the given location
     * @param location
     * @return
     */
    public java.util.ArrayList<String> getflickrImages(String location) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            String[] pics = FlickrBrowser.flickrApi(location, 10, new String[10]);
            for(String pic : pics){
                list.add(pic);
                System.out.println(pic);
            }
        } catch (IOException ex) {
            Logger.getLogger(picBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(picBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * get flicker images based on the x and y coordinates.
     * Using this method will give inconsistant number of flickr images as
     * not all coordinates are
     * @param latitude
     * @param longitude
     * @return
     */
    public java.util.ArrayList<String> getflickrImagesForCoordinates(String latitude, String longitude) {
        ArrayList<String> list = new ArrayList<String>();
        List pics = emf.createEntityManager().createNamedQuery("Mypics.findAll").getResultList();
        Iterator itr = pics.iterator();
        int i = 0;
        while (itr.hasNext()) {
            Mypics pic = (Mypics)itr.next();
            list.add(pic.getPiclink());
        }
        if(list.isEmpty())
            list.add("Pitt");
        return list;
    }

    public java.util.ArrayList<String> getTweetedImages() {
         ArrayList<String> list = new ArrayList<String>();
        List pics = emf.createEntityManager().createNamedQuery("Mypics.findAll").getResultList();
        Iterator itr = pics.iterator();
        int i = 0;
        while (itr.hasNext()) {
            Mypics pic = (Mypics)itr.next();
            list.add(pic.getPiclink());
        }
        if(list.isEmpty())
            list.add("Pitt");
        return list;
    }

    public String tweetImage(String name, String link, String comment) {
//        name = "Image";
//        String status = TweetPoster.tweet(name+ " : " +link+ " : " +comment);
//        Mypics pic = new Mypics();
//        pic.setPicname(name);
//        pic.setPiclink(link);
//        pic.setPiccomment(comment);
//        emf.createEntityManager().persist(pic);
//        return status;
        return "";
    }


    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


    
}
