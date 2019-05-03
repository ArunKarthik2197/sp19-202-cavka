public class Memento {
   private IGameState state;

   public Memento(String state){
      this.state = state;
   }

   public String getState(){
      return state;
   }	
}