package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;

/**
 * A class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Vicente Jesus Duhalde Garcia~
 */
public abstract class AbstractWeapon implements Weapon {

  private final String name;
  private final int damage;
  private final int weight;
  private final String  type;
  
  protected int magicdamage = 0;

  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   */
  protected AbstractWeapon(final String name, final int damage, final int weight,
      final WeaponType type) throws InvalidStatValueException {
    Require.statValueAtLeast(1, damage, "Damage");
    Require.statValueAtLeast(0, weight, "Max HP");
    this.name = name;
    this.damage = damage;
    this.weight = weight;
    this.type = String.valueOf(type);
  }
  /**
   * Creates a weapon with a name, a base damage, speed, and it's type, the tyep parameter is from
   * an enum of magic weapons.
   */

  protected AbstractWeapon(final String name, final int damage, final int weight,
                           final MagicWeaponType type) throws InvalidStatValueException {
    Require.statValueAtLeast(1, damage, "Damage");
    Require.statValueAtLeast(0, weight, "Max HP");
    this.name = name;
    this.damage = damage;
    this.weight = weight;
    this.type = String.valueOf(type);
  }

  /**
   * Returns the name of the weapon.
   */
  @Override
  public String getName() {
    return name;
  }
  /**
   * Returns the base damage that the weapon deals.
   */
  
  @Override
  public int getDamage() {
    return damage;
  }
  /**
   * Returns the weight of the weapon.
   */
  
  @Override
  public int getWeight() {
    return weight;
  }
  /**
   * Returns the type of the weapon.
   */
  
  @Override
  public String getType() {
    return type;
  }
  
  /**
   * Returns the MagicDamage that a magical weapon deals.
   */
  @Override
  public int getMagicDamage() {
    return magicdamage;
  }
  
  
}
