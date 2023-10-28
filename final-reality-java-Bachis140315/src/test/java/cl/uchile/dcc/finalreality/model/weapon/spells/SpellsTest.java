package cl.uchile.dcc.finalreality.model.weapon.spells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.spells.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpellsTest {
  private GameCharacter playercharacter;
  private GameCharacter enemy;
  
  
  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    playercharacter = new Engineer("", 100, 100, queue);
    enemy = new Enemy("",100 ,100 ,100 ,queue, 100);
  }
  
  @Test
  public void makemySpell() throws InvalidStatValueException {
    Spells cure = new CureSpell();
    Spells fire = new FireSpell(1);
    Spells paralize = new ParalizeSpell();
    Spells poison = new PoisonSpell(1);
    Spells thundered = new ThunderSpell();
    
    fire.makemySpell(playercharacter);
    assertTrue((playercharacter.getState()).infire());
    (playercharacter.getState()).makeEffect();
    assertEquals(99, playercharacter.getCurrentHp());
    
    paralize.makemySpell(enemy);
    assertTrue((enemy.getState()).paralized());
    
    poison.makemySpell(playercharacter);
    assertTrue((playercharacter.getState()).poisoned());
    (playercharacter.getState()).makeEffect();
    assertEquals(98, playercharacter.getCurrentHp());
    
    thundered.makemySpell(enemy);
    assertTrue((enemy.getState()).paralized());
    
    playercharacter.setCurrentHp(55);
    cure.makemySpell(playercharacter);
    assertEquals(85, playercharacter.getCurrentHp());
    
  }
}