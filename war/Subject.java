import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Subject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  abstract class Subject extends Actor
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
        // Add your action code here.
    }    
    public void selected(Actor a)
    {
        notifyObserver(a);
    }
    public void notifyObserver(Actor a)
    {
        selectedTab.setSelected(a);
    }
    
    public void addObserver()
    {
        selectedTab = MyWorld.getSelectedTab();
    }
    
    public abstract void setSelectedState(boolean s);
}

