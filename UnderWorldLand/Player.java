import greenfoot.*;

public class Player  
{
    private long points;
    private String username;

    public Player(long points, String username)
    {
        this.points = points;
        this.username = username;
    }

    public long getPoints(){
        return points;   
    }

    public String getUsername(){
        return username;   
    }
    
    public void setPoints(long points){
        this.points = points;   
    }

    public void setUsername(String username){
        this.username = username;   
    }
}
