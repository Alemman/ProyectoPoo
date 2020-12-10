import greenfoot.*;

public class BtnHelp extends Button 
{
    public BtnHelp()
    {
        prepareButtons("images/btn-ayuda-red.png", "images/btn-ayuda-yellow.png");
    }

    void doAction(){
        Help help = new Help();
        Greenfoot.setWorld(help);
    }
}
