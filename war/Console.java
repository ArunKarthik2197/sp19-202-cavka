import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Console here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Console extends Actor
{
    
    ArrayList<String> debugStatements;
    
    GreenfootImage img;
    
    private static Console console;
    
    private Console(){
        debugStatements = new ArrayList<String>();
    }
    
    public static Console getInstance(){
        if(console==null)console=new Console();
        return console;
    }
    
    public static void resetInstance(){
        console=null;
    }
    
    /**
     * Act - do whatever the Console wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public void debugStatement(String str){
        debugStatements.add(str);
        if(debugStatements.size()==11){
            debugStatements.remove(0);
        }
        updateConsole();
    }
    
    public void updateConsole(){
        String Str="";
        
        for(String dbg:debugStatements){
            Str+=dbg+"\n";
        }
        
        Str=Str.trim();
        
        img = new GreenfootImage(Str, 20,Color.WHITE, Color.BLACK);
        setImage(img);
    }
}
