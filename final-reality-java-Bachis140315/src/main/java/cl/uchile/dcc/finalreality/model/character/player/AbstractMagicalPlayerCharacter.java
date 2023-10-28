package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a player-controlled character in the game,
 * but it has Mp (Magical Power or Mana).
 *
 * <p>It's like any other playable character, but is has the {@code Mp} to cast a spell or to use
 * it in another movement that requires {@code Mp}.
 * This abstract class allows to introduce more classes of playable characters
 * that have Magical Power, like fairy type classes.
 *
 * @author ~Vicente Jesus Duhalde Garcia~
 */
public abstract class AbstractMagicalPlayerCharacter extends AbstractPlayerCharacter {
  private int currentMp;
  
  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
   *
   * @param name       the character's name
   * @param maxHp      the character's max hp
   * @param defense    the character's defense
   * @param turnsQueue the queue with the characters waiting for their turn
   * @param maxMp      the character's max Magical Power of a magical Character
   */
  protected AbstractMagicalPlayerCharacter(String name, int maxHp, int defense,
                                           BlockingQueue<GameCharacter> turnsQueue, int maxMp)
        throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, maxMp, "Max MP");
    this.maxMp = maxMp;
    this.currentMp = maxMp;
  }
  
  /**
   * Returns the character's current MP.
   */
  public int getCurrentMp() {
    return currentMp;
  }
  
  /**
   * Sets the character's current MP.
   */
  public void setCurrentMp(final int currentMp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, currentMp, "Current MP");
    Require.statValueAtMost(maxMp, currentMp, "Current MP");
    this.currentMp = currentMp;
  }
  
  
  //
  
  
}
