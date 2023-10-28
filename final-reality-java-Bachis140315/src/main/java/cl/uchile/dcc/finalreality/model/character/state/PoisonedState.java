package cl.uchile.dcc.finalreality.model.character.state;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;

/**
 * This PoisonedState class has the attribute damageTodeal that is the
 * damage that a game character that has this state has to receive in
 * his turn (only one turn, the same por the InFireState).
 */
public class PoisonedState extends State {
  
  private int damageTodeal = 0;
  
  public PoisonedState(int cuantoInflige) {
    super();
    damageTodeal = cuantoInflige;
  }

  @Override
  public boolean poisoned() {
    return true;
  }
  
  @Override
  public void getPoisoned(int dano) {
    ourCharacter.setState(this);
  }
  
  @Override
  public String makeEffect() throws InvalidStatValueException {
    int vidaActual = ourCharacter.getCurrentHp();
    if (vidaActual >= damageTodeal) {
      ourCharacter.setCurrentHp(vidaActual - damageTodeal);
  
    } else {
      ourCharacter.setCurrentHp(0);
    }
    ourCharacter.setState(new NormalState());
    return ("Estoy envenenado, y perdí %d puntos de vida!").formatted(damageTodeal);
  }
  
  public void setDamage_to_deal(int dano) {
    damageTodeal = dano;
  }
}
