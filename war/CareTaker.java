import java.util.ArrayList;
import java.util.List;

public class CareTaker {
   private List<Memento> mementoList = new ArrayList<Memento>();

   public void saveMemento(Memento state){
      mementoList.add(state);
   }

   public Memento restoreMemento(void){
      return mementoList.get(index);
   }
}