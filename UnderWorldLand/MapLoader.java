import greenfoot.*;

public class MapLoader  
{
    private static final int INCREASE_WALL_POSITION = 100;

    public Map loadMap(Hud hud){
        Map map = new Map();
        drawMap(map,hud);
        return map;
    }

    private void drawMap(Map map,Hud hud){
        switch(hud.getLevel()){
            case FIRST:
            drawStage1(map,new GreenfootImage("images/background-stage2.jpg"),hud);
            break;
            case SECOND:
            drawStage1(map,new GreenfootImage("images/background-stage2.jpg"),hud);
            break;
            case THIRD:
            drawStage1(map,new GreenfootImage("images/background-stage3.jpg"),hud);
            break;
        }

    }

    private void drawStage1(Map map,GreenfootImage background,Hud hud){
        background.scale(map.getWidth(),map.getWidth());
        map.setBackground(background);

        map.addObject(hud, 400,50 );
        map.setHud(hud);

        for(int i = 0; i <= 400; i+=INCREASE_WALL_POSITION){
            map.addObject(new Wall(new GreenfootImage("images/wall-stage1v.png")), 15, i);
            map.addObject(new Wall(new GreenfootImage("images/wall-stage1v.png")), 585, i);
        }
        for(int i = 0; i <= 600; i+=INCREASE_WALL_POSITION){
            map.addObject(new Floor(new GreenfootImage("images/wall-stage1.png")), i, 585);
        }

        map.addObject(new ItemJ(), 400, 550);
        map.addObject(new ItemAPink(), 450, 550);
        map.addObject(new ItemABlack(), 550, 550);
        map.addObject(new ItemV(), 500, 550);
        map.addObject(new Hero(),300,50);
        map.addObject(new Enemy(),300,50);
        map.addObject(new BtnMainMenu(),70,30);
    }

    private void drawStage2(Map map,GreenfootImage background,Hud hud){
        map.addObject(new Wall(new GreenfootImage("images/wall-stage1.png")), 50, 150);
    }

    private void drawStage3(Map map,GreenfootImage background,Hud hud){
        background.scale(map.getWidth(),map.getWidth());
        map.setBackground(background);

        for(int i = 0; i <= 600; i+=100){
            map.addObject(new Wall(new GreenfootImage("images/wall-stage1v.png")), 15, i);
            map.addObject(new Wall(new GreenfootImage("images/wall-stage1v.png")), 585, i);
            map.addObject(new Floor(new GreenfootImage("images/wall-stage1.png")), i, 585);
        }

        for(int i = 350; i <= 550; i+=100){
            map.addObject(new Floor(new GreenfootImage("images/wall-stage1.png")), i, 555);
        }
        for(int i = 0; i<=100; i+=100){
            map.addObject(new Floor(new GreenfootImage("images/wall-stage1.png")), i, 450);
        }
        map.addObject(new Floor(new GreenfootImage("images/wall-stage1.png")), 550, 525);
        map.addObject(new Floor(new GreenfootImage("images/wall-stage1.png")), 450, 525);

        map.addObject(new Hero(),300,50);
        map.addObject(new BtnMainMenu(),70,30);
    }
}
