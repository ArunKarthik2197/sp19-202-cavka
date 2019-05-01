import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World implements IGameState
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    GifImage overImage;
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(870, 500, 1); 
        overImage = new GifImage("game_end_final.gif");
        overImage.resizeImages(870, 500);
        setBackground("game_end.gif");
    }

    public void act()
    {
        animate();
        if(Greenfoot.isKeyDown("enter"))
            Default.sm.changeState(States.PLAY_AGAIN);
        else if(Greenfoot.isKeyDown("q"))
        {
            Default.sm.changeState(States.TITLE);
            Greenfoot.stop();
        }
    }

    public void animate()
    {
        setBackground(overImage.getCurrentImage());
        showText("Press return to play again",600,300);
        showText("Press Q to quit game",600,350);
    }
}
