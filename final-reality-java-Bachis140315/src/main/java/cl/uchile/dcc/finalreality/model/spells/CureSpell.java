package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * This CureSpell class is in charge of curing allies, depending on
 * the ally´s maxHp.
 */
public class CureSpell implements Spells {
  
  @Override
  public void makemySpell(GameCharacter character) throws InvalidStatValueException {
    int curacion = ((character.getMaxHp()) / 10) * 3;
    
    int vidaSanada = character.getCurrentHp() + curacion;
    
    if (vidaSanada > character.getMaxHp()) {
      character.setCurrentHp(character.getMaxHp());
    } else {
      character.setCurrentHp(vidaSanada);
    }
  }
}
