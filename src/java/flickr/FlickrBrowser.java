/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package flickr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author dinesh
 *
 * adopted from http://www.android10.org/index.php/articleslibraries/232-flickr-api-random-image-example
 */
public class FlickrBrowser {
           private static final String FLICKRAPIKEY = "********* add your flickr api key here ********";
            public static String[] flickrApi(String searchPattern, int limit, String[] allURLs) throws IOException, JSONException {
                URL url = new URL("http://api.flickr.com/services/rest/?&method=flickr.photos.search&text=" + searchPattern +"&api_key=" + FLICKRAPIKEY + "&per_page="+ limit + "&format=json");
                URLConnection connection = url.openConnection();
                String line;
                StringBuilder builder = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                                connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                        builder.append(line);
                }

                int start = builder.toString().indexOf("(") + 1;
                int end = builder.toString().length() - 1;
                String jSONString = builder.toString().substring( start, end);
                //after cutting off the junk, its ok

                JSONObject jSONObject = new JSONObject(jSONString); //whole json object
                JSONObject jSONObjectInner = jSONObject.getJSONObject("photos"); //inner Json object
                JSONArray photoArray = jSONObjectInner.getJSONArray("photo"); // inner array of photos
                JSONObject photo = null;
                for (int i =0; i < 10; i++)
                {
                        photo = photoArray.getJSONObject((int) (i)); //get one random photo from array
                        if (photo != null)
                        {
                                allURLs[i] = constructFlickrImgUrl(photo, size._m);
                        }
                        else
                        {
                            System.out.println("null photo object is returned");
                        }
                }
                return allURLs;
        }

        // source: flickr.com/services/api/misc.urls.html
        enum size {
                _s , _t ,_m
        };

        //helper method, to construct the url from the json object. You can define the size of the image that you want, with the size parameter. Be aware that not all images on flickr are available in all sizes.
        private static String constructFlickrImgUrl(JSONObject input, Enum size) throws JSONException {
                String FARMID = input.getString("farm");
                String SERVERID = input.getString("server");
                String SECRET = input.getString("secret");
                String ID = input.getString("id");

                StringBuilder sb = new StringBuilder();

                sb.append("http://farm");
                sb.append(FARMID);
                sb.append(".static.flickr.com/");
                sb.append(SERVERID);
                sb.append("/");
                sb.append(ID);
                sb.append("_");
                sb.append(SECRET);
                sb.append(size.toString());
                sb.append(".jpg");
                System.out.println(sb.toString());
                return sb.toString();
        }
}
