




import greenfoot.*;
/**
 * Write a description of class GameStateMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameStateMachine  
{
    // instance variables - replace the example below with your own
    private int x;
    private IGameState state;
    private IGameState titleScreen;
    private IGameState myWorld;
    
    private IGameState paused;
    private IGameState gameOver;
    /**
     * Constructor for objects of class GameStateMachine
     */
    public GameStateMachine()
    {
        titleScreen = new TitleScreen();
        myWorld = new MyWorld();
        gameOver = new GameOver();
        
        state = titleScreen;
        worldSetter();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void  changeState(States val)
    {
        switch(val){
            
            case TITLE      :   state=titleScreen;
                                worldSetter(); 
                                break;
            case GAME       :   state=myWorld;
                                worldSetter(); 
                                break;
            case GAME_OVER   :  state = gameOver;
                                worldSetter();
                                break;
            case PLAY_AGAIN  : state= new MyWorld();
                               worldSetter();
                               break;
        }
    }
    private void worldSetter()
    {
        Greenfoot.setWorld((World)state);
    }
   
}

enum States{
    TITLE,GAME,PAUSE,GAME_OVER,PLAY_AGAIN
}
