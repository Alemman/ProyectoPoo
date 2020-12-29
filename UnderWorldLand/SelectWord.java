import greenfoot.*;
import java.util.ArrayList;

public class SelectWord  extends Actor
{
    private static final ArrayList<String> ALPHABET = new ArrayList<String>();
    static
    {
      for(char character = 'A'; character <= 'Z' ; character++)
      {
          ALPHABET.add(String.valueOf(character));
      }
    }

    private BtnUp btnUp;
    private BtnDown btnDown;

    private int currentIndex;
    
    public SelectWord(){
        btnDown  = new BtnDown();
        btnUp  = new BtnUp();
       setImage(new GreenfootImage(ALPHABET.get(currentIndex), 45,  new Color(30, 130, 220, 180), new Color(27, 170, 255, 121), new Color(255, 255, 255, 255)));
   
    }       
    
    public void act(){
        if(btnUp.buttonClicked()){
            if(currentIndex < ALPHABET.size()-1)
                currentIndex++;
            setImage(new GreenfootImage(ALPHABET.get(currentIndex), 45,  new Color(30, 130, 220, 180), new Color(27, 170, 255, 121), new Color(255, 255, 255, 255)));
        }else if(btnDown.buttonClicked()){
            if(currentIndex > 0)
                currentIndex--;
            setImage(new GreenfootImage(ALPHABET.get(currentIndex), 45,  new Color(30, 130, 220, 180), new Color(27, 170, 255, 121), new Color(255, 255, 255, 255)));
        }
    }
    
    public String getCurrentWord(){
        return ALPHABET.get(currentIndex);
    }
    
    public BtnUp getBtnUp(){
        return btnUp;
    }
    
    public BtnDown getBtnDown(){
        return btnDown;
    }

}