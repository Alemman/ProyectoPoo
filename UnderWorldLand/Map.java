import greenfoot.*;  

public class Map extends World
{
    private Hud hud = new Hud(0,Stage.FIRST,0);
    public Map()
    {    
        super(600, 600, 1);
    }

    public Hud getHud(){
        return hud;
    }

    public void setHud(Hud hud){
        this.hud = hud;
    }
}
