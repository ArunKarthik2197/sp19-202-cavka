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
       // s = sub;
       System.out.println("Health Visitor visit method begin , health : "+health);
       if(sub instanceof Undead)
       {
           damage=sub.getDamage();
           health=health-damage;
           System.out.println("Health Visitor wall health for undead: "+health);
        }
        else if(sub instanceof NightKing)
       {
           damage=sub.getDamage();
           health=health-damage-20;
            System.out.println("Health Visitor wall health for nk: "+health);
        }
       System.out.println("Health Visitor visit method end , health : "+health);
       return health;
    }
}
