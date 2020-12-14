import greenfoot.*;  
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;

public class Record extends Window
{
    public Record()
    {  
        prepareWindow();
    }

    public void prepareWindow(){
        GreenfootImage fondoRecord = new GreenfootImage("images/background-record.png");
        fondoRecord.scale(WIDTH_WORLD,HEIGHT_WORLD);
        setBackground(fondoRecord);
        showRecords();
        addObject(new BtnMainMenu(),X_BUTTON_MAIN,Y_BUTTON_MAIN);
    }

    public void showRecords() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("documents/record.txt"))){
            String line;
            int i = 0;
            while((line = bufferedReader.readLine()) != null){
                showText(line,WIDTH_WORLD/2,(HEIGHT_WORLD/3)+(20*i++));
            }
        }catch(IOException e){
            showText("record esta vacio",WIDTH_WORLD/2,HEIGHT_WORLD/2);
        }

    }

    private void writeRecords(Player player){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("documents/record.txt", true));
        PrintWriter out = new PrintWriter(bw))
        {
            out.print(player.getPoints());
            out.print(" ");
            out.println(player.getUsername());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void addRecord(Player playerToInsert){
        Player mayor;
        Player []players = readRecords();
        int current = 0;
        if(players != null){
            Player []playersToWrite = new Player[6];

            for(int i = 0;i < players.length && players[i] != null; i++){
                if(playerToInsert.getPoints() >= players[i].getPoints()){
                    for(int j = i; j < players.length && players[j] != null; j++){
                        if(j == 0)
                            playersToWrite[j] = playerToInsert;
                        playersToWrite[j+1] = players[j];
                    }
                    break;
                }else{
                    playersToWrite[i] = players[i];
                    playersToWrite[i+1] = playerToInsert;
                }
            }
            delete();
            for(int i = 0; i < playersToWrite.length-1 && playersToWrite[i] != null; i++){
                writeRecords(playersToWrite[i]);
            }
        }else{
            writeRecords(playerToInsert);
        }

    }

    private void delete(){
        File file = new File("documents/record.txt"); 
        if (!file.delete()) { 
            System.out.println("Failed to delete the file.");
        }
    }

    private Player [] readRecords(){
        Player []players = new Player[5];
        try(Scanner myReader = new Scanner(new File("documents/record.txt"))) {
            int i = 0;
            while (myReader.hasNextLine() && i < players.length){
                Player player = new Player(myReader.nextInt(),myReader.nextLine());
                players[i] = player;
                i++;
            }
            return players;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

}
