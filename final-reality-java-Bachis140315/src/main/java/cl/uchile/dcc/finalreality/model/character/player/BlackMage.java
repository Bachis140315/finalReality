/*
 * "Final Reality" (c) by R8V and ~Vicente Jesus Duhalde Garcia~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.spells.FireSpell;
import cl.uchile.dcc.finalreality.model.spells.ParalizeSpell;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;


/**
 * A Black Mage is a type of player character that can cast black magic.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Vicente Jesus Duhalde Garcia~
 * @version 2.0
 */
public class BlackMage extends AbstractMagicalPlayerCharacter {
  
  
  /**
   * Creates a new Black Mage.
   *
   * @param name       the character's name
   * @param maxHp      the character's max hp
   * @param defense    the character's defense
   * @param turnsQueue the queue with the characters waiting for their turn
   * @param maxMp      the character's max Magical Power of a magical Character
   */
  public BlackMage(final @NotNull String name, final int maxHp, final int defense,
                   final @NotNull BlockingQueue<GameCharacter> turnsQueue, int maxMp)
        throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue, maxMp);
    setListAcceptedWeapons(createListAw());
  }
  
  
  private String[] createListAw() {
    return new String[]{"KNIFE", "STAFF"};
  }
  
  /**
   * MakeThunderSpell method makes a certain amount of damage to the enemy
   * and there is 30% of probability of being paralized by the spell.
   */
  public void makeThunderSpell(Enemy enemy) throws InvalidStatValueException {
    String queweapon = (this.getEquippedWeapon()).toString();
    if (!queweapon.contains(", MagicDamage=")) {
      System.out.printf("No se puede atacar con el arma %s ,pues no tiene Md", queweapon);
      return;
    }
    
    int damage = (this.getEquippedWeapon()).getMagicDamage();
    
    int magicpoints = this.getCurrentMp();
    if (magicpoints >= 15) {
      
      Random rng = new Random();
      this.setCurrentMp(magicpoints - 15);
      
      try {
        enemy.setCurrentHp(enemy.getCurrentHp() - damage);
      } catch (InvalidStatValueException e) {
        enemy.setCurrentHp(0);
      }
      if (rng.nextInt(10) < 3) {
        (new ParalizeSpell()).makemySpell(enemy);
      }
    }
  }
  
  /**
   * MakeFireSpell method makes a certain amount of damage to the enemy
   * and there is 30% of probability of being paralized by the spell.
   */
  public void makeFireSpell(Enemy enemy) throws InvalidStatValueException {
    String weapon = (this.getEquippedWeapon()).toString();
    if (!weapon.contains(", MagicDamage=")) {
      System.out.printf("No se puede atacar con el arma %s ,pues no tiene Md", weapon);
      return;
    }
    
    int damage = (this.getEquippedWeapon()).getMagicDamage();
    
    int magicpoints = this.getCurrentMp();
    if (magicpoints >= 15) {
      
      Random rng = new Random();
      this.setCurrentMp(magicpoints - 15);
      
      try {
        enemy.setCurrentHp(enemy.getCurrentHp() - damage);
      } catch (InvalidStatValueException e) {
        enemy.setCurrentHp(0);
      }
      if (rng.nextInt(10) < 2) {
        FireSpell spell = new FireSpell(damage / 2);
        spell.makemySpell(enemy);
      }
      
    }
    
  }
  
  
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final BlackMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
          && name.equals(that.name)
          && maxHp == that.maxHp
          && defense == that.defense
          && maxMp == that.maxMp;
  }
  
  @Override
  public String toString() {
    return "BlackMage{currentMp=%d, maxMp=%d, maxHp=%d, defense=%d, name='%s'}"
          .formatted(this.getCurrentMp(), maxMp, maxHp, defense, name);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(BlackMage.class, name, maxHp, defense, maxMp);
  }
  // endregion
}
