package picasso;

/**
 * ImageHandler.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 *
 */
import java.util.HashMap;
import java.util.Map;

public abstract class ImageHandler
{
    private static Map<String, String> myKeytoImageMap = new HashMap<String, String>(); //Maps image keys -> images
    private static Map<String, String> myImagetoKeyMap = new HashMap<String, String>(); //Maps images -> image keys
    private static int myCounter = 1; //Count of number of images

    /**
     * Adds an image.
     * @param fileName
     * @return the key corresponding to the image
     */
    public static String addImage(String fileName)
    {
        if (myImagetoKeyMap.containsKey(fileName))
            return myImagetoKeyMap.get(fileName);
        String key = new String("\"" + myCounter);
        myKeytoImageMap.put(key, fileName);
        myImagetoKeyMap.put(fileName, key);
        myCounter++;
        return key;
    }
    
    /**
     * Returns the image
     * @param key the key of the image
     * @return the filename of the image
     */
    public static String getImage(String key)
    {
        if (myKeytoImageMap.containsKey(key))
            return myKeytoImageMap.get(key);
        throw new PicassoException("Image does not exist");
    }
    
    /**
     * Clears all the images
     */
    public static void clearImages()
    {
        myKeytoImageMap.clear();
        myImagetoKeyMap.clear();
        myCounter = 1;
    }
}
