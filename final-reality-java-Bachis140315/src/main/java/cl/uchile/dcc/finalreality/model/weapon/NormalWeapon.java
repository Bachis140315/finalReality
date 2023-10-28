package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import java.util.Objects;

/**
 * A class that holds all the information of a single weapon of the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Vicente Duhalde~
 */
public class NormalWeapon extends AbstractWeapon {
  
  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   */
  public NormalWeapon(final String name, final int damage, final int weight,
                      final WeaponType type) throws InvalidStatValueException {
    super(name, damage, weight, type);
  }
  
  protected NormalWeapon(final String name, final int damage, final int weight,
                         final MagicWeaponType type) throws InvalidStatValueException {
    super(name, damage, weight, type);
  }
  
  
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final NormalWeapon weapon)) {
      return false;
    }
    return hashCode() == weapon.hashCode()
          && this.getDamage() == weapon.getDamage()
          && this.getWeight() == weapon.getWeight()
          && this.getName().equals(weapon.getName())
          && getType() == weapon.getType();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(NormalWeapon.class, this.getName(), this.getDamage(),
          this.getWeight(), this.getType());
  }
  
  @Override
  public String toString() {
    return "NormalWeapon{name='%s', damage=%d, weight=%d, type=%s}"
          .formatted(this.getName(), this.getDamage(), this.getWeight(), this.getType());
  }
}
