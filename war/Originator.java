
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Originator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Originator  
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Originator
     */
    public Originator()
    {
 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
   private IGameState state;

   public void setState(IGameState state){
      Greenfoot.setWorld((World)state);
   }

   public IGameState getState(){
  
      return state;
   }

   public Memento saveMemento(IGameState state){
      return new Memento(state);
   }

   public IGameState restoreMemento(Memento memento){
      state = memento.getState();
      return state;
   }
}
