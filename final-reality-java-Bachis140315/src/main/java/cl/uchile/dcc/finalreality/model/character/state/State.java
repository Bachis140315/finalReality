package cl.uchile.dcc.finalreality.model.character.state;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * This State class is in charge of determinate every method for the
 * others states.
 */
public class State {
  protected GameCharacter ourCharacter;
  
  
  public boolean infire() {
    return false;
  }
  
  public boolean paralized() {
    return false;
  }
  
  public boolean poisoned() {
    return false;
  }
  
  public boolean normal() {
    return false;
  }
  
  public boolean dead() {
    return false;
  }
  
  
  
  public void setinFire(int dano) {
    ourCharacter.setState(new InFireState(dano));
  }
  
  public void getParalized() {
    ourCharacter.setState(new ParalizedState());
  }
  
  public void getPoisoned(int dano) {
    ourCharacter.setState(new PoisonedState(dano));
  }
  
  public void gobacktoNormal() {
    ourCharacter.setState(new NormalState());
  }
  
  public void setOur_character(GameCharacter character) {
    ourCharacter = character;
  }
  
  public String makeEffect() throws InvalidStatValueException {
    return "Este estado no hace nada";
  }
  
}
