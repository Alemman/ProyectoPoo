import greenfoot.*;

public class BtnExit  extends Button
{

    public BtnExit()
    {
        prepareButtons("images/btn-ayuda-red.png", "images/btn-ayuda-yellow.png");
    }

    void doAction(){
        Help help = new Help();
        Greenfoot.setWorld(help);
    }

}
