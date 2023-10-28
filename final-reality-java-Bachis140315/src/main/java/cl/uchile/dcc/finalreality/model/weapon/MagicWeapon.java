package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.util.Objects;

/**
 * A {@link NormalWeapon} that can be equipped in {@link PlayerCharacter}
 * with Mp (Magical Player Characters).
 *
 * @author ~Vicente Jesus Duhalde Garcia~
 */
public class MagicWeapon extends NormalWeapon {
  
  /**
   * Creates a weapon with a name, a base damage, speed, type and it's MagicDamage.
   */
  public MagicWeapon(final String name, final int damage, final int weight,
                     final MagicWeaponType type, final int magicdamage)
        throws InvalidStatValueException {
    super(name, damage, weight, type);
    Require.statValueAtLeast(1, magicdamage, "Magic Damage");
    this.setMagicdamage(magicdamage);
  }
  
  
  
  /**
   * Returns if two magicweapons have the same attributes.
   */
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final MagicWeapon weapon)) {
      return false;
    }
    return hashCode() == weapon.hashCode()
          && this.getDamage() == weapon.getDamage()
          && this.getWeight() == weapon.getWeight()
          && this.getName().equals(weapon.getName())
          && getType() == weapon.getType()
          && getMagicDamage() == weapon.getMagicDamage();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(MagicWeapon.class, this.getName(), this.getDamage(),
          this.getWeight(), this.getType(), this.getMagicDamage());
  }
  
  @Override
  public String toString() {
    return "MagicWeapon{name='%s', damage=%d, weight=%d, type=%s, MagicDamage=%d}"
          .formatted(this.getName(), this.getDamage(),
                this.getWeight(), this.getType(), this.getMagicDamage());
  }
  
  public void setMagicdamage(int md) {
    magicdamage = md;
  }
  
}
