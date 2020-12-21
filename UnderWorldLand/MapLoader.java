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
            drawStage1(map,new GreenfootImage("images/background-stage1.png"),hud);
            break;
            case SECOND:
            drawStage2(map,new GreenfootImage("images/background-stage2.jpg"),hud);
            break;
            case THIRD:
            drawStage3(map,new GreenfootImage("images/background-stage3.jpg"),hud);
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
        for(int i = 100; i <= 600; i+=INCREASE_WALL_POSITION/2)
            map.addObject(new Ruby(),i,400);
            
        map.addObject(new Ruby(),200,450);        
        map.addObject(new Rock(), 200, 530);
        map.addObject(new ItemJ(), 100, 350);
        map.addObject(new ItemAPink(), 350, 350);
        map.addObject(new ItemABlack(), 550, 550);
        map.addObject(new ItemV(), 150, 350);
        map.addObject(new Hero(),80,500);
        map.addObject(new Enemy(),500,500);
        map.addObject(new BtnMainMenu(),70,30);
    }

    private void drawStage2(Map map,GreenfootImage background,Hud hud){
        background.scale(map.getWidth(),map.getWidth());
        map.setBackground(background);

        map.addObject(hud, 400,50 );
        map.setHud(hud);


        for(int i = 0; i <= 600; i+=INCREASE_WALL_POSITION){
            map.addObject(new Floor(new GreenfootImage("images/wall-stage1.png")), i, 585);
        }
        int position_y = 600;
        for(int i = 0; i <3; i++){
            position_y -= 25;
            for(int j = 0; j <= 200; j+=INCREASE_WALL_POSITION){
                map.addObject(new Floor(new GreenfootImage("images/wall-stage1.png")), j, position_y);
            }
        }
        map.addObject(new Wall(new GreenfootImage("images/wall-stage1.png")), 200, 580);
        
        for(int i = 600; i >= 300; i-=INCREASE_WALL_POSITION){
            map.addObject(new Floor(new GreenfootImage("images/wall-stage1.png")), i, 250);
        }
        for(int i = 100; i <= 600; i+=INCREASE_WALL_POSITION/2)
            map.addObject(new Ruby(),i,400);
            
        map.addObject(new ItemJ(), 80, 420);
        map.addObject(new ItemAPink(), 300, 200);
        map.addObject(new ItemABlack(), 550, 200);
        map.addObject(new ItemV(), 500, 550);
        map.addObject(new Botiquin(), 500, 400);
        map.addObject(new Hero(),400,50);
        map.addObject(new Enemy(),80,500);
        map.addObject(new BtnMainMenu(),70,30);
    }
    

    private void drawStage3(Map map,GreenfootImage background,Hud hud){
        background.scale(map.getWidth(),map.getWidth());
        map.setBackground(background);

        map.addObject(hud, 400,50 );
        map.setHud(hud);

        for(int i = 0; i <= 600; i+=INCREASE_WALL_POSITION){
            map.addObject(new Wall(new GreenfootImage("images/wall-stage1v.png")), 15, i);
            map.addObject(new Wall(new GreenfootImage("images/wall-stage1v.png")), 585, i);
        }
        for(int i = 0; i <= 600; i+=INCREASE_WALL_POSITION){
            map.addObject(new Floor(new GreenfootImage("images/wall-stage1.png")), i, 585);
        }

        for(int i = 600; i >= 400; i-=INCREASE_WALL_POSITION){
            map.addObject(new Floor(new GreenfootImage("images/wall-stage1.png")), i, 150);
        }
        for(int i = 50; i <= 200; i+=INCREASE_WALL_POSITION){
            map.addObject(new Floor(new GreenfootImage("images/wall-stage1.png")), i, 300);
        }
        for(int i = 100; i <= 600; i+=INCREASE_WALL_POSITION/2)
            map.addObject(new Ruby(),i,400);
        
        map.addObject(new ItemJ(), 200, 200);
        map.addObject(new ItemAPink(), 150, 450);
        map.addObject(new ItemABlack(), 100, 550);
        map.addObject(new ItemV(), 500, 550);
        map.addObject(new Hero(),500,100);
        map.addObject(new Enemy(),80,500);
        map.addObject(new BtnMainMenu(),70,30);
        map.addObject(new Ruby(),400,450);
        map.addObject(new Rock(), 400, 530);
    }
}
