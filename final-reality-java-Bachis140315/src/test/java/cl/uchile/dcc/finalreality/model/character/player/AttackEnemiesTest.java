package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.NormalWeapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This test class tries to verify if the attack and receiveattack methods in {@code AbstractPlayerCharacter}
 * are well-made. As those methods are located in this abstract class, they work as well
 * in the other subclasses, like {@code Knight}, {@code WhiteMage}, etc...<p></p>
 *
 * Those methods simulate the battle between a player character (using only his equipped weapon)
 * and an enemy (using only his attack attribute).<p></p>
 *
 * Also, the method {@code attack()} uses "double dispatch" with the method {@code receiveattack()}
 * , because an enemy receives the damage from a weapon and the player character from an enemy
 * directly.
 */

public class AttackEnemiesTest {
  private Engineer ingeniero;
  private NormalWeapon arma;
  private NormalWeapon weakweapon;
  private Enemy enemy;
  
  
  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    ingeniero = new Engineer("A",100,0,queue);
    arma = new NormalWeapon("hacha",101,10, WeaponType.AXE);
    weakweapon=new NormalWeapon("arma debil ",5,10,WeaponType.BOW);
    enemy = new Enemy("Malo",10,100,100,queue,10);
    }
  
  
  @Test
  public void attack() throws InvalidStatValueException {
    ingeniero.equip(arma);
    ingeniero.attack(enemy);
    assertEquals(9,enemy.getCurrentHp());
    
    enemy.setCurrentHp(10);
    ingeniero.equip(weakweapon);
    ingeniero.attack(enemy);
    assertEquals(10,enemy.getCurrentHp());
  }
  
  @Test
  public void receiveattack() throws InvalidStatValueException {
    for (int i=0; i<10; i++){
      enemy.attack(ingeniero);
      assertEquals((10*(9-i)),ingeniero.getCurrentHp());
    }
    ingeniero.receiveattack(enemy);
    assertEquals(0,ingeniero.getCurrentHp());
  }
}