import greenfoot.*;  

public class WindowSummary extends Actor
{  
    public void showSummary(Hud hud){
        String summary = "Puntos: " + hud.getScore() + "\nVida: " + hud.getLives();
        setImage(new GreenfootImage(summary, 30,  new Color(227, 57, 135, 115), new Color(0, 0, 0, 0), new Color(255, 255, 255, 255)));

    }
}
