import greenfoot.*;  
import java.util.HashMap;
import java.util.ArrayList;

public class Hero extends Character
{
    private static final int INITIAL_LIFES = 3;
    private static final int INITIAL_POINTS = 0;
    private static final int FALL_TIME = 4;
    private static final int INITIAL_ITEMS = 4;
    private static final int AMOUNT_BY_LIFE = 20;
    private int activatedWeapon;
    private CharacterDirection directionInX;
    private int fallTime = 0;
    private int lifes;
    private int points;
    private int amountByLife;

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

        ArrayList<GreenfootImage> spritesKnockRight = new ArrayList<GreenfootImage>();
        ArrayList<GreenfootImage> spritesKnockLeft =  new ArrayList<GreenfootImage>();
        for(int i = 0; i<2; i++){
            spritesKnockRight.add(new GreenfootImage("images/hero-knock-" + (i+1) + ".png"));
            spritesKnockLeft.add(new GreenfootImage("images/hero-knock-" + (i+1) + ".png"));
            spritesKnockLeft.get(i).mirrorHorizontally();
        }
        hashMapSprites.putSprites("hitToTheRight",spritesKnockRight);
        hashMapSprites.putSprites("hitToTheLeft",spritesKnockLeft);

        ArrayList<GreenfootImage> spritesShootRight = new ArrayList<GreenfootImage>();
        ArrayList<GreenfootImage> spritesShootLeft =  new ArrayList<GreenfootImage>();
        spritesShootRight.add(new GreenfootImage("images/hero-shoot.png"));
        spritesShootLeft.add(new GreenfootImage("images/hero-shoot.png"));
        spritesShootLeft.get(0).mirrorHorizontally();

        hashMapSprites.putSprites("shootRight",spritesShootRight);
        hashMapSprites.putSprites("shootLeft",spritesShootLeft);

        currentSprite = 3;
        lifes = INITIAL_LIFES;
        points = INITIAL_POINTS;
        direction = CharacterDirection.RIGHT;
        setImage(hashMapSprites.currentSprite("left",3));
        directionInX = CharacterDirection.LEFT;
        activatedWeapon = INITIAL_ITEMS;
        amountByLife = AMOUNT_BY_LIFE;
    }

    public void act() 
    {
        if(lifes > 0){
            if(!isFinishLevel()){
                if(Greenfoot.isKeyDown("left") && !gravityOn)
                {
                    directionInX = CharacterDirection.LEFT;
                    move("left");
                    checkCollisions();
                    walk("left");

                }
                else if(Greenfoot.isKeyDown("right") && !gravityOn)
                {
                    directionInX = CharacterDirection.RIGHT;
                    move("right");
                    checkCollisions();
                    walk("right");
                }else if(Greenfoot.isKeyDown("up") && fallTime++ <= FALL_TIME){
                    (new GreenfootSound("sounds/jump.wav")).play();
                    jump();
                    movementInY = 0;
                }

                if(!isTouching(Rock.class) && !isTouching(Floor.class)){
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
                if(Greenfoot.isKeyDown("space") && activatedWeapon <= 0)
                    shootWeapon();

                checkCollisionsEnemy();                       
            }else{
                if(((Map)getWorld()).getHud().getLevel().equals(Stage.THIRD))
                    gameOver(true);
                else
                    showWindow();
            }

        }else{
            gameOver(false);
        }
    }

    public void setActivatedWeapon(int activatedWeapon){
        this.activatedWeapon = activatedWeapon;   
    }

    public int getActivatedWeapon(){
        return activatedWeapon;   
    }

    private void showWindow(){
        Map world = (Map)getWorld();
        Hud hud = world.getHud();

        world.addObject( new BtnNextLevel(),world.getWidth()/2,world.getHeight()/2);
        WindowSummary window = new WindowSummary();
        world.addObject(window,world.getWidth()/2,200);
        window.showSummary(hud);

    }

    private void gameOver(boolean gameFinish){
        if(gameFinish)
        {
            Hud hud = ((Map)getWorld()).getHud();
            Player player = new Player(hud.getScore(),"");
            Greenfoot.setWorld(new GameOver(new GreenfootImage("images/background-black.jpg"),player));
        }
        else
        {
            (new GreenfootSound("sounds/game-over.wav")).play();
            Greenfoot.setWorld(new GameOver());
        }
    }    

    private void checkCollisionsEnemy(){

        if((Enemy)getOneObjectAtOffset(20, 0, Enemy.class) != null){
            move("left");
            checkCollisions();
            walk("hitToTheRight");
            updateLife(true);
            (new GreenfootSound("sounds/jab-jab.wav")).play();
            Greenfoot.delay(4);
        }
        else if((Enemy)getOneObjectAtOffset(-20, 0, Enemy.class) != null)
        {
            move("right");
            checkCollisions();
            walk("hitToTheLeft");
            updateLife(true);
            (new GreenfootSound("sounds/jab-jab.wav")).play();
            Greenfoot.delay(4);
        }

    }

    public void updateLife(boolean less){
        if(less)
        {
            amountByLife --;
            if(amountByLife <= 0)
            {
                --lifes;
                Map map = (Map)getWorld();
                Hud hud = map.getHud();
                hud.setLives(lifes);
                amountByLife = AMOUNT_BY_LIFE;
            }
        }
        else
        {
            ++lifes;
            Map map = (Map)getWorld();
            Hud hud = map.getHud();
            hud.setLives(lifes);
        }
    }

    private void shootWeapon(){
        Map world = (Map)getWorld();
        if(directionInX.equals(CharacterDirection.LEFT))
        {
            currentSprite = (++currentSprite) % hashMapSprites.spritesCountByKey("shootLeft");
            setImage(hashMapSprites.currentSprite("shootLeft",currentSprite));
            world.addObject(new Bullet(CharacterDirection.LEFT),getX()-50,getY());         
        }
        else
        {
            currentSprite = (++currentSprite) % hashMapSprites.spritesCountByKey("shootRight");
            setImage(hashMapSprites.currentSprite("shootRight",currentSprite));
            world.addObject(new Bullet(CharacterDirection.RIGHT),getX()+50,getY()); 
        }
        (new GreenfootSound("sounds/EnergyGun.wav")).play();
    }

    private boolean isFinishLevel(){
        World world = getWorld();
        return world.getObjects(Enemy.class).isEmpty();
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
