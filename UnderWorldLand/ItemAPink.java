import greenfoot.*;  

public class ItemAPink extends Item
{
    private static final int POINTS_UP = 800;
    
    public ItemAPink(){
        GreenfootImage image = new GreenfootImage("images/item-a-pink.png");
        image.scale(25,25);
        setImage(image);
    }
    
    protected void collisions(){
        Hero hero = (Hero)getOneIntersectingObject(Hero.class);
        if(hero != null){
            scoreIncrease(POINTS_UP);
            (new GreenfootSound("sounds/bonus.wav")).play();
            setLocation(175,50); 
            int activatedWeapon = hero.getActivatedWeapon();
            hero.setActivatedWeapon(--activatedWeapon);
        }
    }  
}
