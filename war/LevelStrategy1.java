/**
 * Write a description of class LevelStrategy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelStrategy1 implements ISubject
{
    int damage;
    
    public void notifyObserver(ISubject a){
        
    }
    
    public void addObserver(){
        
    }
    
    public void die(ISubject a){
        
    }
    
    public void causeDamage(ISubject a){
        
    }
    
    public void HealthSet(int val){
        
    }
    
    public int getHealth(){
        return 0;
    }
    
    public int getDamage(){
        return damage;
    }
    
    public void setDamage(int val){
        val = this.damage + 10;
    }
}
