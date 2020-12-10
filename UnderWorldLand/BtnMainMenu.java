import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BtnMainMenu extends Button
{
    public BtnMainMenu(){
        prepareButtons("images/btn-mainmenu-red.png", "images/btn-mainmenu-yellow.png");
    }

    public void doAction() 
    {
        Menu mainMenu = new Menu();
        
        Greenfoot.setWorld(mainMenu);
    }    
}
