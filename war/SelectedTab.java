import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectedTab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class SelectedTab extends Actor
{
    private static Actor selectedUnit;
    private Actor minion;
    /**
     * Act - do whatever the SelectedTab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage init_img;
    static MyWorld world;
    public SelectedTab()
    {
        world = MyWorld.getMyWorld();
        init_img = getImage();
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            if(Greenfoot.mouseClicked(this) && selectedUnit!=null)
            {
           getWorld().addObject(new Man(),selectedUnit.getX()+30,selectedUnit.getY());
        }
        else
        {
            
        }
        }
    }    
    
    public void setSelected(Actor a)
    {
        world.setSelection();
        selectedUnit = a;
        display();
    }
    
    public void display()
    {
        if(selectedUnit==null)
        setImage(init_img);
        else
        setImage(selectedUnit.getImage());
    }
    
    public Actor getSelectedUnit()
    {
        
        return selectedUnit;
        
    }
    
    
}
