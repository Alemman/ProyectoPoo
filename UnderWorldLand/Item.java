import greenfoot.*;

public abstract class Item extends Actor
{
    
    public void act() 
    {
        collisions();
    }  
    protected void scoreIncrease(int pointsUp){
            Map map = (Map)getWorld();
            Hud hud = map.getHud();
            hud.addScore(pointsUp);
    } 
    
    protected abstract void collisions();
}
