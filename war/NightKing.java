import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NightKing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NightKing extends Subject implements IPlayerFactory
{
    /**
     * Act - do whatever the NightKing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img;
    boolean selected;
    private int X;
    private int Y;
    private int spawnTimer;
    public NightKing()
    {
        img= new GreenfootImage("Night_king1.gif");
        img.scale(50,50);
        setImage(img);
        selected = false;
        spawnTimer=0;
    }
    
     public void act() 
    {
        spawnTimer++;
        X=getX();
        Y=getY();
        if(spawnTimer%300 == 0)
        getWorld().addObject((Actor)MyWorld.getMyWorld().players.SpawnPlayer("UnDead"), X+30, Y);
        
    }
    
    public void castleSelected()
    {
        if(!selected)
        {
        selected = true;
        selected(this);
        }
        else
        {
            selected = false;
        }
    }  
    
   public void setSelectedState(boolean s)
    {
        this.selected = s;
    }
    
    
    public void attack() 
    {
    //add code here
    }
  
}
