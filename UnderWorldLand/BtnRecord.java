import greenfoot.*;

public class BtnRecord extends Button  
{
    
    public BtnRecord()
    {
        image = new GreenfootImage("images/btn-record-red.png");
        image.scale(WIDTH_BUTTON,HEIGHT_BUTTON);
        setImage(image);
    }

    public void act(){
     if(Greenfoot.mouseClicked(this)){
           image = new GreenfootImage("images/btn-record-yellow.png");
           image.scale(WIDTH_BUTTON,HEIGHT_BUTTON);
           setImage(image);
           Greenfoot.delay(10);
            
           Greenfoot.setWorld(new Record());
        }
    }
}
