import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MyWorld extends World implements IGameState
{
    static SelectedTab selectedTab;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    static MyWorld world;
    List<Subject> all;
    static List<Wall> wall;
    static Level lv;
    //static Man man;
   // static NightKing nightKing;
    public PlayerCreator players = new PlayerCreator();
    private static Instruction levelViewer;
    private static Instruction killCounter;
    private static Man man;
    private static NightKing nightKing;
   
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        
       
        
        

        world = this;
        all= new ArrayList<Subject>();
        wall = new ArrayList<Wall>();
        
        Level.resetInstance();
        
        lv= Level.getInstance();
        lv.reset();
        prepare();

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
        levelViewer =new Instruction();
        addObject(levelViewer,600,50);
        console.debugStatement("Level is set to :"+lv.getCurrent().getClass().getName());
        levelViewer.setValue(lv.getCurrent());
        
        selectedTab = new SelectedTab();
        addObject(selectedTab,93,125);

        Castle castle = new Castle();
        addObject(castle,500,760);
        

        nightKing = new NightKing();
        addObject(nightKing,468,43);
        
        //addObject(console,650,140);

        man = new Man();
        addObject(man,421,572);
        levelViewer =new Instruction();
        addObject(levelViewer,600,50);
        
        killCounter =new Instruction();
        addObject(killCounter,100,50);
        killCounter.setValue(0);
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
        Default.sm.changeState(States.PAUSE);

    }

    public void animate()
    {

    }
    
    public static Instruction getLevelCounter()
    {
        return levelViewer;
    }
    
    public static Instruction getKillCounter()
    {
        return killCounter;
    }
}
