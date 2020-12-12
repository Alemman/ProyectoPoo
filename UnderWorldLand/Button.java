import greenfoot.*;

abstract public class Button extends Actor
{
    protected static final int WIDTH_BUTTON = 130;
    protected static final int HEIGHT_BUTTON = 50;
    protected GreenfootImage []images;

    public Button()
    {

    }

    public void act(){
        if(Greenfoot.mouseClicked(this)){
            setImage(images[1]);
            Greenfoot.delay(10);

            doAction();
        }
    }

    protected void prepareButtons(String normalButtonState, String clickedButtonState){
        images = new GreenfootImage[2];
        images[0] = new GreenfootImage(normalButtonState);
        images[0].scale(WIDTH_BUTTON,HEIGHT_BUTTON);
        setImage(images[0]);

        images[1] = new GreenfootImage(clickedButtonState);
        images[1].scale(WIDTH_BUTTON,HEIGHT_BUTTON);
    }    

    abstract void doAction();
}
