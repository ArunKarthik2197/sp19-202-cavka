/**
 * Write a description of class ISubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ISubject  
{
    // instance variables - replace the example below with your own
  public void notifyObserver(ISubject a);
    
    
    public void addObserver();
   
    
    public void die(ISubject s);
    
    
    
    
    public  void causeDamage(ISubject a);
    
    public  void HealthSet(int val);
    
    public  int getHealth();
    
    public int getDamage();
    
    public void setDamage(int val);
    
    public boolean isKilledByMan();
}
