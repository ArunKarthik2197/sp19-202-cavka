import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Subject
{
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int health=20;
    private int damage;
    public void act() 
    {
        // Add your action code here.
        if(health<=0)
        die(this);
    }    
    
    public void causeDamage(ISubject s)
    {
       if(s.equals(Undead.class))
       {
           health=health-10;
           damage=10;
       }
       else if(s.equals(NightKing.class))
       {
           health=health-20;
           damage=20;
       }
       HealthSet(damage);
    }
    
    public void HealthSet(int val)
    {
        notifyObserver(this);
    }
    
    public int getHealth()
    {
        return damage;
    }
}
