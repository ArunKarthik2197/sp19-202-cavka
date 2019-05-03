import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spear here.
 * 
 * @author M.A.P.Karthik.
 * @version (a version number or a date)
 */
public class Arrow extends Subject 
{
    /**
     * Act - do whatever the Spear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Actor target;
    private int X;
    private int Y;
    private int aliveTimer=0;
    private int aliveTime=150;
    private int speed=3;
    private ISubject m;
    private int damage;
    private GreenfootImage img;
    public Arrow(Actor target)
    {
        this.target=target;
        damage=5;
        img = new GreenfootImage("arrow-1.png");
        img.scale(10, 30);
        setImage(img);
        
    }
    
    public void addedToWorld(World world)
    {
        X=target.getX();
        Y=target.getY();
        //turnTowards(X,Y);
        //act();
    }
    public void act() 
    {
        if(X<getX())
        setLocation(getX()-speed,getY()-speed);
        else if(X>getX())
        setLocation(getX()+speed,getY()-speed);
        else
        setLocation(getX(),getY()-speed);
        //
        checkTouching();
    }    
    
    public void checkTouching()
    {
       aliveTimer++;
       m=(Undead)getOneIntersectingObject(Undead.class);
       if(m!=null)
       {
       m.causeDamage(this); 
       die(this);
       }
       else if(aliveTimer % aliveTime == 0)
       {
       die(this);
       return;
       }
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
        //Nothing
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
