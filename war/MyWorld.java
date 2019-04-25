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
    Man man;
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

        man = new Man();
        addObject(man,401,680);
        man.setLocation(403,563);
        Wall wall = new Wall();
        addObject(wall,226,761);
        Wall wall2 = new Wall();
        addObject(wall2,224,689);
        Wall wall3 = new Wall();
        addObject(wall3,292,687);
        Wall wall4 = new Wall();
        addObject(wall4,359,686);
        Wall wall5 = new Wall();
        addObject(wall5,430,686);
        Wall wall6 = new Wall();
        addObject(wall6,503,685);
        Wall wall7 = new Wall();
        addObject(wall7,572,685);
        Wall wall8 = new Wall();
        addObject(wall8,639,684);
        Wall wall9 = new Wall();
        addObject(wall9,641,753);
        wall.setLocation(157,685);
        wall9.setLocation(721,695);
        selectedTab.setLocation(117,355);
        selectedTab.setLocation(4,8);
        selectedTab.setLocation(13,19);
        Wall wall10 = new Wall();
        addObject(wall10,786,684);
        Wall wall11 = new Wall();
        addObject(wall11,859,683);
        Wall wall12 = new Wall();
        addObject(wall12,931,685);
        Wall wall13 = new Wall();
        addObject(wall13,961,760);
        Wall wall14 = new Wall();
        addObject(wall14,78,692);
        Wall wall15 = new Wall();
        addObject(wall15,35,764);
        wall9.setLocation(694,679);
        wall14.setLocation(72,693);
        wall15.setLocation(50,743);
        wall15.setLocation(63,754);
        wall14.setLocation(76,690);
        wall15.setLocation(62,760);
        wall9.setLocation(718,680);
        wall14.setLocation(103,670);
        wall14.setLocation(98,684);
        wall14.setLocation(93,684);
        man.setLocation(421,572);
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
    
    public Man getMan()
    {
        return man;
    }
    
}
