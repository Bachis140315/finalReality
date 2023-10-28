package cl.uchile.dcc.finalreality.model.character.state;

/**
 * The NormalState class is the normal state that the characters
 * have predeterminated. This state makes no side effects.
 */
public class NormalState extends State {
  
  
  @Override
  public boolean normal() {
    return true;
  }
  
  
  @Override
  public String makeEffect() {
    return "Estoy bien y preparado para luchar!";
  }
  
}
