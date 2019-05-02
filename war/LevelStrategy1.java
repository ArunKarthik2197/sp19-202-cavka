/**
 * Write a description of class LevelStrategy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelStrategy1 implements IStrategy
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
    
    public void setSpawnSpeed(int speed){
        this.speed = speed;
    }
    
    public void setDamage(int damage){
        this.damage = damage;
    }
    
    public void setHealth(int health){
        this.health = health;
    }
    
    public void addNewAttack(){
        
    }
    
    public void nextLevel(){
       
    }
    
    public void prevLevel(){
        //no prev level
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
