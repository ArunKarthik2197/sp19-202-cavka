/**
 * Write a description of class LevelStrategy3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelStrategy3 extends Level
{
    int damage;
    int speed;
    int health;
    
    public void setSpawnSpeed(int val){
        this.speed = val;
    }
    
    public void setDamage(int val){
        this.damage = val + 30;
    }
    
    public void setHealth(int val){
        this.health = val;
    }
    
    public void addNewAttack(){
        
    }
    
    public void nextLevel(){
        lv = new LevelStrategy4();
    }
    
    public void prevLevel(){
        lv = new LevelStrategy2();
    }
    
    public void setNext(){
        
    }
    
    public void setPrev(){
        
    }
}
