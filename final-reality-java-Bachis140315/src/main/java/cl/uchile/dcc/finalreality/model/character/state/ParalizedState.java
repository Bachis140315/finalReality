package cl.uchile.dcc.finalreality.model.character.state;

/**
 * This ParalizedState class reports if a game character is paralized
 * or not.
 */
public class ParalizedState extends State {
  
  @Override
  public boolean paralized() {
    return true;
  }
  
  @Override
  public void getParalized() {
    ourCharacter.setState(this);
  }
  
  @Override
  public String makeEffect() {
    ourCharacter.setState(new NormalState());
    return "No me puedo mover!!!";
  }
}
