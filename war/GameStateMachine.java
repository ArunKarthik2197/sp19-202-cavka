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
    private Originator originator;
    private Caretaker caretaker;
    /**
     * Constructor for objects of class GameStateMachine
     */
    public GameStateMachine()
    {
        titleScreen = new TitleScreen();
        myWorld = new MyWorld();
        gameOver = new GameOver();
        pause = new PausedGame();
        gameWon = new GameWon();
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
        System.err.println("State Changed to "+val);
        switch(val){

            case TITLE       :  state = titleScreen;
            //worldSetter(); 
            originator.setState(state);
          
            break;
            case GAME        :  state = myWorld;
           // worldSetter();            
            originator.setState(state);
            caretaker.setMemento(originator.saveMemento(myWorld));         
           
            break;
            case PAUSE       :  state = pause;
            //worldSetter();          
            originator.setState(state);
       
            break;
            case GAME_OVER   :  state = gameOver;
           // worldSetter();
            originator.setState(state);
   
            break;
            case GAME_OVER_MAN   :  ((GameOver)gameOver).setImageName("game_over_jon.gif");
            state = gameOver;
           // worldSetter();
            originator.setState(state);
   
            break;
            case GAME_OVER_WALL   :  ((GameOver)gameOver).setImageName("startup.gif");
            state = gameOver;
           // worldSetter();
            originator.setState(state);
   
            break;
            case PLAY_AGAIN  :    state= new MyWorld();
                                  worldSetter();
                //originator.setState(originator.restoreMemento(caretaker.getMemento()));
            
            break;
            case GAME_WON   :  state = gameWon;
            //worldSetter();
            originator.setState(state);
            
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
    GAME_OVER_MAN,
    GAME_OVER_WALL,
    PLAY_AGAIN,
    GAME_WON
}
