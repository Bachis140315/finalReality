package cl.uchile.dcc.finalreality.model.character.state;

/**
 * This DeadState class determinates if a character is dead or not.
 */
public class DeadState extends State {
  
  @Override
  public boolean dead() {
    return true;
  }
  
}
