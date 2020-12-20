import greenfoot.*;  

public class BtnNextLevel extends Button
{
    public BtnNextLevel(){

        prepareButtons("images/btn-next-red.png", "images/btn-next-yellow.png"); 

    } 

    public void doAction() 
    {
        Map map = (Map)getWorld();
        MapLoader mapLoader = new MapLoader();
        map.getHud().setStartTime(0);
        (map.getHud()).setLevel((map.getHud().getLevel().equals(Stage.SECOND)) ? Stage.THIRD : Stage.SECOND);
        Greenfoot.setWorld(mapLoader.loadMap(map.getHud()));  
    } 
}
