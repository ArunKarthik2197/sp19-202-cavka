import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class man here.
 * 
 * @author M.A.P.Karthik
 * @version (a version number or a date)
 */
public class Man extends Subject implements IPlayerFactory
{
    private boolean selected;
    private MouseInfo m;
    private int speed;
    GifImage gif;
    private int timer;
    private int animationCounter=0;
    private GreenfootImage img,imgW,imgA,imgS,imgD;
    boolean attacking;
    private int health;
    private int damage;
    /**
     * Act - do whatever the man wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Man()
    {
        img = new GreenfootImage("warrior.png");
        imgW= new GreenfootImage("warrior-front-attack.png");
        imgD= new GreenfootImage("warrior-right-attack.png");
        imgA= new GreenfootImage("warrior-left-attack.png");
        imgS= new GreenfootImage("warrior-back-attack.png");
        img.scale(60,60);
        //gif = new GifImage("skeleton-club.gif");
        //gif.resizeImages(60,60);
        health=200;
        damage=10;
        timer=1;
        setImage(img);
        speed = 2;
        selected = false;   
        attacking=false;
    }
    public void act() 
    {
       
       boolean attackPressed= Greenfoot.isKeyDown("W") || Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("S") || Greenfoot.isKeyDown("D");
            movement();
            
            if(attackPressed)
            {
                attacking=true;
                attack(timer);
                endAnimation();
            }
          
            if(isTouching(Castle.class))
            {
                setLocation(getX()-30,getY());
            }
            
            if(health<=0)
            die(this);
        animationCounter++;
    }    
    
    
 
    
    public void movement()
    {
            if(Greenfoot.isKeyDown("up") )
                setLocation(getX(),getY()-speed) ;
            if(Greenfoot.isKeyDown("down") && !touchingWall())
                setLocation(getX(),getY()+speed);
            if(Greenfoot.isKeyDown("right") )
                setLocation(getX()+speed,getY());
            if(Greenfoot.isKeyDown("left"))
                setLocation(getX()-speed,getY());
    }
    public GreenfootImage scale(GreenfootImage image)
    {
        int scalePercent = 50;
        int width = image.getWidth()*scalePercent/100;
        int height = image.getHeight()*scalePercent/100;
        image.scale(width,height);
        
        return image;
        
    }
    
    
    
    public void attack(int timer)
    {
           
         
            if(Greenfoot.isKeyDown("w"))
            {   
               if(animationCounter%2==0)
               animateAttack(imgW);
               
               endAnimation();
            }
            
            else if(Greenfoot.isKeyDown("a"))
            {
                if(animationCounter%2==0)
               animateAttack(imgA);
            }
            
            else if(Greenfoot.isKeyDown("s"))
            {
                if(animationCounter%2==0)
                animateAttack(imgS);
                     
            }
            
            else if(Greenfoot.isKeyDown("d"))
            {   
               if(animationCounter%2==0)
               animateAttack();
                      
            }
            else if(timer>1)
            {
               if(animationCounter%4==0)
               animateAttack();
            } 
    }
    
    public void animateAttack()
    {
        if(timer == 1)
        setImage(img1);
        
        else if(timer==2)
        setImage(img2);
        
        else if(timer==3)
        setImage(img3);
        
        else if(timer==4)
        endAnimation();
        
               animateAttack(imgD);
                      
            
            
    }
    
    public void animateAttack(GreenfootImage dir)
    {
        if(timer == 1)
        setImage(dir);
        else if(timer==2)
        setImage(imgD);
        else if(timer ==3)
        setImage(imgA);
       
        timer++;
        
    }
    
    private void endAnimation()
    {
        if(timer>=4)
        {
        timer=1;
        setImage(img);
        attacking=false;
        }
    }
    
    public boolean touchingWall()
    {
        boolean touching=false;
        if(isTouching(Wall.class))
        {
            touching=true;
        }
        return touching;
    }
    
    public void causeDamage(ISubject a)
    {
        System.out.println("In man cause damage  : "+a);
        if(a instanceof Undead )
        
        health=health-a.getDamage();
        
        else if(a instanceof NightKing)
        health=health-20;
        
        
        
        HealthSet(health);
    }
    
    public void HealthSet(int val)
    {
       super.notifyObserver(this);
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
    
    public void attack() 
    {
    //add code here
    }
    
}
