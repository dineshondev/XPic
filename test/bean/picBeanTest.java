/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dinesh
 */
public class picBeanTest {

    public picBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    /**
//     * Test of getflickrImagesForCoordinates method, of class picBean.
//     */
//    @Test
//    public void testGetflickrImages_String() throws Exception {
//        System.out.println("getflickrImagesForCoordinates");
//        String location = "";
//        picBean instance = (picBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/picBean");
//        ArrayList expResult = null;
//        ArrayList result = instance.getflickrImagesForCoordinates(location);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getflickrImagesForCoordinates method, of class picBean.
//     */
//    @Test
//    public void testGetflickrImages_String_String() throws Exception {
//        System.out.println("getflickrImagesForCoordinates");
//        String latitude = "";
//        String longitude = "";
//        picBean instance = (picBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/picBean");
//        ArrayList expResult = null;
//        ArrayList result = instance.getflickrImagesForCoordinates(latitude, longitude);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTweetedImages method, of class picBean.
//     */
//    @Test
//    public void testGetTweetedImages() throws Exception {
//        System.out.println("getTweetedImages");
//        picBean instance = (picBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/picBean");
//        ArrayList expResult = null;
//        ArrayList result = instance.getTweetedImages();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of tweetImage method, of class picBean.
     */
    @Test
    public void testTweetImage() throws Exception {
        System.out.println("tweetImage");
        String link = "some link";
        String name = "some name";
        String comment = "some comment";
        picBean instance = (picBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/picBean");
        String expResult = "";
        String result = instance.tweetImage(link, name, comment);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}