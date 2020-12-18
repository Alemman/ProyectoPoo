import greenfoot.*;
import java.util.HashMap;
import java.util.ArrayList;

public class HashMapSprite  
{
    private HashMap<String,ArrayList<GreenfootImage>> hashMapSprites;
    public HashMapSprite()
    {
        hashMapSprites = new HashMap<String,ArrayList<GreenfootImage>>();
    }
    public GreenfootImage currentSprite(String key,int currentIndex){
        ArrayList<GreenfootImage> arrayList = hashMapSprites.get(key);
        return arrayList.get(currentIndex);
    }
    
    public void putSprites(String key,ArrayList<GreenfootImage> value){
        hashMapSprites.put(key,value);
    }
    public int spritesCountByKey(String key){
        ArrayList<GreenfootImage> arrayList = hashMapSprites.get(key);
        return arrayList.size();
    }

}
