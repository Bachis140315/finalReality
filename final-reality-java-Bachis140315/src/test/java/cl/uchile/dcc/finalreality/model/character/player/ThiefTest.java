package cl.uchile.dcc.finalreality.model.character.player;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

/**
 * The {@link ThiefTest} class exists to test every method created in the {@link Thief} class,
 * setting up different scenarios where a {@link Thief} can be.
 */
public class ThiefTest {
  private Thief thief1;
  private Thief thief1_copia;
  private Thief thief2;
  private Thief thief3;
  private Thief thief_arma;
  
  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    
    thief1= new Thief("Sly Cooper", 80, 100, queue);
    thief1_copia= new Thief("Sly Cooper", 80, 100, queue);
    thief2= new Thief("Kaz Brekker", 1, 1,queue);
    thief3= new Thief("Capone", 1000, 1000, queue);
    thief_arma= new Thief("Draktarr", 10, 10, queue);
  }
  @Test
  public void testTestHashCode() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
  
    assertEquals(thief1.hashCode(),thief1_copia.hashCode());
  
    Thief hashthief= new Thief("Kaz Brekker", 1, 1, queue);
    assertEquals(thief2.hashCode(),hashthief.hashCode());
  
    assertNotEquals(thief3.hashCode(),thief_arma.hashCode());
    assertNotEquals(thief1.hashCode(),thief_arma.hashCode());
  }
  
  @Test
  public void testTestEquals() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    
    assertTrue(thief1.equals(thief1_copia));
  
    Thief eqthief= new Thief("Kaz Brekker", 1, 1, queue);
    assertTrue(thief2.equals(eqthief));
    
    assertFalse(thief2.equals(thief3));
    assertFalse(thief3.equals(thief_arma));
    assertTrue(thief1.equals(thief1));
    assertFalse(thief_arma.equals(new Engineer("Draktarr", 10, 10, queue)));
    
  }
  
  @Test
  public void testTestToString() {
    assertEquals(thief1.toString(),thief1_copia.toString());
    assertEquals("Thief{maxHp=1, defense=1, name='Kaz Brekker'}",thief2.toString());
    assertNotEquals("Thif{maxHp=1000, defense=1000, name='Capone'}",thief3.toString());
    assertNotEquals(thief_arma.toString(),thief3.toString());
  }
}