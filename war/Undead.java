import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class man here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Undead extends Subject
{
    private boolean selected;
    private MouseInfo m;
    private int speed;
    GifImage gif;
    private GreenfootImage img;
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
        
        setImage(img);
        speed = 2;
        selected = false;   
    }
    public void act() 
    {
        m = Greenfoot.getMouseInfo();
        if(Greenfoot.mouseClicked(this))
        {
            manSelected();
        }
        if(selected && m!=null )
        {
            
            if(m.getButton() == 3)
            {
                setImage(gif.getCurrentImage());
                int targetX = m.getX();
                int targetY = m.getY();
                
                moveTo(targetX,targetY);
            }
            if(isTouching(Man.class))
            {
                setLocation(getX()-30,getY());
            }
        }
        else 
        {
            setImage(img);
            if(Greenfoot.isKeyDown("up"))
            setLocation(getX(),getY()-speed);
            if(Greenfoot.isKeyDown("down"))
            setLocation(getX(),getY()+speed);
            if(Greenfoot.isKeyDown("right"))
            setLocation(getX()+speed,getY());
            if(Greenfoot.isKeyDown("left"))
            setLocation(getX()-speed,getY());
            if(isTouching(Castle.class))
            {
                setLocation(getX()-30,getY());
            }
        }
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
            setLocation(x+deltaX,y+deltaY);
            
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
}
