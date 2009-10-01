package picasso;

/**
 * ImageHandler.java
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 *
 */
import java.util.HashMap;
import java.util.Map;

public abstract class ImageHandler
{
    private static Map<String, String> myKeytoImageMap = new HashMap<String, String>();
    private static Map<String, String> myImagetoKeyMap = new HashMap<String, String>();
    private static int myCounter = 1;

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

    public static String getImage(String key)
    {
        if (myKeytoImageMap.containsKey(key))
            return myKeytoImageMap.get(key);
        throw new PicassoException("Image does not exist");
    }

    public static void clearImages()
    {
        myKeytoImageMap.clear();
        myImagetoKeyMap.clear();
        myCounter = 1;
    }
}
