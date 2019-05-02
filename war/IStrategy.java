/**
 * Write a description of class IStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IStrategy  
{
    void setSpawnSpeed(int val);
    void setDamage(int val);
    void setHealth(int val);
    void addNewAttack();
    void nextLevel();
    void prevLevel();
    void setNext();
    void setPrev();
    
    int getUndeadDamage();
    int getUndeadSpeed();
    int getUndeadTime();
    
    int getSpearDamage();
    int getSpearSpeed();
    int getSpearTime();
}
