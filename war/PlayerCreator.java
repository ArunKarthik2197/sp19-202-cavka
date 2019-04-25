import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerCreator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerCreator extends Actor
{
    /**
     * Act - do whatever the PlayerCreator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public IPlayerFactory SpawnPlayer(String name)
    {
       switch(name) 
        { 
            case "Man": 
                return new Man(); 
              // break; 
            case "NightKing": 
                return new NightKing(); 
               // break; 
            case "UnDead": 
               return new Undead(); 
               // break; 
            //case "Dragon" :
            //    return new Dragon();
                
             default : break;
           
        } 
        
        return null;
    }
}
