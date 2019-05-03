public class Originator {
   private IGameState state;

   public void setState(String state){
      Greenfoot.setWorld((World)state);
   }

   public String getState(){
      return state;
   }

   public Memento saveStateToMemento(){
      return new Memento(state);
   }

   public void getStateFromMemento(Memento memento){
      state = memento.getState();
   }
}