package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.Knight;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The {@link EnemyTest} class exists to test every method created in the {@link Enemy} class
 * and its superclass, setting up different scenarios where a {@link Enemy} can be.
 */

public class EnemyTest {
  private Enemy enemigo;
  private Enemy enemigo_copia;
  private Enemy enemigo_2;
  private Enemy enemigo_3;
  private Enemy enemigo_sin_nombre;

  
  
  
  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    
    enemigo= new Enemy("Sargento 1",11,100,10, queue, 1);
    enemigo_copia= new Enemy("Sargento 1",11,100,10, queue, 1);
    enemigo_2= new Enemy("Cabo 3", 1111, 50, 5, queue, 1);
    enemigo_3= new Enemy("Sargento 2", 1111 ,10, 1, queue, 1);
    enemigo_sin_nombre= new Enemy("", 1, 1000, 2, queue, 1);
    
  }
  
  
  @Test
  public void testGetName() {
    assertEquals("Sargento 1", enemigo.getName());
    assertEquals("Cabo 3", enemigo_2.getName());
    assertNotEquals(enemigo.getName(),enemigo_3.getName());
    assertNotEquals(enemigo_sin_nombre.getName(), enemigo_2.getName());
    assertEquals(enemigo.getName(),enemigo_copia.getName());
    
  }
  
  @Test
  public void testGetCurrentHp() {
    assertEquals(100, enemigo.getCurrentHp());
    assertEquals(50, enemigo_2.getCurrentHp());
    assertNotEquals(enemigo.getCurrentHp(),enemigo_3.getCurrentHp());
    assertNotEquals(enemigo_sin_nombre.getCurrentHp(), enemigo_2.getCurrentHp());
    assertEquals(enemigo.getCurrentHp(),enemigo_copia.getCurrentHp());
    
  }
  
  @Test
  public void testGetMaxHp() {
    assertEquals(100, enemigo.getCurrentHp());
    assertEquals(50, enemigo_2.getCurrentHp());
    assertNotEquals(enemigo.getCurrentHp(),enemigo_3.getCurrentHp());
    assertNotEquals(enemigo_sin_nombre.getCurrentHp(), enemigo_2.getCurrentHp());
    assertEquals(enemigo.getCurrentHp(),enemigo_copia.getCurrentHp());
  }
  
  @Test
  public void testGetDefense() {
    assertEquals(10, enemigo.getDefense());
    assertEquals(5, enemigo_2.getDefense());
    assertNotEquals(enemigo.getDefense(),enemigo_3.getDefense());
    assertNotEquals(enemigo_sin_nombre.getDefense(), enemigo_2.getDefense());
    assertEquals(enemigo.getDefense(),enemigo_copia.getDefense());
  }
  
  @Test
  public void testSetCurrentHp() throws InvalidStatValueException {
    enemigo.setCurrentHp(27);
    enemigo_2.setCurrentHp(0);
    enemigo_3.setCurrentHp(6);
    enemigo_copia.setCurrentHp(27);
    enemigo_sin_nombre.setCurrentHp(55);
    
    assertEquals(55,enemigo_sin_nombre.getCurrentHp());
    assertEquals(enemigo.getCurrentHp(),enemigo_copia.getCurrentHp());
    assertNotEquals(enemigo_copia.getCurrentHp(),enemigo_sin_nombre.getCurrentHp());
    assertNotEquals(enemigo_2.getCurrentHp(),enemigo_3.getCurrentHp());
  }
  
  @Test
  public void testGetWeight() {
    assertEquals(1,enemigo_sin_nombre.getWeight());
    assertEquals(enemigo_copia.getWeight(),enemigo.getWeight());
    assertNotEquals(enemigo.getWeight(),enemigo_3.getWeight());
    assertNotEquals(enemigo_sin_nombre.getWeight(), enemigo_2.getWeight());
    assertEquals(enemigo_2.getWeight(),enemigo_3.getWeight());
    
  }
  
  @Test
  public void testTestEquals() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    assertTrue("Son iguales",enemigo.equals(enemigo_copia));
    assertFalse("No son iguales ni en nombre, ni maxHP ni defensa",enemigo_2.equals(enemigo_3));
    assertFalse("No son iguales en nada", enemigo_sin_nombre.equals(enemigo));
    assertTrue("Son iguales",enemigo.equals(enemigo));
    assertFalse("Son iguales",enemigo.equals(new Knight("Sargento 1",11,100,queue)));
    
  }
  
  @Test
  public void testTestHashCode() {
    assertEquals(enemigo.hashCode(),enemigo_copia.hashCode());
    assertNotEquals(enemigo_2.hashCode(), enemigo_3.hashCode());
    assertNotEquals(enemigo_sin_nombre.hashCode(),enemigo.hashCode());
  }
}