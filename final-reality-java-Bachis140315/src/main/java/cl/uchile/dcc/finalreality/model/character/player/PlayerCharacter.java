package cl.uchile.dcc.finalreality.model.character.player;

/*
 * "Final Reality" (c) by R8V and ~Vicente Duhalde~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.NormalWeapon;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

/**
 * A {@link GameCharacter} that can equip a weapon.
 */
public interface PlayerCharacter extends GameCharacter {
  /**
   * Equips a weapon to the character.
   */
  void equip(Weapon weapon);

  /**
   * Return this character's equipped weapon.
   */
  NormalWeapon getEquippedWeapon();
  
  
  String[] getAcceptedWeapon();
  
  void validWeapon(Weapon weapon);
  
  /**
   * Makes the playercharacter attack an enemy.
   */
  void attack(Enemy enemy) throws InvalidStatValueException;
  
  /**
   * The character receives the damage from a weapon, which was extracted in the attack method.
   */
  void receiveattack(Enemy enemy) throws InvalidStatValueException;
  
  int getMaxMp();
  
  
  
}
