import greenfoot.*;  
import java.util.ArrayList;
public class BtnSaveName extends Button
{
    public BtnSaveName()
    {
        prepareButtons("images/guardar-red.png", "images/guardar-yellow.png");
    }

    void doAction(){
        saveRecord();
    }
    
    private void saveRecord(){
        GameOver world = (GameOver)getWorld();
        Player player = world.getPlayer();
        ArrayList<SelectWord> list = world.getWords();
        StringBuilder userName = new StringBuilder();
        for(SelectWord selectWord : list){
             userName.append(selectWord.getCurrentWord());
            }
        player.setUsername(userName.toString());
        UpdateData updateDate = new UpdateData();
        updateDate.addRecord(player);
        world.setIsTheEnd(true);
    }
}

