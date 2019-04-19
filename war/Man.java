import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class man here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Man extends Subject
{
    private boolean selected;
    private MouseInfo m;
    private int speed;
    /**
     * Act - do whatever the man wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Man()
    {
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
                int targetX = m.getX();
                int targetY = m.getY();
                moveTo(targetX,targetY);
            }
        }
        else
        {
            
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
}
