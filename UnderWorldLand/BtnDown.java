import greenfoot.*;

public class BtnDown extends Button 
{
    public BtnDown()
    {
        GreenfootImage down_1 = new GreenfootImage("images/down-1.png");
        GreenfootImage down_2 = new GreenfootImage("images/down-2.png");
        down_1.scale(30,30);
        down_2.scale(30,30);
        prepareButtons(down_1, down_2);
    }

    void doAction(){
        setImage(images[0]);
    }
    
    public boolean buttonClicked(){
        return Greenfoot.mousePressed(this);
    }
}
