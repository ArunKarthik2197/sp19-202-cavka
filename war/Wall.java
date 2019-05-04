import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Subject
{
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int health=3000;
    private int damage;
    private GreenfootImage img;
    HealthVisitor h;
    public void addedToWorld(World world)
    {
        img=getImage();
         h = new HealthVisitor(this);
        
    }
    public void act() 
    {
        // Add your action code here.
        
        if(health<=0)
        die(this);
    }    
    
    public void causeDamage(ISubject s)
    {
        
        System.out.println("wall health: "+health);  
       if(s instanceof Undead)
       {
           //damage=s.getDamage();
           health=accept(h,s);
           
           int aq=(int)(health/30);
           
           int transPercent=(int)((aq*255)/100);
           
          // System.err.println("wall calc transparency: "+transPercent);

          // System.err.println("wall transparency before : "+img.getTransparency());
           img.setTransparency(transPercent);
           //System.err.println("wall transparency after: "+img.getTransparency());

       }
       else if(s instanceof NightKing)
       {
           health=accept(h,s);
         //  health=health-damage;
           
       }
       HealthSet(health);
    }
    
    public void HealthSet(int val)
    {
        notifyObserver(this);
    }
    
    public int getHealth()
    {
        return health;
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
        return false;
    }
}
