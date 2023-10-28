package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Vicente Duhalde~
 */
public class Enemy extends AbstractCharacter {

  private final int weight;
  
  private final int attack;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, final int weight, int maxHp, int defense,
               @NotNull final BlockingQueue<GameCharacter> turnsQueue, int attack)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    this.attack = attack;
    Require.statValueAtLeast(1, weight, "Weight");
    this.weight = weight;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Enemy enemy)) {
      return false;
    }
    return hashCode() == enemy.hashCode()
        && name.equals(enemy.name)
        && weight == enemy.weight
        && maxHp == enemy.maxHp
        && defense == enemy.defense;
  }
  
  public int getAttack() {
    return attack;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, name, weight, maxHp, defense);
  }
  
  @Override
  public String toString() {
    return "Enemy{maxHp=%d, defense=%d, weight=%d, name='%s', attack=%d}"
          .formatted(maxHp, defense, weight, name, attack);
  }
  
  public void attack(PlayerCharacter playerCharacter) throws InvalidStatValueException {
    playerCharacter.receiveattack(this);
  }
  
  /**
   * Receiveattack receives a weapon, because an Enemy type character
   * receives damage from a weapon that a playercharacter has equipped.
   */
  public void receiveattack(Weapon weapon) throws InvalidStatValueException {
    int actualHp = this.getCurrentHp();
    if (this.getCurrentHp() > 0) {
      actualHp = actualHp - weapon.getDamage() + (this.getDefense() / 10);
      if (actualHp < 0) {
        this.setCurrentHp(0);
      } else if (actualHp <= this.getCurrentHp()) {
        this.setCurrentHp(actualHp);
      }
    }
  }
}

