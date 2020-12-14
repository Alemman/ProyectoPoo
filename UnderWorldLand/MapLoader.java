import greenfoot.*;

public class MapLoader  
{

    public Map loadMap(Stage stage){
        Map map = new Map();
        drawMap(stage,map);
        return map;
    }

    private void drawMap(Stage stage,Map map){
        switch(stage){
            case FIRST:
            drawStage1(map,new GreenfootImage("images/background-stage1.png"));
            break;
            case SECOND:
            drawStage1(map,new GreenfootImage("images/background-stage2.jpg"));
            break;
            case THIRD:
            drawStage1(map,new GreenfootImage("images/background-stage3.jpg"));
            break;
        }

    }

    private void drawStage1(Map map,GreenfootImage background){
        background.scale(map.getWidth(),map.getWidth());
        map.setBackground(background);

        for(int i = 0; i <= 600; i+=100){
            map.addObject(new Wall(new GreenfootImage("images/wall-stage1v.png")), 15, i);
            map.addObject(new Wall(new GreenfootImage("images/wall-stage1v.png")), 585, i);
            map.addObject(new Wall(new GreenfootImage("images/wall-stage1.png")), i, 585);
        }

        for(int i = 350; i <= 550; i+=100){
            map.addObject(new Wall(new GreenfootImage("images/wall-stage1.png")), i, 555);
        }
        for(int i = 0; i<=300; i+=100){
            map.addObject(new Wall(new GreenfootImage("images/wall-stage1.png")), i, 450);
        }
        map.addObject(new Wall(new GreenfootImage("images/wall-stage1.png")), 550, 525);
        map.addObject(new Wall(new GreenfootImage("images/wall-stage1.png")), 450, 525);

        map.addObject(new Item(new GreenfootImage("images/items-j.png")), 200, 525);
        map.addObject(new Item(new GreenfootImage("images/items-a.png")), 150, 325);
        map.addObject(new Item(new GreenfootImage("images/items-a.png")), 550, 425);
        map.addObject(new Item(new GreenfootImage("images/items-v.png")), 500, 325);

        map.addObject(new BtnMainMenu(),70,30);
    }

    private void drawStage2(Map map){
        map.addObject(new Wall(new GreenfootImage("images/wall-stage1.png")), 50, 150);
    }

    private void drawStage3(Map map){
        map.addObject(new Wall(new GreenfootImage("images/wall-stage1.png")), 50, 150);
    }
}
