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
            long pointsForHero = hud.getScore();
            pointsForHero += pointsUp;
            hud.setScore(pointsForHero);
    } 
    
    protected abstract void collisions();
}
