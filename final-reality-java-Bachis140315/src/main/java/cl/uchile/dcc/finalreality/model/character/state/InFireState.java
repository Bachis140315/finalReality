package cl.uchile.dcc.finalreality.model.character.state;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;

/**
 * The InFireState class extends the State class and has a new attribute
 * called damageTodeal, that is the damage that this state does to the character.
 */
public class InFireState extends State {
  private int damageTodeal = 0;
  
  public InFireState(int dano) {
    super();
    damageTodeal = dano;
  }
  
  @Override
  public boolean infire() {
    return true;
  }
  
  
  @Override
  public void setinFire(int dano) {
    ourCharacter.setState(this);
  }
  
  @Override
  public String makeEffect() throws InvalidStatValueException {
    int vidaActual = ourCharacter.getCurrentHp();
    if (vidaActual > damageTodeal) {
      ourCharacter.setCurrentHp(vidaActual - damageTodeal);
    } else {
      ourCharacter.setCurrentHp(0);
    }
    ourCharacter.setState(new NormalState());
    return ("Estoy quemado, y perdí %d puntos de vida!").formatted(damageTodeal);
  }
  
  public void setDamage_to_deal(int dano) {
    damageTodeal = dano;
  }
  
}
