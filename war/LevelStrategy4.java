/**
 * Write a description of class LevelStrategy4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelStrategy4 implements IStrategy
{
    int nightKingDamage;
    int unDeaddamage = 6;
    int spearDamage = 25;
    int undeadSpawnTime = 60;
    int spearSpawnTime = 50;
    int speed=2;
    int health;
    int holder=10;

   public int getDamage(ISubject sub)
   {
       if(sub instanceof Undead)
       {
           return unDeaddamage;
       }
       else if(sub instanceof NightKing)
       {
           return nightKingDamage;
       }
       else if(sub instanceof Spear)
       {
           return spearDamage;
       }
       else
       return holder;
   }
   
   public int getSpearSpawnTime()
   {
       return spearSpawnTime;
   }
   
   public int getUndeadSpawnTime()
   {
       return undeadSpawnTime;
   }
   
   public void getStrategy()
   {
       
   }
   
   public int getSpeed(ISubject sub)
   {
       return speed;
   }
}
