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
    private IGameState pause;
    private IGameState gameOver;
    private IGameState gameWon;
    /**
     * Constructor for objects of class GameStateMachine
     */
    public GameStateMachine()
    {
        titleScreen = new TitleScreen();
        myWorld = new MyWorld();
        gameOver = new GameOver();
        pause = new PausedGame();
        state = titleScreen;
        worldSetter();
        originator = new Originator();
   	    caretaker = new Caretaker();
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

            case TITLE       :  state = titleScreen;
            worldSetter(); 
            break;
            case GAME        :  state = myWorld;
            worldSetter(); 
            break;
            case PAUSE       :  state = pause;
            worldSetter();
            break;
            case GAME_OVER   :  state = gameOver;
            worldSetter();
            break;
            case GAME_WON   :  state = gameWon;
            worldSetter();
            break;
            case PLAY_AGAIN  :  state= new MyWorld();
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
    TITLE,
    GAME,
    PAUSE,
    GAME_OVER,
    PLAY_AGAIN,
    GAME_WON
}
