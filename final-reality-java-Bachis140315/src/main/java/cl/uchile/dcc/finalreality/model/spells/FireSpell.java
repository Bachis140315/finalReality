package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.state.InFireState;

/**
 * This FireSpell class makes the damage that comes from a magical Weapon.
 */
public class FireSpell implements Spells {
  private int damage;
  
  public FireSpell(int dano) {
    super();
    damage = dano;
  }
  
  @Override
  public void makemySpell(GameCharacter character) throws InvalidStatValueException {
    character.setState(new InFireState(damage));
  }
  
  
}
