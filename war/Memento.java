import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Memento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Memento
{
 
   private IGameState state;

   public Memento(IGameState state){
      this.state = state;
   }

   public IGameState getState(){
      return state;
   }	
}

