import greenfoot.*;

public class BtnNewGame extends Button
{
    private static final int INITIAL_LIFE = 3;
    private static final Stage INITIAL_LEVEL = Stage.FIRST;
    private static final int INITIAL_POINTS = 0;

    public BtnNewGame(){
        prepareButtons("images/btn-red.png", "images/btn-newgame-yellow.png"); 
    }

    public void doAction() 
    {
        MapLoader mapLoader = new MapLoader();
        Greenfoot.setWorld(mapLoader.loadMap(new Hud(INITIAL_LIFE,INITIAL_LEVEL,INITIAL_POINTS)));     
    } 

}
