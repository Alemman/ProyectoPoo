import greenfoot.*;  

public class ItemJ extends Item
{
    private static final int POINTS_UP = 800;
    
    public ItemJ(){
        GreenfootImage image = new GreenfootImage("images/item-j.png");
        image.scale(25,25);
        setImage(image);
    }
    
    protected void collisions(){
        Hero hero = (Hero)getOneIntersectingObject(Hero.class);
        if(hero != null){
            scoreIncrease(POINTS_UP);
            (new GreenfootSound("sounds/bonus.wav")).play();
            setLocation(150,50); 
            int activatedWeapon = hero.getActivatedWeapon();
            hero.setActivatedWeapon(--activatedWeapon);
        }
    }   
}
