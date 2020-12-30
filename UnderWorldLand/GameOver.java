import greenfoot.*;  
import java.util.ArrayList;
import java.util.List;  

public class GameOver extends Window
{
    private Player player;
    private static final int POSITION_X = 170;
    private static final int POSITION_Y = 300;
    private ArrayList<SelectWord> word = new ArrayList<SelectWord>();
    private boolean isTheEnd = false;    
    public GameOver(GreenfootImage background,Player player)
    {
        this.player = player;
        prepareWindow(new GreenfootImage(background));
    }


    public GameOver()
    {
        prepareWindow();
    }
    
    public void act(){
        if(isTheEnd){
            finishGame();
        }
    }    

    private void finishGame(){
        removeObjects();
        GreenfootImage image = new GreenfootImage("images/final.png");
        image.scale(getWidth(),getHeight());
        setBackground(image);
        Greenfoot.delay(50);
        GreenfootSound musicCredits = new GreenfootSound("sounds/Music.wav");
        musicCredits.play();
        while(musicCredits.isPlaying())
            Thread.yield();
        setBackground("images/game-over.jpg");
        (new GreenfootSound("sounds/game-over.wav")).play();
        Greenfoot.delay(500);
        Greenfoot.setWorld(new Menu());
    }
    
    private void removeObjects(){
        List<Actor> list = getObjects(Actor.class);
        removeObjects(list);
    }    
    

    public void prepareWindow(GreenfootImage background){
        background.scale(getWidth(),getHeight());
        setBackground(background);
        addObject(new BtnSaveName(),getWidth()/2,getHeight()-100);
        for(int i = 0; i < 3; i++)
            addSelectWord(POSITION_X/2 + (POSITION_X * i),POSITION_Y,i);
    } 

    private void addSelectWord(int x, int y,int current){
        word.add(new SelectWord());
        addObject(word.get(current),x,y);
        addObject(word.get(current).getBtnUp(),x,y-50);
        addObject(word.get(current).getBtnDown(),x,y+50);
    }

    public ArrayList getWords(){
        return word;
    }

    public Player getPlayer(){
        return player;
    }

    public void setIsTheEnd(boolean isTheEnd){
        this.isTheEnd = isTheEnd;   
    }

    
    public void prepareWindow(){
        GreenfootImage background = new GreenfootImage("images/game-over.jpg");
        background.scale(WIDTH_WORLD,HEIGHT_WORLD);
        setBackground(background);
        addObject(new BtnMainMenu(),X_BUTTON_MAIN,Y_BUTTON_MAIN);

    }  
}
