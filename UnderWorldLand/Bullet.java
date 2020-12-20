import greenfoot.*;  

public class Bullet extends Actor
{
    private static final int REWARD = 100;
    private long pointsForHero;
    private CharacterDirection direction;
    
    
    public Bullet(CharacterDirection direction){
        GreenfootImage image = new GreenfootImage("images/bullet.png");
        image.scale(5,40);
        setImage(image);
        this.direction = direction;
    }

    public void act() 
    {
        move();
        if(bulletIsDeath()){
            getWorld().removeObject(this);
        }
    }    
    
    
    private boolean bulletIsDeath(){
        World world = getWorld();
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        Rock rock = (Rock)getOneIntersectingObject(Rock.class);
        if(enemy != null){
            (new GreenfootSound("sounds/Explosion.wav")).play();
            setImage("images/explosion-1.png");
            Greenfoot.delay(1);
            setImage("images/explosion-2.png");
            Greenfoot.delay(1);
            Map map = (Map)getWorld();
            Hud hud = map.getHud();
            pointsForHero = hud.getScore();
            pointsForHero += REWARD;
            hud.setScore(pointsForHero);
            return true;
        }else if(rock != null){
            return true;
        }
        return (getX()-world.getWidth() == -1) ? true : (getX()-world.getWidth() == -world.getWidth()) ? true: false;
    }

    private void move(){
        int increase = 0;
        if(direction.equals(CharacterDirection.LEFT)){
            increase -= 5;
            setLocation(getX()+ increase, getY());
        }else{
            increase += 5;
            setLocation(getX()+ increase, getY());
        }
    }
}