package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

/**
 * The {@link WhiteMageTest} class exists to test every method created in the {@link WhiteMage} class,
 * setting up different scenarios where a {@link WhiteMage} can be.
 */
public class WhiteMageTest {
  private WhiteMage whitemage1;
  private WhiteMage whitemage1_copia;
  private WhiteMage whitemage2;
  private WhiteMage whitemage3;
  private WhiteMage whitemage_arma;
  
  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
  
    whitemage1= new WhiteMage("Merlin", 11, 11,queue,11);
    whitemage1_copia= new WhiteMage("Merlin", 11, 11, queue,11);
    whitemage2= new WhiteMage("Gandalf", 22, 22,queue,22);
    whitemage3= new WhiteMage("Albus", 33, 33, queue,33);
    whitemage_arma= new WhiteMage("Draktarr", 44, 44, queue,44);
  }
  @Test
  public void testTestEquals() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    
    assertTrue(whitemage1.equals(whitemage1_copia));
    assertTrue(whitemage2.equals(new WhiteMage("Gandalf", 22, 22,queue,22)));
    assertFalse(whitemage3.equals(whitemage_arma));
    assertFalse(whitemage_arma.equals(new WhiteMage("Draktarr", 44, 44, queue,33)));
    assertTrue(whitemage3.equals(whitemage3));
    assertFalse(whitemage_arma.equals(new BlackMage("Draktarr", 44, 44, queue,44)));
  }
  @Test
  public void testTestToString() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    
    assertEquals(whitemage1.toString(),whitemage1_copia.toString());
    assertEquals("WhiteMage{currentMp=22, maxMp=22, maxHp=22, defense=22, name='Gandalf'}",whitemage2.toString());
    assertNotEquals(whitemage3.toString(),whitemage_arma.toString());
    assertNotEquals(whitemage_arma.toString(),(new WhiteMage("Draktarr", 44, 22, queue,44)).toString());
  }
  @Test
  public void testTestHashCode() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    
    assertEquals(whitemage1.hashCode(),whitemage1_copia.hashCode());
    assertEquals(whitemage2.hashCode(),(new WhiteMage("Gandalf", 22, 22,queue,22)).hashCode());
    assertNotEquals(whitemage3.hashCode(),whitemage_arma.hashCode());
    assertNotEquals(whitemage_arma.hashCode(),(new WhiteMage("Draktarr", 14, 14, queue,14)).hashCode());
  }
}