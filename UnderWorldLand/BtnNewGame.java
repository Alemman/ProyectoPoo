import greenfoot.*;

public class BtnNewGame extends Button
{

    public BtnNewGame(){
        prepareButtons("images/btn-red.png", "images/btn-newgame-yellow.png"); 
    }

    public void doAction() 
    {
        Greenfoot.setWorld(new Map()); 
        MapLoader mapLoader = new MapLoader();
           
        Greenfoot.setWorld(mapLoader.loadMap(Stage.FIRST));
    } 

}
