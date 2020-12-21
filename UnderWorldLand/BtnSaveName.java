import greenfoot.*;  
import java.util.ArrayList;
public class BtnSaveName extends Button
{
    public BtnSaveName()
    {
        prepareButtons("images/btn-ayuda-red.png", "images/btn-ayuda-yellow.png");
    }

    void doAction(){
        saveRecord();
    }
    
    private void saveRecord(){
        GameOver world = (GameOver)getWorld();
        Player player = world.getPlayer();
        ArrayList<SelectWord> list = world.getWords();
        String userName = "";
        for(SelectWord selectWord : list){
            userName += selectWord.getCurrentWord();
        }
        
        player.setUsername(userName);
        UpdateData updateDate = new UpdateData();
        updateDate.addRecord(player);
        world.setIsTheEnd(true);
    }
}

