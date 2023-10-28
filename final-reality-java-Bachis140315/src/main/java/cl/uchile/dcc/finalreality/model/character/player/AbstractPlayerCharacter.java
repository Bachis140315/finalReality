/*
 * "Final Reality" (c) by R8V and ~Vicente Jesus Duhalde Garcia~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.NormalWeapon;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;



/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * <p>All player characters have a {@code name}, a maximum amount of <i>hit points</i>
 * ({@code maxHp}), a {@code defense} value, a queue of {@link GameCharacter}s that are
 * waiting for their turn ({@code turnsQueue}), and can equip a {@link NormalWeapon}.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Vicente Jesus Duhalde Garcia~
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements
    PlayerCharacter {

  protected int maxMp = 0;
  
  private Weapon equippedWeapon = null;
  private String[] acceptedWeapon;

  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractPlayerCharacter(@NotNull final String name, final int maxHp,
      final int defense, @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public void equip(Weapon weapon) {
    if (weapon == null) {
      this.equippedWeapon = null;
      return;
    }
    this.validWeapon(weapon);
  }

  protected void setListAcceptedWeapons(String[] lista) {
    this.acceptedWeapon = lista;
  }
  
  
  @Override
  public NormalWeapon getEquippedWeapon() {
    return (NormalWeapon) equippedWeapon;
  }
  
  @Override
  public String[] getAcceptedWeapon() {
    return acceptedWeapon;
  }
  
  @Override
  public void validWeapon(Weapon weapon) {
    
    String[] aceptados = getAcceptedWeapon();
    
    if (Arrays.stream(aceptados).anyMatch(weapon.getType()::equals)) {
      this.equippedWeapon = weapon;
      System.out.println("El arma " + weapon + " fue equipado");
    } else {
      System.out.println("El tipo del personaje no permite equipar armas tipo " + weapon.getType());
    }
  }
  
  @Override
  public void attack(Enemy enemy) throws InvalidStatValueException {
    if (this.equippedWeapon == null) {
      return;
    }
    enemy.receiveattack(this.equippedWeapon);
  }
  
  @Override
  public void receiveattack(Enemy enemy) throws InvalidStatValueException {
    int actualHp = this.getCurrentHp();
    if (this.getCurrentHp() > 0) {
      actualHp = actualHp - enemy.getAttack() + (this.getDefense() / 10);
      if (actualHp < 0) {
        this.setCurrentHp(0);
        //cambiar estado a muerto
      } else if (actualHp <= this.getCurrentHp()) {
        this.setCurrentHp(actualHp);
      }
    }
  }
  
  /**
   * Returns the character's max MP.
   */
  public int getMaxMp() {
    return maxMp;
  }
}
