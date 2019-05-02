import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor implements IPlayerFactory
{
    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage drg;
    GifImage gifDrg;
    public Dragon()
    {
        drg=new GreenfootImage("viserion-2.jpg");
        drg.scale(80,80);
        gifDrg = new GifImage("dragon-flying.gif");
        gifDrg.resizeImages(80, 80);
        setImage(drg);
    }
    
    public void attack(ISubject s)
    {
        
    }
    public void act() 
    {
       // setImage(gifDrg.getCurrentImage());
        // Add your action code here.
    }    
}
