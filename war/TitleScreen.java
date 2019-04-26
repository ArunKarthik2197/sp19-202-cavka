import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    private int counter=0; 
    private GifImage gif;
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
       // Greenfoot.start();
        gif= new GifImage("dragon-flying.gif");
        
    }
    
    public void act()
    {
        animation();
        if (++counter == 200) Greenfoot.setWorld(new MyWorld());
    }
    private void animation()
    {
        setBackground(gif.getCurrentImage());
    }
}
