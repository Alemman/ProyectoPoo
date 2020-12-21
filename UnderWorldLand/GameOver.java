import greenfoot.*;  

public class GameOver extends Window
{
    public GameOver(GreenfootImage background)
    {
        prepareWindow(new GreenfootImage(background));
    }

    public GameOver()
    {
        prepareWindow();
    }

    public void prepareWindow(GreenfootImage background){
    } 

    public void prepareWindow(){
        GreenfootImage background = new GreenfootImage("images/game-over.jpg");
        background.scale(WIDTH_WORLD,HEIGHT_WORLD);
        setBackground(background);
        addObject(new BtnMainMenu(),X_BUTTON_MAIN,Y_BUTTON_MAIN);

    }  
}
