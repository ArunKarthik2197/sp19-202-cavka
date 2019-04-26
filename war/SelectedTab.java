import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class SelectedTab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class SelectedTab extends Actor
{
    private static Actor selectedUnit;
    private Actor minion;
    /**
     * Act - do whatever the SelectedTab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage init_img;
    static MyWorld world;
    Bar jonHealth;
    Bar wallHealth;
    Bar nightKingHealth;
    Man man;
    NightKing nk;
    List<Wall> walls;
    public SelectedTab()
    {
        world = MyWorld.getMyWorld();
        init_img = getImage();
         jonHealth= new Bar("Jon","man",100,100);
        wallHealth= new Bar("Wall","Wall",200,200);
        nightKingHealth= new Bar("Night King","Nk",250,250);
        jonHealth.setBreakPercent(20);
        nightKingHealth.setBreakPercent(20);
        nightKingHealth.setBreakLow(false);
        wallHealth.setBreakPercent(20);
        walls = new ArrayList<Wall>();
        
    }
    
    public void addedToWorld(World world)
    {
        int x = this.getX();  int y=this.getY();
        this.world.addObject(jonHealth,x,y);
        this.world.addObject(wallHealth,x,y+20);
        this.world.addObject(nightKingHealth,x,y+40);
        man=MyWorld.getMan();
        nk = this.world.getNK();
        walls=getWorld().getObjects(Wall.class);
        System.out.println(man);
        
    }
    
    public void act() 
    {
        
    }    
    
   
    
    
    
    public Actor getSelectedUnit()
    {
        
        return selectedUnit;
        
    }
    
    public void setValue(ISubject s)
    {
        if(s.equals(man))
        jonHealth.subtract(10);
        if(s.equals(walls.get(0)))
        wallHealth.subtract(s.getHealth());
        if(s.equals(nk))
        nightKingHealth.setValue(s.getHealth());
    }
    
    
    
    
    
    
}
