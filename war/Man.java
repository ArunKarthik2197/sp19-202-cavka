import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class man here.
 * 
 * @author M.A.P.Karthik
 * @version (a version number or a date)
 */
public class Man extends Subject
{
    
    class ImageHolder{
        String fileName;
        GreenfootImage image;
        public ImageHolder(String filename){
            this.fileName=filename;
            this.image= new GreenfootImage(fileName);
        }
    }
    
    
    private MouseInfo m;
    private int speed;
    private GifImage gif;
    private int timer;
    private int animationCounter=0;
    //private GreenfootImage img,imgW,imgA,imgS,imgD;
    private ImageHolder img,imgW,imgA,imgS,imgD,imgR,imgB,imgL;
    boolean attacking;
    private int health;
    private int damage;
    private boolean movement;
    private boolean  manKilled;
    
    /**
     * Act - do whatever the man wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Man()
    {
        //img = new GreenfootImage("warrior.png");
        //imgW= new GreenfootImage("warrior-front-attack.png");
        //imgD= new GreenfootImage("warrior-right-attack.png");
        //imgA= new GreenfootImage("warrior-left-attack.png");
        //imgS= new GreenfootImage("warrior-back-attack.png");
        //img.scale(60,60);
        
        img = new ImageHolder("warrior.png");
        imgW= new ImageHolder("warrior-front-attack.png");
        imgD= new ImageHolder("warrior-right-attack.png");
        imgA= new ImageHolder("warrior-left-attack.png");
        imgS= new ImageHolder("warrior-back-attack.png");
        imgR= new ImageHolder("warrior-right.png");
        imgB=new ImageHolder("warrior-back.png");
        imgL=new ImageHolder("warrior-left.png");
        img.image.scale(60,60);
        
        
        
        //gif = new GifImage("skeleton-club.gif");
        //gif.resizeImages(60,60);
        health=200;
        damage=10;
        timer=1;
        setImage(img);
        speed = 4;
          
        attacking=false;
        movement=false;
    }
    public void act() 
    {
       
       boolean attackPressed= Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("d");
       movement = Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("right");
            movement();
            
            if(attackPressed)
            {
                attacking=true;
                attack();
            }
            else if(!movement)
            {
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
            {
                setImage(img);
                setLocation(getX(),getY()-speed) ;
            }
            if(Greenfoot.isKeyDown("down") && !touchingWall())
             {  
                 setImage(imgB);
                 setLocation(getX(),getY()+speed);
             }
            if(Greenfoot.isKeyDown("right") )
            {
                setImage(imgR);
                setLocation(getX()+speed,getY());
            }
            if(Greenfoot.isKeyDown("left"))
            {
                setImage(imgL);
                setLocation(getX()-speed,getY());
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
    
    
    
    public void attack()
    {
           
         
            if(Greenfoot.isKeyDown("w"))
            {   
               if(animationCounter%2==0)
               animateAttack(imgW);
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
              // if(animationCounter%2==0)
              // animateAttack();
               if(animationCounter%2==0)
               animateAttack(imgD);
                      
            }
            if(isTouching(Undead.class)){
            ISubject s = (Undead)getOneIntersectingObject(Undead.class);
            s.causeDamage(this);
            }
            else if(isTouching(Spear.class)){
                ISubject s = (Spear)getOneIntersectingObject(Spear.class);
                s.causeDamage(this);
            }
            else if(isTouching(NightKing.class)){
            
              ISubject s = (NightKing)getOneIntersectingObject(NightKing.class);
                s.causeDamage(this);
            }
    }
    
    public void animateAttack(ImageHolder dir)
    {
        if(timer == 1)
        setImage(dir);
        else if(timer==2)
        setImage(imgD);
        else if(timer ==3)
        setImage(imgA);
        //else if(timer>=4)
        //endAnimation();
        timer++;
        
    }
    
    private void endAnimation()
    {
        //System.err.println("end animation timer : "+timer);
        //if(timer>=4
        //||(
        //!Greenfoot.isKeyDown("w")
        //&&!Greenfoot.isKeyDown("a")
        //&&!Greenfoot.isKeyDown("s")
        //&&!Greenfoot.isKeyDown("d")
        //)
        //)
        {
        timer=1;
        
        attacking=false;
        setImage(img);
        }
    }
    
    public void setImage(ImageHolder img){
    //System.err.println("Man image is set to "+img.fileName);
    super.setImage(img.image);
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
        //System.out.println("In man cause damage  : "+a);
        if(a instanceof Undead )
        
        health=health-a.getDamage();
        
        else if(a instanceof Spear)
        health=health-a.getDamage();
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
    public boolean isKilledByMan()
    {
        return manKilled;
    }
}
