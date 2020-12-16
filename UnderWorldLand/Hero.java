import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;

public class Hero extends Character
{
    private static final int INITIAL_LIFES = 3;
    private static final int INITIAL_POINTS = 0;

    private int lifes;
    private int points;


    public Hero(){
        GreenfootImage []spritesLeft = new GreenfootImage[6];
        GreenfootImage []spritesRight = new GreenfootImage[6];   
        for(int i = 0; i<6; i++){
            spritesRight[i] = new GreenfootImage("images/hero-walk-" + (i+1) + ".png");
            spritesLeft[i] = new GreenfootImage("images/hero-walk-" + (i+1) + ".png");
            spritesLeft[i].mirrorHorizontally();
        }
        hashMapSprites.putSprites("right",spritesRight);
        hashMapSprites.putSprites("left",spritesLeft);
        GreenfootImage []spritesUp = new GreenfootImage[2];
        GreenfootImage []spritesUpMirrorHorizontally = new GreenfootImage[2];
        for(int i = 0; i<2; i++){
            spritesUp[i] = new GreenfootImage("images/hero-up-" + (i+1) + ".png");
            spritesUpMirrorHorizontally[i] = new GreenfootImage("images/hero-up-" + (i+1) + ".png");
            spritesUpMirrorHorizontally[i].mirrorHorizontally();
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
        }else if(Greenfoot.isKeyDown("up") && isTouching(Floor.class)){
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
            String lastKeyPressed = Greenfoot.getKey();
            if(lastKeyPressed != null && lastKeyPressed.equals("left"))
                setImage(hashMapSprites.currentSprite("left",0));
            else if(lastKeyPressed != null && lastKeyPressed.equals("right"))
                setImage(hashMapSprites.currentSprite("right",0));
        }

    }

    void jump(){
        movementInY = -10;
        String lastKeyPressed = Greenfoot.getKey();
        lastKeyPressed = Greenfoot.getKey();
        for(int i = 0; i<5; i++){ 
            currentSprite = (++currentSprite) % hashMapSprites.arrayLength("up");
            movementInX = (Greenfoot.isKeyDown("right")) ? 15: ((Greenfoot.isKeyDown("left")) ? -15: 0);
            setImage((Greenfoot.isKeyDown("left"))
                ? hashMapSprites.currentSprite("upMirror",currentSprite)
                : hashMapSprites.currentSprite("up",currentSprite)
            );
            setLocation(getX()+ movementInX, getY()+ movementInY*i);
            Greenfoot.delay(3);
        }
    }

}
