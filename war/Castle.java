import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Castle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Castle extends Subject
{
    /**
     * Act - do whatever the Castle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean selected;
    private Man m;
    private int damage;
    
    Castle()
    {
        selected= false;
        m = new Man();
        damage=1;
    }
    public void act() 
    {
        
    }
    
    
    
    public void causeDamage(ISubject s)
    {
        //nothing
    }
    
    public void HealthSet(int val)
    {
        
    }
    
    public int getHealth()
    {
        return 0;
    }
    
       public int getDamage()
    {
        return damage;
    }
    
    public void setDamage(int val)
    {
        this.damage=val;
    }
    
    public boolean isKilledByMan()
    {
        return false;
    }
}
