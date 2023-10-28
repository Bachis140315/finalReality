package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.state.ParalizedState;

/**
 * The ParalizeSpell is a type of spell and its only method chnages
 * the state of a game character to the ParalizedState.
 */
public class ParalizeSpell implements Spells {
  
  @Override
  public void makemySpell(GameCharacter character) {
    character.setState(new ParalizedState());
  
  }
}
