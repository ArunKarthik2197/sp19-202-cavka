import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spear extends Subject 
{
    /**
     * Act - do whatever the Spear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Actor target;
    private int X;
    private int Y;
    private int speed=3;
    private Man m;
    private int damage;
    private GreenfootImage img;
    public Spear(Actor target)
    {
        this.target=target;
        damage=10;
        img = new GreenfootImage("ice-spear.png");
        img.scale(40,40);
        setImage(img);
        
    }
    
    public void addedToWorld(World world)
    {
        X=target.getX();
        Y=target.getY();
        turnTowards(X,Y);
        act();
    }
    public void act() 
    {
        if(target.getX()<getX())
        setLocation(getX()-speed,getY()+speed);
        else if(target.getX()>getX())
        setLocation(getX()+speed,getY()+speed);
        checkTouching();
    }    
    
    public void checkTouching()
    {
       m=(Man) getOneIntersectingObject(Man.class);
       if(m!=null)
       {
       m.causeDamage(this); 
       die(this);
       }
       else if(isTouching(Wall.class) || isAtEdge())
       die(this);
       else
       return;
       
       
       
    }
    
    public void attack(ISubject s)
    {
        
    }
    
     public void HealthSet(int val)
    {
        
    }
    
    public int getHealth()
    {
        return 1;
    }
    
    public void causeDamage(ISubject a)
    {
        if(a instanceof Man)
        {
        die(this);
        return;
        }
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
