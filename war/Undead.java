import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class man here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Undead extends Subject implements IPlayerFactory
{
   
    
    private int speed;
    GifImage gif;
    private GreenfootImage img;
    ISubject subj;
    private static Man man;
    private int health;
    private int damage;
    private List<Wall> walls;
    private boolean attacking;
    private boolean manKilled;
   // private boolean reachedWall;
    /**
     * Act - do whatever the man wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Undead()
    {
        img = new GreenfootImage("skeleton-club.gif");
        img.scale(60,60);
        gif = new GifImage("skeleton-club.gif");
        gif.resizeImages(60,60);
        health=10;
        attacking=false;
        setImage(img);
        speed = 2;
        //walls= new ArrayList<Wall>();
        damage=1;
        manKilled=false;
       // reachedWall=false;
        
    }
    public void addedToWorld(World world)
    {
       man=MyWorld.getMan();
       
        act();
    }
    public void act() 
    {
        setImage(gif.getCurrentImage());
        if(health<=0)
        die(this);
        else
        {
        
        if(walls!=null ){
        if(walls.size()>0)reachedWallMovement();
        }
        else
        {
        int r= random(100);
        
        if(r%2==0)
        setLocation(getX()+random(20),getY()+speed);
        else
        setLocation(getX()-random(20),getY()+speed);
        checkTouching();
        
        }
    }
       
    }    
    
    
     
    
    public void moveTo(int targetX,int targetY)
    {
        int x=getX(); int y=getY();
        int distX = targetX-x; int distY=targetY-y;
        int deltaX=distX/speed;
        int deltaY=distY/speed;
        if(getX()!=targetX || getY()!=targetY)
        {
            move(speed);
            
        }
    }
    public GreenfootImage scale(GreenfootImage image)
    {
        int scalePercent = 50;
        int width = image.getWidth()*scalePercent/100;
        int height = image.getHeight()*scalePercent/100;
        image.scale(width,height);
        
        return image;
        
    }
    
    public void causeDamage(ISubject s)
    {
       if(s instanceof Man)
       {
           health=health-10;
       }
       else if(s instanceof Arrow )
       {
           health=health-s.getDamage();
       }
    }
    
    public int damaged(Actor a)
    {
        if(a.equals(man))
        {
            manKilled=true;
            health=health-10;
        }
        return health;
    }
    
    
    
    public int random(int limit)
    {
        return Greenfoot.getRandomNumber(limit);
    }
    
    public void attack(ISubject m)
    {
        
        m.causeDamage(this);
    }
    
    
    
    public void checkTouching()
    {
        if(isTouching(Man.class) )
        {
            setLocation(man.getX(),getY()-speed);
            
            if(!man.attacking)
            attack(man);
            
        }
        else if(isTouching(Wall.class))
        {
             //reachedWall=true;
             
             attacking=true;

             walls=getObjectsInRange(75, Wall.class);

             System.err.println("\t Walls Found:"+walls.size());
             reachedWallMovement();
             
             
        }
        else 
        {
            attacking=false;
        }
    }
    
    public void HealthSet(int val)
    {
        
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setAttributes(){
        damage = damage + currentLevel.getDamage(this);
        speed = speed + currentLevel.getSpeed(this);
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
        return manKilled;
    }
    
    boolean moveUp=true;
    
    public void reachedWallMovement()
    {
        
        attack(walls.get(0));
        setLocation(getX(),getY()+(15*(moveUp?-1:1)));
        moveUp=!moveUp;
    }

}

