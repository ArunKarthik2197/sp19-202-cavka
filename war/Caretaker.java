/**
 * Write a description of class CareTaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caretaker {

  private Memento memento;

  public Memento getMemento() {
  System.out.println("Hi from caretaker getmeme");
    return memento;
  }

  public void setMemento(Memento memento) {
  System.out.println("Hi from caretaker setmem");
    this.memento = memento;
  }
}

