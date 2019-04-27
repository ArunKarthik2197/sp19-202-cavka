import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MyWorld extends World
{
   static SelectedTab selectedTab;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    static MyWorld world;
    List<Subject> all;
    static List<Wall> wall;
    static Man man;
    static NightKing nightKing;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        world = this;
        all= new ArrayList<Subject>();
        wall = new ArrayList<Wall>();
        prepare();
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        selectedTab = new SelectedTab();
        addObject(selectedTab,93,125);
        

        Castle castle = new Castle();
        addObject(castle,37,749);
        castle.setLocation(456,760);

        nightKing = new NightKing();
        addObject(nightKing,505,143);
        nightKing.setLocation(468,43);

        man = new Man();
        addObject(man,421,572);
        int start=0;
        for(int i=0;i<15;i++)
        {

            wall.add(new Wall());
            int width = wall.get(i).getImage().getWidth();

            addObject(wall.get(i),start,680);
            start=start+width;
        }

        
    }
    
    public void act()
    {
       
        if(Greenfoot.isKeyDown("p"))
        paused();
    }
    
    public static SelectedTab getSelectedTab()
    {
        return selectedTab;
    }
    
    
    
    public static MyWorld getMyWorld()
    {
        return world;
    }
    
    public static Man getMan()
    {
        return man;
    }
    
    public static NightKing getNK()
    {
        return nightKing;
    }
    
    public void paused()
    {
        String answer=Greenfoot.ask("Want to quit? if yes press Y or press N to resume");
        if(answer.equalsIgnoreCase("y"))
        {
            Greenfoot.stop();
        }
        else if(answer.equalsIgnoreCase("n"))
        {
            Greenfoot.start();
        }
    }
    
}
