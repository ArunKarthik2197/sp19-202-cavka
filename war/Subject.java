import greenfoot.*;

/**
 * Write a description of class Subject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Subject extends Actor implements ISubject, Visitable
{
    /**
     * Act - do whatever the Subject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static World world;
    SelectedTab selectedTab;

    private int k;
    protected PlayerCreator pf;
    protected static IStrategy currentLevel;
    private static Instruction levelCounter;
    private static Instruction killCounter;

    Subject()
    {
        world= MyWorld.getMyWorld();
        addObservers();

        pf= new PlayerCreator();

        if(currentLevel==null)
        currentLevel=MyWorld.lv.getCurrent();
        
        try{
            if(levelCounter==null)System.err.println("lc null");
            if(currentLevel==null)System.err.println("cl null");
            levelCounter.setValue(currentLevel);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }

    public void act()
    {

    }

    public void notifyObserver(ISubject a)
    {
        System.out.println("In subject cause damage  : "+a);
        if(a instanceof Man)
        {
            Man b= (Man)a;
            k = b.getKills();
            killCounter.setValue(k);
            
            
            
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
        
        
        levelCounter.setValue(currentLevel);
       // selectedTab.showLevel(lv);

    }
    public void addObservers()
    {
        selectedTab = MyWorld.getSelectedTab();
        levelCounter=MyWorld.getLevelCounter();
        
        killCounter = MyWorld.getKillCounter();
    }

    public void die(ISubject s)
    {
        if(s instanceof Undead)

        {
        
        
        getWorld().removeObject((Subject)s);
        }
        else if(s instanceof Man)
        {
            Default.sm.changeState(States.GAME_OVER_MAN);
            getWorld().removeObject((Subject)s);
        }

        else if(s instanceof Wall)

        {
            Default.sm.changeState(States.GAME_OVER_WALL);
            getWorld().removeObject((Subject)s);
        }
        else if(s instanceof NightKing)
        {
            //Greenfoot.playSound("victory_sound_slower.mp3");
            Default.sm.changeState(States.GAME_WON);
        }
        else
        getWorld().removeObject((Subject)s);
    }

    protected void levelUp()
    {
        
        
        MyWorld.lv.levelUp();
        currentLevel=MyWorld.lv.getCurrent();
        
        notifyObserver(this);
        
        
    }

    public int accept(HealthVisitor visitor,ISubject attacker )
     {     
         return visitor.visit(attacker);
     }
     
    public abstract boolean isKilledByMan();


    public abstract void causeDamage(ISubject a);

    public abstract void HealthSet(int val);

    public abstract int getHealth();

    public abstract int getDamage();

    public abstract void setDamage(int val);
}

