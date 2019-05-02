/**
 * Write a description of class LevelStrategy3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelStrategy3 implements IStrategy
{
    int damage;
    int speed;
    int health;
    
    int undeadDamage;
    int spearDamage;
    int undeadSpeed;
    int spearSpeed;
    int undeadSpawntime;
    int spearSpawntime;
    
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
       
    }
    
    public void prevLevel(){
        
    }
    
    public void setNext(){
        
    }
    
    public void setPrev(){
        
    }
    
    public int getUndeadDamage(){
        return undeadDamage;
    }
    public int getUndeadSpeed(){
        return undeadSpeed;
    }
    public int getUndeadTime(){
        return undeadSpawntime;
    }
    
    public int getSpearDamage(){
        return spearDamage;
    }
    public int getSpearSpeed(){
        return spearSpeed;
    }
    public int getSpearTime(){
        return spearSpawntime;
    }
}
