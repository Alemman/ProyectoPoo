import greenfoot.*;  

public class Map extends World
{
    private Hud hud;
    public Map()
    {    
        super(600, 600, 1);
        hud = new Hud(0,Stage.FIRST,0);
    }

    public Hud getHud(){
        return hud;
    }

    public void setHud(Hud hud){
        this.hud = hud;
    }
}
