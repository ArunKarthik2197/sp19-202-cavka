import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class man here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Undead extends Subject
{

    private int speed;
    GifImage gif;
    private GreenfootImage img;
    ISubject subj;
    private Man man;
    private int health;
    private int damage;
    private List<Wall> walls;
    private boolean attacking;
    private boolean manKilled;
    /**
     * Act - do whatever the man wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Undead()
    {
        img = new GreenfootImage("skeleton-club.gif");
        img.scale(60,60);
        gif = new GifImage("skeleton-club.gif");
        gif.resizeImages(60,60);
        health=10;
        attacking=false;
        setImage(img);
        speed = 2;
        walls= new ArrayList<Wall>();
        damage=1;
        manKilled=false;

    }

    public void addedToWorld(World world)
    {
        man=MyWorld.getMan();

        act();
    }

    public void act() 
    {
        setImage(gif.getCurrentImage());
        int r= random(100);
        if(r%2==0)
            setLocation(getX()+random(20),getY()+speed);
        else
            setLocation(getX()-random(20),getY()+speed);
        checkTouching();
        if(health<=0)
            die(this);

    }    

    public void moveTo(int targetX,int targetY)
    {
        int x=getX(); int y=getY();
        int distX = targetX-x; int distY=targetY-y;
        int deltaX=distX/speed;
        int deltaY=distY/speed;
        if(getX()!=targetX || getY()!=targetY)
        {
            move(speed);

        }
    }

    public GreenfootImage scale(GreenfootImage image)
    {
        int scalePercent = 50;
        int width = image.getWidth()*scalePercent/100;
        int height = image.getHeight()*scalePercent/100;
        image.scale(width,height);

        return image;

    }

    public void causeDamage(Subject s)
    {
        //nothing
    }

    public int damaged(Actor a)
    {
        if(a.equals(man))
        {
            manKilled=true;
            health=health-10;
        }
        return health;
    }

    public int random(int limit)
    {
        return Greenfoot.getRandomNumber(limit);
    }

    public void attack(ISubject m)
    {

        m.causeDamage(this);
    }

    public void checkTouching()
    {
        if(isTouching(Man.class) )
        {
            setLocation(man.getX(),getY()-speed);

            if(man.attacking)
                health=damaged(man);
            else
                attack(man);

        }
        else if(isTouching(Wall.class))
        {
            setLocation(getX(),getY()-speed);
            attacking=true;
            walls=getObjectsInRange(100, Wall.class);

            for(int i=0;i<walls.size();i++)
            {
                attack(walls.get(i));
            }
        }
        else 
        {
            attacking=false;
        }
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

    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int val)
    {
        this.damage=val;
    }
    
    public boolean isKilledByMan()
    {
        return manKilled;
    }
}
