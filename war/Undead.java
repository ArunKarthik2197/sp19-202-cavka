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
    private boolean selected;
    private MouseInfo m;
    private int speed;
    GifImage gif;
    private GreenfootImage img;
    List<Castle> c;
    private Man man;
    private int health;
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
        setImage(img);
        speed = 2;
        selected = false;  
        man= (Man)MyWorld.getMyWorld().getMan();
    }
    public void addedToWorld(World world)
    {
        act();
    }
    public void act() 
    {
        setLocation(getX(),getY()+speed);
        if(isTouching(Man.class) && (man).attacking)
        {
            damaged(man);
        }
        if(health<=0)
        die();
       
    }    
    
    
     public  void manSelected()
    {
        if(!selected)
        {
        selected = true;
        selected(this);
        }
        else
        {
            selected = false;
            selected(null);
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
    
    public void setSelectedState(boolean s)
    {
        this.selected = s;
    }
    
    public int damaged(Actor a)
    {
        if(a.equals(man))
        {
            health=health-10;
        }
        return health;
    }
    
    public void die()
    {
        getWorld().removeObject(this);
    }
    
        public void attack() 
    {
    //add code here
    }
}
