/**
 * Write a description of class LevelStrategy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelStrategy1  implements IStrategy
{
    int nightKingDamage;
    int unDeaddamage;
    int spearDamage;
    int undeadSpawnTime;
    int spearSpawnTime;
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
