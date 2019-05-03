import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class NightKing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NightKing extends Subject 

{
    /**
     * Act - do whatever the NightKing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img;
    boolean selected;
    private int X;
    private int Y;
    private int time;
    private int spawnTimer;
    private int health=250;
    private int damage=20;

    private int range=250;
    private List<Man> man;
    private int throwTimer=120;
    private int time2=0;
    private boolean manKilled=false;
    private int healtTimer=100;
    private int time3=0;
    
    
    
    public NightKing()
    {
        img= new GreenfootImage("Night_king1.gif");
        img.scale(50,50);
        man= new ArrayList<Man>();
        setImage(img);
        selected = false;
        time=0;
        spawnTimer=300;// for 5 seconds
    }


     public void act()
    {
        time++;
        time3++;
        X=getX();
        Y=getY();
        checkRange();
        int r= random(100);
        if(time3%100 == 0 || health<=40)
        heal();
        if(time%spawnTimer == 0)
        {
            if(r%2==0)

            getWorld().addObject((Undead)pf.SpawnPlayer("UnDead"), X+random(50), Y);
            else
            getWorld().addObject((Undead)pf.SpawnPlayer("UnDead"),X-random(50),Y);
        }

    }
    
    public void attack()
    {
        
    }
   
    

    public int random(int limit)
    {
        return Greenfoot.getRandomNumber(limit);
    }

    public void HealthSet(int val)
    {

    }

    public int getHealth()
    {
        return health;
    }

    public void causeDamage(ISubject a)
    {

        if(a instanceof Man)
        {
            health=health-a.getDamage();
            super.notifyObserver(this);
        }
    }


    public int getDamage()

    {
        return damage;
    }

    public void setDamage(int val)
    {
        this.damage=val;
    }
    
    private void setAttributes(){
        currentLevel.getDamage(this);
        currentLevel.getSpearSpawnTime();
        currentLevel.getUndeadSpawnTime();
    }

    public void checkRange()
    {
         man =getObjectsInRange(250, Man.class);
         if(!man.isEmpty())
         throwSpear(man.get(0));
         else
         {
         time2=0;
         return;
        }
    }

    public void throwSpear(Man man)
    {
        time2++;
        if(time2%throwTimer==0 || time2==0)
        getWorld().addObject(new Spear(man), X+15, Y);

    }
    
  public boolean isKilledByMan()
    {
        return manKilled;
    }
    public void attack(ISubject s) 
    {
    //add code here
    }
    
    public void heal()
    {
        if(health<=240)
        health=health+10;
        else if(health<250)
        {
            int diff = 250-health;
            health=health+diff;
        }
        super.notifyObserver(this);
    }
}
   
