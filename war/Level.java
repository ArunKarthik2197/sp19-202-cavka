import java.util.ArrayList;
/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level 
{
    private static int currentLevel;
    
    private IStrategy lv1;
    private IStrategy lv2;
    private IStrategy lv3;
    private IStrategy lv4;
    private IStrategy lv5;
    private ArrayList<IStrategy> levels;
    private static Level levelInstance;
    private Level()
    {
        lv1=new LevelStrategy1();
        lv2=new LevelStrategy2();
        lv3=new LevelStrategy3();
        lv4=new LevelStrategy4();
        lv5=new LevelStrategy5();
        levels = new ArrayList<IStrategy>(5);
        currentLevel=0;
        setupLevels();
        levelInstance=this;
    }
    public static Level getInstance()
    {
        if(levelInstance==null)
        return new Level();
        else
        {
            currentLevel=0;
            return levelInstance;
        }
    }
    private void setupLevels()
    {
        levels.add(lv1);
        levels.add(lv2);
        levels.add(lv3);
        levels.add(lv4);
        levels.add(lv5);
    }
    public void levelUp()
    {
        if(currentLevel<levels.size()-1){
            currentLevel++;
            System.err.println("currentLevel counter :" +currentLevel);
        }
        else
            System.err.println("You won");
    }
    
    public IStrategy getCurrent()
    {
        return levels.get(currentLevel);
    }
}
