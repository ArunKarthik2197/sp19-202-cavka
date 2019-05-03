/**
 * Write a description of class HealthVisitor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthVisitor implements IVisitor
{
    // instance variables - replace the example below with your own
    private static int  health=200;
    private int damage;
    ISubject sub;
    HealthVisitor(ISubject s)
    {
        sub = s;
    }

    public int visit(ISubject s)
    {
       
       if(sub instanceof Undead)
       {
           damage=sub.getDamage();
           health=health-damage;
           
        }
        else if(sub instanceof NightKing)
       {
           damage=sub.getDamage();
           health=health-damage-10;
            
        }
       
       return health;
    }
}
