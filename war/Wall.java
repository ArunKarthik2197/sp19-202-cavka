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
    private int health=200;
    private int damage;
    public void act() 
    {
<<<<<<< HEAD
        
=======
        // Add your action code here.
        if(health<=0)
        die(this);
>>>>>>> master
    }    
    
    public void causeDamage(ISubject s)
    {
       if(s instanceof Undead)
       {
           damage=s.getDamage();
           health=health-damage;
           
       }
       else if(s instanceof NightKing)
       {
           damage=s.getDamage();
           health=health-damage;
           
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
    
       public int getDamage()
    {
        return damage;
    }
    
    public void setDamage(int val)
    {
        this.damage=val;
    }
}
