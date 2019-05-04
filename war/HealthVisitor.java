/**
 * Write a description of class HealthVisitor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthVisitor implements IVisitor
{
    // instance variables - replace the example below with your own
    private int  health;
    private int damage;
    ISubject sub;
    HealthVisitor(ISubject s)
    {
        sub = s;
        health=sub.getHealth();
    }

    public int visit(ISubject s)
    {
       
       if(s instanceof Undead)
       {
           damage=s.getDamage();
           health=health-damage;
           
        }
        else if(s instanceof NightKing)
       {
           damage=s.getDamage();
           health=health-damage-10;
            
        }
       
       return health;
    }
}
