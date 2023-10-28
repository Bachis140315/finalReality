package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

/**
 * The {@link KnightTest} class exists to test every method created in the {@link Knight} class,
 * setting up different scenarios where a {@link Knight} can be.
 */
public class KnightTest  {
  private Knight knight1;
  private Knight knight1_copia;
  private Knight knight2;
  private Knight knight3;
  private Knight knight_arma;
  @Before
  public void setUp() throws Exception {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
  
    knight1= new Knight("Garen", 80, 100, queue);
    knight1_copia= new Knight("Garen", 80, 100, queue);
    knight2= new Knight("Ricardo", 1, 1,queue);
    knight3= new Knight("Wallace", 1000, 1000, queue);
    knight_arma= new Knight("Draktarr", 10, 10, queue);
    
  }
  
  @Test
  public void testTestToString() {
    assertEquals(knight1.toString(),knight1_copia.toString());
    assertEquals("Knight{maxHp=1, defense=1, name='Ricardo'}",knight2.toString());
    assertEquals("Knight{maxHp=1000, defense=1000, name='Wallace'}",knight3.toString());
    assertNotEquals("Knight{maxHp=10, defense=10, name='False Draktarr'}",knight_arma.toString());
    assertNotEquals(knight2.toString(),knight1.toString());
  }
  
  @Test
  public void testTestHashCode() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
  
    assertEquals(knight1.hashCode(),knight1_copia.hashCode());
    
    Knight hashknight= new Knight("Ricardo", 1, 1, queue);
    assertEquals(knight2.hashCode(),hashknight.hashCode());
    
    assertNotEquals(knight3.hashCode(),knight_arma.hashCode());
    assertNotEquals(knight1_copia.hashCode(),knight_arma.hashCode());
  }
  
  @Test
  public void testTestEquals() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    
    assertTrue(knight1.equals(knight1_copia));
  
    Knight eqknight= new Knight("Ricardo", 1, 1, queue);
    assertTrue(knight2.equals(eqknight));
    
    assertFalse(knight3.equals(knight_arma));
    assertFalse(knight1_copia.equals(knight3));
    assertTrue(knight1.equals(knight1));
    assertFalse(knight_arma.equals(new Thief("Draktarr", 10, 10, queue)));
    
  }
}