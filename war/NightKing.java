import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NightKing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NightKing extends Subject
{
    /**
     * Act - do whatever the NightKing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img;
    boolean selected;
    private int X;
    private int Y;
    private int time;
    private int spawnTimer;
    private int health=250;
    public NightKing()
    {
        img= new GreenfootImage("Night_king1.gif");
        img.scale(50,50);
        setImage(img);
        selected = false;
        spawnTimer=0;
        time=300;// for 5 seconds
    }
    
     public void act() 
    {
        spawnTimer++;
        X=getX();
        Y=getY();
        int r= random(100);
        if(spawnTimer%time == 0)
        {
            if(r%2==0)
            getWorld().addObject(new Undead(), X+random(50), Y);
            else
            getWorld().addObject(new Undead(),X-random(50),Y);
        }
        
    }
    
   
    
   public void causeDamage(Subject s)
    {
        //nothing
    }
    
    public int random(int limit)
    {
        return Greenfoot.getRandomNumber(limit);
    }
    
    public void HealthSet(int val)
    {
        
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void causeDamage(ISubject a)
    {
        
    }
}
