import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Help extends Window
{
    public Help()
    {    
       prepareWindow();       
    }
    
    public void prepareWindow(){
        showText("Help.txt", 250, 100);
        addObject(new BtnMainMenu(),X_BUTTON_MAIN,Y_BUTTON_MAIN);
    }
}
