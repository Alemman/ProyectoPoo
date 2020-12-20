import greenfoot.*; 
import java.util.HashMap; 

abstract public class Character extends Actor
{
    protected CharacterDirection direction;
    protected int currentSprite;
    protected int movementInX;
    protected int movementInY;
    private static final int GRAVITY = 1;
    protected boolean gravityOn = true;
    protected HashMapSprite hashMapSprites = new HashMapSprite();


    protected void walk(String keyDirection){
        currentSprite = (++currentSprite) % hashMapSprites.spritesCountByKey(keyDirection);
        setImage(hashMapSprites.currentSprite(keyDirection,currentSprite));
        setLocation(getX() + movementInX, getY());
    }

    protected void fallingInStyle(){
        movementInY += GRAVITY; 
    }

    abstract void jump();

    protected void move(String keyDirection){
        movementInX = 0;

        switch(keyDirection)
        {
            case "left":
            direction = CharacterDirection.LEFT;
            movementInX = -5;

            break;
            case "right":
            direction = CharacterDirection.RIGHT;
            movementInX = 5;

            break;
        }
    }

    protected void checkCollisions()
    {
        Actor actor = null; 

        switch(direction)
        {
            case RIGHT:
            actor = (Floor)getOneObjectAtOffset(20, 0, Floor.class);
            actor = (Rock)getOneObjectAtOffset(20, 0, Rock.class);
            break;
            case LEFT:
            actor = (Floor)getOneObjectAtOffset(-20, 0, Floor.class);
            actor = (Rock)getOneObjectAtOffset(-20, 0, Rock.class);
            break;

        }

        if(actor != null)
        {
            movementInY = 0;
            movementInX = 0;
        }
    }

}
