import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.ArrayList;

public class Hero extends Character
{
    private static final int INITIAL_LIFES = 3;
    private static final int INITIAL_POINTS = 0;
    private static final int FALL_TIME = 5;
    private int fallTime = 0;
    private int lifes;
    private int points;


    public Hero(){
        ArrayList<GreenfootImage> spritesLeft = new ArrayList<GreenfootImage>();
        ArrayList<GreenfootImage> spritesRight =  new ArrayList<GreenfootImage>();   
        for(int i = 0; i<6; i++){
            spritesRight.add(new GreenfootImage("images/hero-walk-" + (i+1) + ".png"));
            spritesLeft.add(new GreenfootImage("images/hero-walk-" + (i+1) + ".png"));
            spritesLeft.get(i).mirrorHorizontally();
        }
        hashMapSprites.putSprites("right",spritesRight);
        hashMapSprites.putSprites("left",spritesLeft);
        ArrayList<GreenfootImage> spritesUp = new ArrayList<GreenfootImage>();
        ArrayList<GreenfootImage> spritesUpMirrorHorizontally =  new ArrayList<GreenfootImage>();
        for(int i = 0; i<2; i++){
            spritesUp.add(new GreenfootImage("images/hero-up-" + (i+1) + ".png"));
            spritesUpMirrorHorizontally.add(new GreenfootImage("images/hero-up-" + (i+1) + ".png"));
            spritesUpMirrorHorizontally.get(i).mirrorHorizontally();
        }
        hashMapSprites.putSprites("up",spritesUp);
        hashMapSprites.putSprites("upMirror",spritesUpMirrorHorizontally);

        currentSprite = 3;
        lifes = INITIAL_LIFES;
        points = INITIAL_POINTS;
        direction = CharacterDirection.RIGHT;
        setImage(hashMapSprites.currentSprite("left",3));

    }

    public void act() 
    {

        if(Greenfoot.isKeyDown("left") && !gravityOn)
        {
            move("left");
            checkCollisionsWalls();
            walk("left");

        }
        else if(Greenfoot.isKeyDown("right") && !gravityOn)
        {
            move("right");
            checkCollisionsWalls();
            walk("right");
        }else if(Greenfoot.isKeyDown("up") && fallTime++ <= FALL_TIME){
            jump();
            movementInY = 0;
        }

        if(!isTouching(Floor.class)){
            gravityOn = true;
            fallingInStyle();
            movementInX = (Greenfoot.isKeyDown("right")) ? 15: ((Greenfoot.isKeyDown("left")) ? -15: 0);
            setLocation(getX()+ movementInX, getY()+movementInY); 
            Greenfoot.delay(1);
        }else{
            gravityOn = false;
            fallTime = 0;
            String lastKeyPressed = Greenfoot.getKey();
            if(lastKeyPressed != null && lastKeyPressed.equals("left"))
                setImage(hashMapSprites.currentSprite("left",0));
            else if(lastKeyPressed != null && lastKeyPressed.equals("right"))
                setImage(hashMapSprites.currentSprite("right",0));
        }

    }

    void jump(){
            movementInY = -10;
            currentSprite = (++currentSprite) % hashMapSprites.spritesCountByKey("up");

            movementInX = (Greenfoot.isKeyDown("right")) ? 15: ((Greenfoot.isKeyDown("left")) ? -15: 0);
            setImage(
                (Greenfoot.isKeyDown("left"))
                ? hashMapSprites.currentSprite("upMirror",currentSprite)
                : hashMapSprites.currentSprite("up",currentSprite)
            );
            setLocation(getX()+ movementInX, getY()+ movementInY*fallTime);
        }

}
