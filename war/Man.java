import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class man here.
 * 
 * @author (your name) 
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
    private GreenfootImage img,img1,img2,img3,img4;
    boolean attacking;
    /**
     * Act - do whatever the man wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Man()
    {
        img = new GreenfootImage("warrior.png");
        img1= new GreenfootImage("warrior-front-attack.png");
        img2= new GreenfootImage("warrior-right-attack.png");
        img3= new GreenfootImage("warrior-left-attack.png");
        img4= new GreenfootImage("warrior-back-attack.png");
        img.scale(60,60);
        //gif = new GifImage("skeleton-club.gif");
        //gif.resizeImages(60,60);
        timer=1;
        setImage(img);
        speed = 2;
        selected = false;   
        attacking=false;
    }
    public void act() 
    {
       
       boolean attackPressed= Greenfoot.isKeyDown("W") || Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("S") || Greenfoot.isKeyDown("D");
            if(Greenfoot.isKeyDown("up"))
            setLocation(getX(),getY()-speed);
            if(Greenfoot.isKeyDown("down"))
            setLocation(getX(),getY()+speed);
            if(Greenfoot.isKeyDown("right"))
            setLocation(getX()+speed,getY());
            if(Greenfoot.isKeyDown("left"))
            setLocation(getX()-speed,getY());
            if(attackPressed)
            {
                attacking=true;
                attack(timer);
            }
          
            if(isTouching(Castle.class))
            {
                setLocation(getX()-30,getY());
            }
        animationCounter++;
    }    
    
    
     public  void manSelected()
    {
        if(!selected)
        {
        selected = true;
        selected(this);
        }
        else
        {
            selected = false;
            selected(null);
        }
    }
    
    public void moveTo(int targetX,int targetY)
    {
        int x=getX(); int y=getY();
        int distX = targetX-x; int distY=targetY-y;
        int deltaX=distX/speed;
        int deltaY=distY/speed;
        if(getX()!=targetX || getY()!=targetY)
        {
            setLocation(x+deltaX,y+deltaY);
            
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
    
    public void setSelectedState(boolean s)
    {
        this.selected = s;
    }
    
    public void attack(int timer)
    {
           
           //timer++;
            if(Greenfoot.isKeyDown("w"))
            {   
               if(animationCounter%2==0)
               animateAttack();
                
            }
            
            else if(Greenfoot.isKeyDown("a"))
            {
                if(animationCounter%2==0)
               animateAttack();
            }
            
            else if(Greenfoot.isKeyDown("s"))
            {
                if(animationCounter%2==0)
                animateAttack();
                     
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
    
        public void attack() 
    {
    //add code here
    }
}
