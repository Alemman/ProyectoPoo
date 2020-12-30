import greenfoot.*;  
import java.util.HashMap;
import java.util.ArrayList;

public class Enemy extends Character
{
    private static final int HURT = 100;
    private static final long POWER = 10000;
    private long power;
    private int position = 1;
    private int pointsForHero;

    public Enemy(){
        ArrayList<GreenfootImage> spritesLeft = new ArrayList<GreenfootImage>();
        ArrayList<GreenfootImage> spritesRight =  new ArrayList<GreenfootImage>();  
        for(int i = 0; i<6; i++){
            spritesRight.add(new GreenfootImage("images/alien-" + (i+1) + ".png"));
            spritesLeft.add(new GreenfootImage("images/alien-" + (i+1) + ".png"));
            spritesLeft.get(i).mirrorHorizontally();
        }
        hashMapSprites.putSprites("right",spritesRight);
        hashMapSprites.putSprites("left",spritesLeft);

        power = POWER;
    }

    public void act() 
    {
        if(isAtEdge() || isTouching(Rock.class) || isTouching(Wall.class))
            position *= -1;
        if(position > 0){
            move("right");
            Greenfoot.delay(2);
            walk("right");
        }else{
            move("left");
            Greenfoot.delay(2);
            walk("left");
        }
        
        if(!isTouching(Floor.class)){
            fallingInStyle();
            setLocation(getX(), getY()+ movementInY); 
        }

        if(isDeath())
            getWorld().removeObject(this);
    } 

    private boolean isDeath(){
        Bullet bullet = (Bullet)getOneIntersectingObject(Bullet.class);
        if(bullet != null){
            power -= HURT;
        }
        return power <= 0;
    }

    void jump(){
    }
}