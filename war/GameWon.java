import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWon extends World implements IGameState
{
GifImage wonImage;
    /**
     * Constructor for objects of class GameWon.
     * 
     */
    public GameWon()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(870, 500, 1); 
        wonImage = new GifImage("game_won.gif");
        wonImage.resizeImages(870, 500);
    }
    
    boolean first=true;
    
    public void act()
    {
        if(first){
            Greenfoot.playSound("victory_sound_slower.mp3");
            first=false;
        }
        animate();
    }
    
    public void animate()
    {
        setBackground(wonImage.getCurrentImage());
        System.err.println("GameWon");
    }
}
