package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.state.PoisonedState;

/**
 * The PoisonSpell class has the function of changing a game
 * character's state in PoisonedState.
 */
public class PoisonSpell implements Spells {
  int damage = 0;
  
  public  PoisonSpell(int dano) {
    super();
    damage = dano;
  }
  
  @Override
  public void makemySpell(GameCharacter character)  {
    character.setState(new PoisonedState(damage));
  }
  
}
