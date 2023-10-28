/*
 * "Final Reality" (c) by R8V and ~Vicente Duhalde~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.spells.CureSpell;
import cl.uchile.dcc.finalreality.model.spells.ParalizeSpell;
import cl.uchile.dcc.finalreality.model.spells.PoisonSpell;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can equip {@code Staff}s and use <i>white magic</i>.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Vicente Jesus Duhalde Garcia~
 */
public class WhiteMage extends AbstractMagicalPlayerCharacter {


  /**
   * Creates a new character.
   *
   * @param name       the character's name
   * @param maxHp      the character's max hp
   * @param defense    the character's defense
   * @param turnsQueue the queue with the characters waiting for their turn
   * @param maxMp      the character's max Magical Power of a magical Character
   */
  public WhiteMage(final @NotNull String name, final int maxHp, final int defense,
                   final @NotNull BlockingQueue<GameCharacter> turnsQueue, int maxMp)
          throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue, maxMp);
    setListAcceptedWeapons(createListAw());
  }
  
  private String[] createListAw() {
    return new String[]{"STAFF"};
  }
  
  /**
   * The makeCureSpell method receives a player character and cures a percentage of its
   * maxHp and sets its currentHp with this cure.
   */
  public void makeCureSpell(PlayerCharacter playerCharacter) throws InvalidStatValueException {
    int magicpoints = this.getCurrentMp();
    if (magicpoints < 15) {
      return;
    } else {
      this.setCurrentMp(magicpoints - 15);
      (new CureSpell()).makemySpell(playerCharacter);
      
    }
  }
  
  /**
   * This makeParalizedSpell method makes a ParalizedSpell on an enemy.
   */
  public void makeParalizeSpell(Enemy enemy) throws InvalidStatValueException {
    int magicpoints = this.getCurrentMp();
    if (magicpoints < 25) {
      return;
    } else {
      this.setCurrentMp(magicpoints - 25);
      (new ParalizeSpell()).makemySpell(enemy);
    }
  }
  
  /**
   * This makePoisonSpell method makes a PoisonSpell on an enemy.
   */
  public void makePoisonSpell(Enemy enemy) throws InvalidStatValueException {
    int magicpoints = this.getCurrentMp();
    if (magicpoints < 40) {
      return;
    } else {
      this.setCurrentMp(magicpoints - 40);
      PoisonSpell spell = new PoisonSpell(((this.getEquippedWeapon()).getMagicDamage()) / 3);
      spell.makemySpell(enemy);
    }
  }
  
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final WhiteMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
            && maxMp == that.maxMp
            && name.equals(that.name)
            && maxHp == that.maxHp
            && defense == that.defense;
  }

  @Override
  public String toString() {
    return "WhiteMage{currentMp=%d, maxMp=%d, maxHp=%d, defense=%d, name='%s'}"
            .formatted(this.getCurrentMp(), maxMp, maxHp, defense, name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(WhiteMage.class, name, maxHp, defense, maxMp);
  }


}
