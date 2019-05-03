/**
 * Write a description of class LevelStrategy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelStrategy2  implements IStrategy
{
    int nightKingDamage = 20;
    int unDeaddamage = 2;
    int spearDamage = 15;
    int undeadSpawnTime = 200;
    int spearSpawnTime = 60;
    int speed=2;
    int health;
    int holder=10;

   public int getDamage(ISubject sub)
   {
       if(sub instanceof Undead)
       {
           System.err.println("undeadDamage: " + unDeaddamage);
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
