package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeaponType;
import cl.uchile.dcc.finalreality.model.weapon.NormalWeapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

/**
 * The {@link EngineerTest} class exists to test every method created in the {@link Engineer} class,
 * setting up different scenarios where an {@link Engineer} can be.
 * <p>In this specific Test class are also tested the methods from the PlayerCharacter
 * class that involve different attributes from a PlayerCharacter, such as the getters and
 * setter of an attribute and so on.
 */
public class EngineerTest  {
  private Engineer ingeniero1;
  private Engineer ingeniero1_copia;
  private Engineer ingeniero2;
  private Engineer ingeniero3;
  private Engineer ingeniero_arma;
  private NormalWeapon hacha;
  private NormalWeapon arco;
  private NormalWeapon cuchillo;
  private MagicWeapon baculo;
  
  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    
    ingeniero1= new Engineer("Forestin", 80, 100, queue);
    ingeniero1_copia= new Engineer("Forestin", 80, 100, queue);
    ingeniero2= new Engineer("Industrial", 1, 1,queue);
    ingeniero3= new Engineer("Turing", 1000, 1000, queue);
    ingeniero_arma= new Engineer("Draktarr", 10, 10, queue);
    
    baculo= new MagicWeapon("Baculo Test",10,1,
          MagicWeaponType.STAFF,100);
    cuchillo= new NormalWeapon("Draktarr",10,1,WeaponType.KNIFE);
    hacha=new NormalWeapon("Leviatan",10 ,10,WeaponType.AXE);
    arco=new NormalWeapon("Yumi", 10 ,10,WeaponType.BOW);
    
  }
  
  @Test
  public void testSetANDGetEquippedWeapon() throws InvalidStatValueException {
    ingeniero1.equip(cuchillo);
    ingeniero2.equip(baculo);
    assertNotEquals(new NormalWeapon("Draktarr",10,1,WeaponType.KNIFE),ingeniero1.getEquippedWeapon());
    assertNotEquals(new MagicWeapon("Baculo Test",10,1, MagicWeaponType.STAFF,100),ingeniero2.getEquippedWeapon());
    
    ingeniero1.equip(hacha);
    ingeniero2.equip(arco);
    assertEquals(new NormalWeapon("Leviatan",10 ,10,WeaponType.AXE),ingeniero1.getEquippedWeapon());
    assertEquals(arco,ingeniero2.getEquippedWeapon());
    
    ingeniero1.equip(arco);
    assertEquals(ingeniero1.getEquippedWeapon(),ingeniero2.getEquippedWeapon());
  }
  
  
  
  @Test
  public void testTestGetName() {
    assertEquals("Industrial", ingeniero2.getName());
    assertEquals("Turing", ingeniero3.getName());
    assertEquals(ingeniero1.getName(),ingeniero1_copia.getName());
    assertNotEquals(ingeniero1.getName(),ingeniero2.getName());
    assertNotEquals(ingeniero2.getName(),ingeniero3.getName());
    
    assertEquals(ingeniero_arma.getName(),cuchillo.getName());
    
  }
  
  @Test
  public void testGetMaxHp() {
    assertEquals(80, ingeniero1.getMaxHp());
    assertEquals(1000, ingeniero3.getMaxHp());
    assertNotEquals(5,ingeniero_arma.getMaxHp());
    assertNotEquals(ingeniero2.getMaxHp(), ingeniero1_copia.getMaxHp());
  }
  
  @Test
  public void testGetDefense() {
    assertEquals(100, ingeniero1.getDefense());
    assertEquals(1000, ingeniero3.getDefense());
    assertNotEquals(5,ingeniero_arma.getDefense());
    assertNotEquals(ingeniero2.getDefense(), ingeniero1_copia.getDefense());
  }
  
  @Test
  public void testSetANDGetCurrentHp() throws InvalidStatValueException {
    ingeniero1.setCurrentHp(40);
    assertEquals(40,ingeniero1.getCurrentHp());
    
    ingeniero2.setCurrentHp(0);
    assertEquals(0,ingeniero2.getCurrentHp());
    
    ingeniero3.setCurrentHp(500);
    ingeniero_arma.setCurrentHp(5);
    assertNotEquals(ingeniero_arma.getCurrentHp(),ingeniero3.getCurrentHp());
    
    ingeniero1_copia.setCurrentHp(20);
    ingeniero3.setCurrentHp(20);
    assertEquals(ingeniero1_copia.getCurrentHp(),ingeniero3.getCurrentHp());
    
  }
  
  @Test
  public void testTestToString() {
    assertEquals(ingeniero1_copia.toString(),ingeniero1.toString());
    assertEquals("Engineer{maxHp=1, defense=1, name='Industrial'}",ingeniero2.toString());
    assertNotEquals(ingeniero_arma.toString(),ingeniero3.toString());
    assertNotEquals("Engineer{maxHp=80, defense=100, name='NotForestin'}",ingeniero1.toString());
  }
  
  @Test
  public void testTestHashCode() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    
    assertEquals(ingeniero1.hashCode(),ingeniero1_copia.hashCode());
    Engineer hashingeniero= new Engineer("Turing", 1000, 1000, queue);
    assertEquals(hashingeniero.hashCode(),ingeniero3.hashCode());
  
    Engineer NOThashingeniero= new Engineer("Turing", 1000, 10, queue);
    assertNotEquals(ingeniero2.hashCode(),ingeniero_arma.hashCode());
    assertNotEquals(hashingeniero.hashCode(),NOThashingeniero.hashCode());
  }
  
  @Test
  public void testTestEquals() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    
    assertTrue(ingeniero1.equals(ingeniero1_copia));
  
    Engineer eqingeniero= new Engineer("Turing", 1000, 1000, queue);
    assertTrue(eqingeniero.equals(ingeniero3));
    
    assertFalse(ingeniero2.equals(ingeniero3));
    assertFalse(ingeniero_arma.equals(cuchillo));
    assertTrue(ingeniero1.equals(ingeniero1));
  }
}