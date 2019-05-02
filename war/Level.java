/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Level
{
    int damage;
    int speed;
    int health;
    
    
    IStrategy lv1;
    IStrategy lv2;
    IStrategy lv3;
    IStrategy lv4;
    IStrategy lv5;
    private int currentLevel;
    //LevelStrategy1 lv1;
    //LevelStrategy1 lv2;
    //LevelStrategy1 lv3;
    //LevelStrategy1 lv4;
    //LevelStrategy1 lv5;
    
    ArrayList<IStrategy> levels;
    
    public Level(){
        levels = new ArrayList<IStrategy>(5);
        addLevels();
        levels.add(lv1);
        levels.add(lv2);
        levels.add(lv3);
        levels.add(lv4);
        levels.add(lv5);
        System.out.println(levels.toString()); 
        currentLevel=0;//test
    }
    
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
    
    public void levelUp(){
        if(currentLevel<4)
        currentLevel++;
        
        else
        System.out.println("YOU WON");
        
        System.err.println("current level number :" +currentLevel);
    }
    
    public void addLevels(){
        lv1 = new LevelStrategy1();
        lv2 = new LevelStrategy2();
        lv3 = new LevelStrategy3();
        lv4 = new LevelStrategy4();
        lv5 = new LevelStrategy5();
        System.out.println(levels.toString()); //test
    }
    
    public void nextLevel(){
        //possible series of if statements to point to next level?
    }
    
    public void prevLevel(){
        //possible series of if statements to point to next level?
    }
    
    public void setNext(){
        
    }
    
    public void setPrev(){
        
    }
    
    public IStrategy getCurrent()
    {
        System.err.println("Level get current: "+ levels.get(currentLevel));
        System.err.println("current level number :" +currentLevel);
        return levels.get(currentLevel);
    }
    
}
