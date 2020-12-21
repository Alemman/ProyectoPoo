import greenfoot.*;
import java.util.LinkedList;

public class SelectWord  extends Actor
{
    private static final LinkedList<String> ALPHABET = new LinkedList<String>()
    {{
        add("A");add("B");add("C");add("D");add("E");
        add("F");add("G");add("H");add("I");add("J");
        add("K");add("L");add("M");add("N");add("O");
        add("P");add("Q");add("R");add("S");add("T");
        add("U");add("V");add("W");add("X");add("Y");
        add("Z");
    }};

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