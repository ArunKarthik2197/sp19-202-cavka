import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Subject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  abstract class Subject extends Actor implements ISubject
{
    /**
     * Act - do whatever the Subject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static World world;
    SelectedTab selectedTab;
    
    Subject()
    {
        world= MyWorld.getMyWorld();
        addObserver();
       
        
    }
    public void act() 
    {
       
    }    
    
    public void notifyObserver(ISubject a)
    {
        
        selectedTab.setValue(a);
        
    }
    
    public void addObserver()
    {
        selectedTab = MyWorld.getSelectedTab();
    }
    
    public void die(ISubject s)
    {
        getWorld().removeObject((Subject)s);
    }
    
    
    
    public abstract void causeDamage(ISubject a);
    
    public abstract void HealthSet(int val);
    
    public abstract int getHealth();
}

