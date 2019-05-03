import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Subject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Subject extends Actor implements ISubject
{
    /**
     * Act - do whatever the Subject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static World world;
    SelectedTab selectedTab;
    private int kills=0;
    private int damageSet = 0;
    protected PlayerCreator pf;
    Subject()
    {
        world= MyWorld.getMyWorld();
        addObserver();

        pf= new PlayerCreator();
    }
    
    public void act() 
    {

    }    

    public void notifyObserver(ISubject a)
    {
        System.out.println("In subject cause damage  : "+a);
        if(a instanceof Man)
        {
            selectedTab.setJonHealth(a.getHealth());
        }
        else if(a instanceof Wall)
        {
            selectedTab.setWallHealth(a.getHealth());
        }
        else if(a instanceof NightKing)
        {
            selectedTab.setNKHealth(a.getHealth());
        }
        
    }
    public void addObserver()
    {
        selectedTab = MyWorld.getSelectedTab();
    }

    public void die(ISubject s)
    {
        if(s instanceof Undead)

        {
        
        getWorld().removeObject((Subject)s);
        }
        else if(s instanceof Man)
        {
            Default.sm.changeState(States.GAME_OVER);
            getWorld().removeObject((Subject)s);
        }

        else if(s instanceof Wall)

        {
            getWorld().removeObject((Subject)s);
            Default.sm.changeState(States.GAME_OVER);
        }
        else
        getWorld().removeObject((Subject)s);
    }
    public abstract boolean isKilledByMan();

    
    public abstract void causeDamage(ISubject a);

    public abstract void HealthSet(int val);

    public abstract int getHealth();

    public abstract int getDamage();

    public abstract void setDamage(int val);
}

