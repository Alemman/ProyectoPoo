import greenfoot.*;  

public class BtnNextLevel extends Button
{
    public BtnNextLevel(){

        prepareButtons("images/btn-record-red.png", "images/btn-record-yellow.png"); 

    } 

    public void doAction() 
    {
        Map map = (Map)getWorld();
        MapLoader mapLoader = new MapLoader();
        Greenfoot.setWorld(mapLoader.loadMap(map.getHud()));
    } 
}
