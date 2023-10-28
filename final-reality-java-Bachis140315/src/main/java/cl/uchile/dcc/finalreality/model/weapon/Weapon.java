package cl.uchile.dcc.finalreality.model.weapon;

/**
 * A {@link Weapon} must show their attributes, to be used in battle.
 */

public interface Weapon {
  
  /**
   * Returns a weapon's name.
   */
  String getName();
  
  /**
   * Returns a weapon's damage.
   */
  int getDamage();
  
  /**
   * Returns a weapon's weight.
   */
  int getWeight();
  
  /**
   * Returns a weapon's type.
   */
  String getType();
  
  int getMagicDamage();
  
}
