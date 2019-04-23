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
    public NightKing()
    {
        img= new GreenfootImage("Night_king1.gif");
        img.scale(50,50);
        setImage(img);
        selected = false;
        
    }
    
     public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        castleSelected();
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
}