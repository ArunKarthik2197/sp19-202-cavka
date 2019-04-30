/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Level implements IStrategy
{
    int damage;
    int speed;
    int health;
    
    Level lv;
    IStrategy lv1;
    IStrategy lv2;
    IStrategy lv3;
    IStrategy lv4;
    IStrategy lv5;
    
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
    
    //fix this
    public void levelUp(Level l){
        this.lv = l;
    }
}
