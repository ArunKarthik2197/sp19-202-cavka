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
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        world = this;
        all= new ArrayList<Subject>();
        prepare();
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        selectedTab = new SelectedTab();
        addObject(selectedTab,853,692);
        selectedTab.setLocation(945,742);
        
        Castle castle = new Castle();
        addObject(castle,37,749);
        castle.setLocation(456,760);
        
        NightKing nightKing = new NightKing();
        addObject(nightKing,505,143);
        nightKing.setLocation(468,43);
    }
    
    public static SelectedTab getSelectedTab()
    {
        return selectedTab;
    }
    
    public  void setSelection()
    {
        all=getObjects(Subject.class);
        for( Subject obj: all)
        {
            if(obj.equals(selectedTab.getSelectedUnit()))
            {
                obj.setSelectedState(true);
            }
            else
            {
                obj.setSelectedState(false);
            }
        }
    }
    
    public static MyWorld getMyWorld()
    {
        return world;
    }
    
    
}
