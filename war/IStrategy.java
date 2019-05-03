/**
 * Write a description of class IStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IStrategy  
{
    
    int getDamage(ISubject s);
    int getUndeadSpawnTime();
    int getSpearSpawnTime();
    int getSpeed(ISubject s);
    void getStrategy();
    
}
