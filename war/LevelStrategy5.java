/**
 * Write a description of class LevelStrategy5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelStrategy5 extends Level
{
    int damage;
    int speed;
    int health;
    Level lv;
    
    public void setSpawnSpeed(int val){
        this.speed = val;
    }
    
    public void setDamage(int val){
        this.damage = val + 50;
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