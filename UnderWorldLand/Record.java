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
}
