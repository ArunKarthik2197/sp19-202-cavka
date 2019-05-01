import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PausedGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PausedGame extends World implements IGameState
{
    GreenfootImage[] images = new GreenfootImage[2];
    int imageNumber;
    /*
     * PausedGame Consturctor
     */
    public PausedGame()
    {
        super(870, 500, 1);
        setBackground("Paused1.jpg");
    }

    public void act()
    {
        animate();
        paused();
    }

    public void animate()
    {
        setBackground("Paused2.jpg");
    }

    public void paused()
    {
        String input = Greenfoot.ask("Game Paused. Hit R to Resume, Q to Quit");
        if(input.equalsIgnoreCase("R"))
            Default.sm.changeState(States.GAME);
        else if(input.equalsIgnoreCase("Q"))
            Default.sm.changeState(States.GAME_OVER);
    }
}
