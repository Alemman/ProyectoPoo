import greenfoot.*;

public class BtnUp extends Button 
{
    public BtnUp()
    {
        GreenfootImage up_1 = new GreenfootImage("images/up-1.png");
        GreenfootImage up_2 = new GreenfootImage("images/up-2.png");
        up_1.scale(30,30);
        up_2.scale(30,30);
        prepareButtons(up_1, up_2);
    }

    void doAction(){
        setImage(images[0]);
    }
    
    public boolean buttonClicked(){
        return Greenfoot.mousePressed(this);
    }
}
