package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.state.DeadState;
import cl.uchile.dcc.finalreality.model.character.state.NormalState;
import cl.uchile.dcc.finalreality.model.character.state.State;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Vicente Jesus Duhalde Garcia~
 */

public abstract class AbstractCharacter implements GameCharacter {
  
  protected final BlockingQueue<GameCharacter> turnsQueue;
  protected final String name;
  protected int maxHp;
  protected int defense;
  private State state;
  private int currentHp;
  private ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new character.
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
  protected AbstractCharacter(@NotNull String name, int maxHp, int defense,
      @NotNull BlockingQueue<GameCharacter> turnsQueue) throws InvalidStatValueException {
    Require.statValueAtLeast(1, maxHp, "Max HP");
    Require.statValueAtLeast(0, defense, "Defense");
    this.maxHp = maxHp;
    this.currentHp = maxHp;
    this.defense = defense;
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.setState(new NormalState());
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    if (!(this.toString().contains("Enemy"))) {
      var player = (PlayerCharacter) this;
      scheduledExecutor.schedule(
          /* command = */ this::addToQueue,
          /* delay = */ player.getEquippedWeapon().getWeight() / 10,
          /* unit = */ TimeUnit.SECONDS);
    } else {
      var enemy = (Enemy) this;
      scheduledExecutor.schedule(
          /* command = */ this::addToQueue,
          /* delay = */ enemy.getWeight() / 10,
          /* unit = */ TimeUnit.SECONDS);
    }
  }

  /**
   * Adds this character to the turns queue.
   */
  private void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getCurrentHp() {
    return currentHp;
  }

  @Override
  public void setCurrentHp(int hp) throws InvalidStatValueException {
    if (hp == 0) {
      this.setState(new DeadState());
    }
    
    Require.statValueAtLeast(0, hp, "Current HP");
    Require.statValueAtMost(maxHp, hp, "Current HP");
    currentHp = hp;
  }

  @Override
  public int getMaxHp() {
    return maxHp;
  }

  @Override
  public int getDefense() {
    return defense;
  }
  
  
  @Override
  public State getState() {
    return state;
  }
  
  @Override
  public void setState(State s) {
    state = s;
    state.setOur_character(this);
  
  }
}
