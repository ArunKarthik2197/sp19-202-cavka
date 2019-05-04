import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Castle here.
 * 
 * @author M.A.P.Karthik 
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
    private int time=0;
    private int arrowFireTimer=50;
    int X;
    int Y;
    private List<Undead> undeadInRange;
    Castle()
    {
        selected= false;
        m = new Man();
        damage=1;
    }
    
    public void addedToWorld(World world)
    {
        X=getX();
        Y=getY();
        
    }

    public void act() 
    {
        checkInRange();
    }
    
    public void checkInRange()
    {
        undeadInRange=getObjectsInRange(500, Undead.class);
        for(int i=0;i<undeadInRange.size();i++)
        {
            attack(undeadInRange.get(i));
        }
    }
    
    public void causeDamage(ISubject s)
    {
        //nothing
    }
    
    public void attack(Actor s)
    {
        if(!(currentLevel instanceof LevelStrategy1))
        fireArrow(s);
    }
    
    public void fireArrow(Actor target)
    {
        time++;
        if(time%arrowFireTimer==0 || time == 1 )
        getWorld().addObject(new Arrow(target),X,Y);
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
