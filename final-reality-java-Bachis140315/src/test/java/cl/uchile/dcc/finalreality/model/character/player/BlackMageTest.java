package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

/**
 * The {@link BlackMageTest} class exists to test every method created in the {@link BlackMage} class,
 * setting up different scenarios where a {@link BlackMage} can be.
 * <p>In this specific Test class are also tested the methods from the MagicalPlayerCharacter
 * class that involves the MP attribute.
 */

public class BlackMageTest {
  private BlackMage blackmage1;
  private BlackMage blackmage1_copia;
  private BlackMage blackmage2;
  private BlackMage blackmage3;
  private BlackMage blackmage_arma;
  
  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
  
    blackmage1= new BlackMage("Mago Oscuro", 80, 100,queue,60);
    blackmage1_copia= new BlackMage("Mago Oscuro", 80, 100, queue,60);
    blackmage2= new BlackMage("Voldemort", 1, 1,queue,100);
    blackmage3= new BlackMage("Grindelwald", 1000, 1000, queue,500);
    blackmage_arma= new BlackMage("Draktarr", 10, 10, queue,222);
    
  }
  
  @Test
  public void testSetANDGetCurrentMp() throws InvalidStatValueException {
    assertEquals(blackmage1.getCurrentMp(),blackmage1_copia.getCurrentMp());
    blackmage1.setCurrentMp(33);
    assertNotEquals(blackmage1_copia.getCurrentMp(),blackmage1.getCurrentMp());
    
    blackmage3.setCurrentMp(100);
    assertEquals(blackmage3.getCurrentMp(),blackmage2.getCurrentMp());
    assertNotEquals(blackmage2.getCurrentMp(),blackmage_arma.getCurrentMp());
    
  }
  
  @Test
  public void testGetMaxMp() {
    assertEquals(blackmage1_copia.getMaxMp(), blackmage1.getMaxMp());
    assertEquals(100,blackmage2.getMaxMp());
    assertNotEquals(blackmage_arma.getMaxMp(),blackmage2.getMaxMp());
    assertNotEquals(blackmage2.getMaxMp(),blackmage3.getMaxMp());
    
  }
  
  @Test
  public void testTestEquals() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
  
    assertTrue(blackmage1.equals(blackmage1_copia));
    
    BlackMage eqblackmage= new BlackMage("Voldemort",1,1,queue,100);
    assertTrue(blackmage2.equals(eqblackmage));
    
    assertFalse(blackmage2.equals(blackmage3));
    assertFalse(blackmage3.equals(blackmage_arma));
    assertTrue(blackmage_arma.equals(blackmage_arma));
    assertFalse(blackmage1.equals(new WhiteMage("Mago Oscuro", 80, 100,queue,60)));
  }
  
  @Test
  public void testTestToString() {
    assertEquals("BlackMage{currentMp=60, maxMp=60, maxHp=80, defense=100, name='Mago Oscuro'}",blackmage1.toString());
    assertEquals("BlackMage{currentMp=222, maxMp=222, maxHp=10, defense=10, name='Draktarr'}",blackmage_arma.toString());
    assertNotEquals("BlackMage{currentMp=500, maxMp=500, maxHp=0, defense=1000, name='Grindelwald'}",blackmage3.toString());
    assertNotEquals(blackmage1_copia.toString(),blackmage2.toString());
  }
  
  @Test
  public void testTestHashCode() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    
    assertEquals(blackmage1.hashCode(),blackmage1_copia.hashCode());
    assertEquals((new BlackMage("Voldemort", 1, 1,queue,100)).hashCode(),blackmage2.hashCode());
    assertNotEquals(blackmage3.hashCode(),blackmage_arma.hashCode());
    assertNotEquals(blackmage1_copia.hashCode(),blackmage2.hashCode());
  }
}