package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * The Spell class is the class that specifies every method for the other
 * spells.
 */
public interface Spells {
  
  void makemySpell(GameCharacter character) throws InvalidStatValueException;
}
