import greenfoot.*;  

public class Botiquin extends Item
{
    private static final int INCREASE_LIFE = 1;
    public Botiquin(){
        GreenfootImage image = new GreenfootImage("images/botiquin.png");
        image.scale(25,25);
        setImage(image);
    }
    
    protected void collisions(){
        Hero hero = (Hero)getOneIntersectingObject(Hero.class);
        if(hero != null){
            hero.updateLife(false);
            (new GreenfootSound("sounds/bonus.wav")).play();

            getWorld().removeObject(this);
        } 
    }
}
