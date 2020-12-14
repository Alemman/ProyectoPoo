import greenfoot.*;

public class Player  
{
    private int points;
    private String username;

    public Player(int points, String username)
    {
        this.points = points;
        this.username = username;
    }

    public int getPoints(){
        return points;   
    }

    public String getUsername(){
        return username;   
    }
}
