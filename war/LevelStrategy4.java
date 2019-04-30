/**
 * Write a description of class LevelStrategy4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelStrategy4 extends Level
{
    int damage;
    int speed;
    int health;
    
    public void setSpawnSpeed(int val){
        this.speed = val;
    }
    
    public void setDamage(int val){
        this.damage = val + 40;
    }
    
    public void setHealth(int val){
        this.health = val;
    }
    
    public void addNewAttack(){
        
    }
}
