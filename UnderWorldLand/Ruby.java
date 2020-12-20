import greenfoot.*;


public class Ruby extends Item
{
    private static final int POINTS_UP = 500;
    
    public Ruby(){
        GreenfootImage image = new GreenfootImage("images/ruby.png");
        image.scale(25,25);
        setImage(image);
    }
     
    protected void collisions(){
        Hero hero = (Hero)getOneIntersectingObject(Hero.class);
        if(hero != null){
            scoreIncrease(POINTS_UP);
            (new GreenfootSound("sounds/coin-plus.wav")).play();
            getWorld().removeObject(this);
        }
    }
}
