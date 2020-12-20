import greenfoot.*;  

public class Hud extends Actor
{
    private Stage level;
    private long score;
    private int lives;
    private long time;
    private long startTime = 0;

    public Hud(int lives,Stage level,int score){
        this.score = score;
        this.lives = lives;
        time = 0;
        this.level = level;
    }

    public void act() 
    {
        timer();
        setImage(new GreenfootImage(getTextHud(), 25,  new Color(30, 130, 220, 180), new Color(27, 170, 255, 121), new Color(255, 255, 255, 255)));
    }

    private String getTextHud(){
        return "Life: " + Integer.toString(lives)
        + "       Time: " + time + "\n"
        + "        Level: " + level
        + "  Score: " + Long.toString(score);
    }

    private void timer(){
        if(startTime == 0) startTime = System.currentTimeMillis();
        time = (int)((System.currentTimeMillis() - startTime)/1000);
    }

    public void setLevel(Stage stage){
        level = stage;
    }

    public void setScore(long score){
        this.score = score;
    }

    public void setStartTime(int startTime){
        this.startTime = startTime;
    }
    
    public void setLives(int lives){
        this.lives = lives;
    }

    public Stage getLevel(){
        return level;
    }

    public long getScore(){
        return score;
    }

    public int getLives(){
        return lives;
    } 

}
