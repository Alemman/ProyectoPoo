import greenfoot.*;
import java.util.HashMap;

public class HashMapSprite  
{
    private HashMap<String,GreenfootImage[]> hashMapSprites;
    public HashMapSprite()
    {
        hashMapSprites = new HashMap<String,GreenfootImage[]>();
    }
    public GreenfootImage currentSprite(String key,int currentIndex){
        GreenfootImage []array = hashMapSprites.get(key);
        return array[currentIndex];
    }
    
    public void putSprites(String key,GreenfootImage []value){
        hashMapSprites.put(key,value);
    }
    public int arrayLength(String key){
        GreenfootImage []array = hashMapSprites.get(key);
        return array.length;
    }

}
