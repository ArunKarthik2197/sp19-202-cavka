/**
 * Write a description of class LevelStrategy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelStrategy2 extends Level implements IStrategy
{
    int damage;
    int speed;
    int health;
    
    public void setSpawnSpeed(int val){
        this.speed = val;
    }
    
    public void setDamage(int val){
        this.damage = val + 20;
    }
    
    public void setHealth(int val){
        this.health = val;
    }
    
    public void addNewAttack(){
        
    }
    
    public void nextLevel(){
        
    }
    
    public void prevLevel(){
        
    }
}
