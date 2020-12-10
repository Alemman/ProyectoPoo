import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Record extends Window
{

    public Record()
    {    
        prepareWindow();
    }
    
    public void prepareWindow(){
        showText("record.txt", 250, 100);
          
        addObject(new BtnMainMenu(),X_BUTTON_MAIN,Y_BUTTON_MAIN);
    }
}
