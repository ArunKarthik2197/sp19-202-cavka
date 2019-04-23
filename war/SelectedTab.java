import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectedTab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class SelectedTab extends Actor
{
    private Actor selectedUnit;
    /**
     * Act - do whatever the SelectedTab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage init_img;
    public SelectedTab()
    {
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
        selectedUnit = a;
        display();
    }
    
    public void display()
    {
        if(selectedUnit!=null)
        setImage(selectedUnit.getImage());
        else
        setImage(init_img);
    }
    
    public Actor getSelectedUnit()
    {
        
        return selectedUnit;
        
    }
}
