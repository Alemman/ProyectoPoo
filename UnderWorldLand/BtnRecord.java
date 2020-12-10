import greenfoot.*;

public class BtnRecord extends Button  
{

    public BtnRecord()
    {
        prepareButtons("images/btn-record-red.png", "images/btn-record-yellow.png"); 
    }

    public void doAction(){

        Greenfoot.setWorld(new Record());

    }
}
