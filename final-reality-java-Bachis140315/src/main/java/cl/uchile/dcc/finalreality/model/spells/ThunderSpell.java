package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.state.ParalizedState;

/**
 * This ThunderSpell class is in charge of changing the state of a game
 * characert into a ParalizedState.
 */
public class ThunderSpell implements Spells {
  
  @Override
  public void makemySpell(GameCharacter character) {
    character.setState(new ParalizedState());
  }
}
