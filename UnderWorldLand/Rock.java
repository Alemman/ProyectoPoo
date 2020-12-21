import greenfoot.*;  

public class Rock extends Actor implements Walkable
{
    public Rock(){
        GreenfootImage image = new GreenfootImage("images/rock.png");
        image.scale(100,100);
        setImage(image);
    }
  
}
