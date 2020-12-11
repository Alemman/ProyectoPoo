import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Help extends Window
{  
    public Help()
    {    
       prepareWindow();       
    }
    
    public void prepareWindow(){
       GreenfootImage fondoHelp = new GreenfootImage("images/como-jugar.png");
       fondoHelp.scale(WIDTH_WORLD,HEIGHT_WORLD);
       setBackground(fondoHelp);
       addObject(new BtnMainMenu(),X_BUTTON_MAIN,Y_BUTTON_MAIN);
    }   
}
